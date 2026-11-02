package com.dpw;

import com.dpw.gasws.repository.GateRepository;
import com.dpw.gasws.api.Responses;
import com.dpw.ports.promis.hht.service.HhtService;
import com.dpw.ports.promis.hht.type.MajorDamageFlagResType;
import com.dpw.ports.promis.aqoperations.service.DBManagerServiceImpl;
import com.dpw.ports.promis.aqoperations.service.ManageVoyageServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = {"gate.security.api-key=client-key-for-combined-tests-12345",
        "gate.security.admin-key=admin-key-for-combined-tests-12345", "gasws.security.username=gas-test"})
@AutoConfigureMockMvc
class CombinedApplicationTest {
    static final String CLIENT = "client-key-for-combined-tests-12345";
    static final String ADMIN = "admin-key-for-combined-tests-12345";
    @DynamicPropertySource static void credentials(DynamicPropertyRegistry registry) {
        registry.add("gasws.security.password-hash", () ->
                new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("test-password"));
    }
    @Autowired MockMvc mvc;
    @Autowired @Qualifier("requestMappingHandlerMapping") RequestMappingHandlerMapping mappings;
    @MockitoBean HhtService hht;
    @MockitoBean GateRepository gas;
    @MockitoBean DBManagerServiceImpl schedulers;
    @MockitoBean ManageVoyageServiceImpl voyages;

    @Test void allFiftyRoutesShareOneApplication() throws Exception {
        var controllers = Set.of(com.dpw.gasws.api.GateController.class,
                com.dpw.ports.promis.web.HhtController.class,
                com.dpw.ports.promis.web.VoyageController.class,
                com.dpw.ports.promis.web.SchedulerController.class);
        long count = mappings.getHandlerMethods().values().stream()
                .filter(handler -> controllers.contains(handler.getBeanType())).count();
        assertThat(count).isEqualTo(50);
        var actual = new java.util.HashSet<String>();
        mappings.getHandlerMethods().forEach((mapping, handler) -> {
            if (controllers.contains(handler.getBeanType())) {
                assertThat(mapping.getMethodsCondition().getMethods())
                        .containsExactly(org.springframework.web.bind.annotation.RequestMethod.POST);
                assertThat(mapping.getConsumesCondition().getConsumableMediaTypes())
                        .contains(org.springframework.http.MediaType.APPLICATION_JSON);
                actual.addAll(mapping.getPatternValues());
            }
        });
        var json = new com.fasterxml.jackson.databind.ObjectMapper();
        var expected = new java.util.HashSet<String>();
        for (var operation : json.readTree(java.nio.file.Files.readString(java.nio.file.Path.of("docs/combined-endpoint-mapping.json")))) {
            assertThat(operation.get("method").asText()).isEqualTo("POST");
            assertThat(operation.get("path").asText()).isEqualTo("/api/v1/" + operation.get("operation").asText());
            expected.add(operation.get("path").asText());
        }
        assertThat(actual).isEqualTo(expected);
        var openapi = json.readTree(getClass().getResourceAsStream("/static/openapi.json"));
        var documented = new java.util.HashSet<String>();
        openapi.get("paths").fields().forEachRemaining(entry -> {
            assertThat(entry.getValue().has("post")).isTrue();
            documented.add(entry.getKey());
        });
        assertThat(documented).isEqualTo(expected);
    }

    @Test void hhtRequiresApiKeyAndBasicCannotBypassIt() throws Exception {
        mvc.perform(post("/api/v1/getMajorDamageFlag").contentType("application/json").content("{}")).andExpect(status().isUnauthorized());
        mvc.perform(post("/api/v1/getMajorDamageFlag").contentType("application/json").content("{}").with(httpBasic("gas-test", "test-password")))
                .andExpect(status().isUnauthorized());
        verifyNoInteractions(hht);
        when(hht.getMajorDamageFlag()).thenReturn(new MajorDamageFlagResType());
        mvc.perform(post("/api/v1/getMajorDamageFlag").contentType("application/json").content("{}").header("X-API-Key", CLIENT))
                .andExpect(status().isOk());
    }

    @Test void gasRetainsBasicAuthAndApiKeyCannotBypassIt() throws Exception {
        mvc.perform(post("/api/v1/getContainerDetails").contentType("application/json").content("{\"terminalId\":\"T1\"}").header("X-API-Key", CLIENT))
                .andExpect(status().isUnauthorized());
        verifyNoInteractions(gas);
        when(gas.containers("T1")).thenReturn(new Responses.Containers(List.of()));
        mvc.perform(post("/api/v1/getContainerDetails").contentType("application/json").content("{\"terminalId\":\"T1\"}").with(httpBasic("gas-test", "test-password")))
                .andExpect(status().isOk()).andExpect(jsonPath("$.contrDetails").isEmpty());
    }

    @Test void schedulerRequiresAdminKeyIncludingPostCommands() throws Exception {
        mvc.perform(post("/api/v1/getConfiguredJobsForMarineAQ").contentType("application/json").content("{}").header("X-API-Key", CLIENT)).andExpect(status().isForbidden());
        mvc.perform(post("/api/v1/startScheduler").contentType("application/json").content("{\"name\":\"TEST_JOB\"}").header("X-API-Key", CLIENT)).andExpect(status().isForbidden());
        verifyNoInteractions(schedulers);
        when(schedulers.getConfiguredJobsForMarineAQ()).thenReturn(List.of("TEST_JOB"));
        mvc.perform(post("/api/v1/getConfiguredJobsForMarineAQ").contentType("application/json").content("{}").header("X-API-Key", ADMIN)).andExpect(status().isOk());
        mvc.perform(post("/api/v1/startScheduler").contentType("application/json").content("{\"name\":\"TEST_JOB\"}").header("X-API-Key", ADMIN)).andExpect(status().isOk());
        verify(schedulers).startScheduler("TEST_JOB");
    }

    @Test void voyagePathVariablesReachApiKeyProtectedController() throws Exception {
        mvc.perform(post("/api/v1/billVoyage").contentType("application/json").content("{\"twsId\":42}")).andExpect(status().isUnauthorized());
        mvc.perform(post("/api/v1/billVoyage").contentType("application/json").content("{\"twsId\":42}").header("X-API-Key", CLIENT)).andExpect(status().isOk());
        verify(voyages).billVoyage(42L);
    }
}
