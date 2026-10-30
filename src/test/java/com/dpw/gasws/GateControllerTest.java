package com.dpw.gasws;

import com.dpw.gasws.api.GateController;
import com.dpw.gasws.api.Requests;
import com.dpw.gasws.api.Responses;
import com.dpw.gasws.config.SecurityConfiguration;
import com.dpw.gasws.repository.GateRepository;
import com.dpw.gasws.repository.ProcedureRejectedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = GateController.class, properties = {
        "gasws.security.username=test",
        // BCrypt for 'password', used ONLY in tests.
        "gasws.security.password-hash=$2a$10$dXJ3SW6G7P50lGmMkkmwe.20M5z5GSWOR1OMLNjUwS4fQJpV3wB2a"})
@Import(SecurityConfiguration.class)
class GateControllerTest {
    @org.springframework.test.context.DynamicPropertySource
    static void credentials(org.springframework.test.context.DynamicPropertyRegistry properties) {
        properties.add("gasws.security.password-hash", () ->
                new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("test-password"));
    }

    @Autowired MockMvc mvc;
    @MockitoBean GateRepository repository;

    @Test void unauthenticatedRequestsCannotReachDatabase() throws Exception {
        mvc.perform(get("/api/v1/containers").param("terminalId", "T1")).andExpect(status().isUnauthorized());
        verifyNoInteractions(repository);
    }

    @Test void validBasicCredentialsAuthenticate() throws Exception {
        when(repository.containers("T1")).thenReturn(new Responses.Containers(List.of()));
        mvc.perform(get("/api/v1/containers").param("terminalId", "T1").with(httpBasic("test", "test-password")))
                .andExpect(status().isOk());
    }

    @Test void wrongBasicPasswordIsRejected() throws Exception {
        mvc.perform(get("/api/v1/containers").param("terminalId", "T1").with(httpBasic("test", "wrong")))
                .andExpect(status().isUnauthorized());
        verifyNoInteractions(repository);
    }

    @Test void emptyContainerSearchIsSuccessful() throws Exception {
        when(repository.containers("T1")).thenReturn(new Responses.Containers(List.of()));
        mvc.perform(get("/api/v1/containers").param("terminalId", "T1").with(user("test").roles("GATE")))
                .andExpect(status().isOk()).andExpect(jsonPath("$.contrDetails").isEmpty());
    }

    @Test void blankTerminalAndMissingVehicleAreRejected() throws Exception {
        mvc.perform(get("/api/v1/containers").param("terminalId", " ").with(user("test").roles("GATE")))
                .andExpect(status().isBadRequest());
        mvc.perform(get("/api/v1/tokens").param("terminalId", "T1").with(user("test").roles("GATE")))
                .andExpect(status().isBadRequest());
        verifyNoInteractions(repository);
    }

    @Test void nestedInvalidContainerIsRejectedBeforeCallingOracle() throws Exception {
        mvc.perform(post("/api/v1/eir-location-requests").with(user("test").roles("GATE"))
                .contentType("application/json").content("""
                {"laneId":"2IB01","contrDetails":[{"containerNo":""}]}
                """))
                .andExpect(status().isBadRequest());
        verifyNoInteractions(repository);
    }

    @Test void eirAcceptsJsonWithoutLegacyCredentials() throws Exception {
        when(repository.eir(any())).thenReturn(new Responses.Eir(List.of(), List.of()));
        mvc.perform(post("/api/v1/eir-location-requests").with(user("test").roles("GATE"))
                .contentType("application/json").content("""
                {"laneId":"2IB01","truckNo":"00123","regPlace":"DXB"}
                """))
                .andExpect(status().isOk()).andExpect(jsonPath("$.eirDetails").isArray())
                .andExpect(jsonPath("$.locDetails").isArray());
        verify(repository).eir(argThat(r -> r.portCode().equals("J") && r.contrDetails().isEmpty()));
    }

    @Test void exceptionsReturnSuccessOnlyAfterProcedureCompletes() throws Exception {
        mvc.perform(post("/api/v1/gate-exceptions").with(user("test").roles("GATE"))
                .contentType("application/json").content("""
                {"errorDate":"30-OCT-2026 08:00:00","laneId":"2IB01","errorCode":"E1","errorDesc":"Test"}
                """))
                .andExpect(status().isOk()).andExpect(jsonPath("$.success").value(true));
        verify(repository).exception(any(Requests.GateException.class));
    }

    @Test void oracleBusinessFailureHasNonSuccessStatus() throws Exception {
        when(repository.containers("T1")).thenThrow(new ProcedureRejectedException());
        mvc.perform(get("/api/v1/containers").param("terminalId", "T1").with(user("test").roles("GATE")))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test void databaseFailuresDoNotExposeSqlAndHaveCorrelationId() throws Exception {
        when(repository.containers("T1")).thenThrow(new DataAccessResourceFailureException("secret database address"));
        mvc.perform(get("/api/v1/containers").param("terminalId", "T1").with(user("test").roles("GATE")))
                .andExpect(status().isServiceUnavailable()).andExpect(header().exists("X-Correlation-ID"))
                .andExpect(jsonPath("$.correlationId").exists())
                .andExpect(content().string(org.hamcrest.Matchers.not(org.hamcrest.Matchers.containsString("secret database address"))));
    }
}
