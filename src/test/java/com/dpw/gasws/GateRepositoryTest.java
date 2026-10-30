package com.dpw.gasws;

import com.dpw.gasws.api.Requests;
import com.dpw.gasws.repository.GateRepository;
import com.dpw.gasws.repository.ProcedureRejectedException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class GateRepositoryTest {
    DataSource dataSource = mock(DataSource.class);
    Connection connection = mock(Connection.class);
    OracleConnection oracle = mock(OracleConnection.class);
    CallableStatement call = mock(CallableStatement.class);
    GateRepository repository;

    @BeforeEach void setUp() throws Exception {
        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareCall(anyString())).thenReturn(call);
        when(connection.unwrap(OracleConnection.class)).thenReturn(oracle);
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.setQueryTimeout(30);
        repository = new GateRepository(jdbc, "GAS_WEB_SERVICE_INTERFACE", "CAMCO_CONTR_OBJ", "TBL_CAMCO_CONTR_OBJ");
    }

    @Test void tokensPreserveInOutParametersAndCursorDates() throws Exception {
        ResultSet cursor = mock(ResultSet.class);
        when(call.getObject(5)).thenReturn(cursor);
        when(cursor.next()).thenReturn(true, false);
        when(cursor.getString("token_no")).thenReturn("00042");
        Timestamp time = Timestamp.valueOf("2026-10-30 08:00:00");
        when(cursor.getTimestamp("lv_start_time")).thenReturn(time);
        when(call.getString(2)).thenReturn("00123");
        when(call.getString(3)).thenReturn("DXB");
        var result = repository.tokens("T1", "rfid", null, null);
        assertThat(result.truckNo()).isEqualTo("00123");
        assertThat(result.tokenDetails()).hasSize(1);
        assertThat(result.tokenDetails().getFirst().getTokenNo()).isEqualTo("00042");
        assertThat(result.tokenDetails().getFirst().getStartTime()).isEqualTo(time);
        verify(call).registerOutParameter(2, Types.VARCHAR);
        verify(call).registerOutParameter(3, Types.VARCHAR);
        verify(call).setQueryTimeout(30);
        verify(cursor).close();
        verify(call).close();
        verify(connection).close();
    }

    @Test void eirBindsTwelveParametersAndCreatesObjectsOnSameConnection() throws Exception {
        Array array = mock(Array.class);
        Struct struct = mock(Struct.class);
        when(oracle.createStruct(eq("CAMCO_CONTR_OBJ"), any(Object[].class))).thenReturn(struct);
        when(oracle.createOracleArray(eq("TBL_CAMCO_CONTR_OBJ"), any())).thenReturn(array);
        ResultSet eirCursor = mock(ResultSet.class);
        ResultSet locCursor = mock(ResultSet.class);
        when(call.getObject(10)).thenReturn(eirCursor);
        when(call.getObject(11)).thenReturn(locCursor);
        when(eirCursor.next()).thenReturn(true, false);
        when(locCursor.next()).thenReturn(true, false);
        when(eirCursor.getString("MOVE_TYPE")).thenReturn("IN");
        when(eirCursor.getString("print_eir")).thenReturn("Y");
        when(locCursor.getString("LOCATION")).thenReturn("YARD-A");
        Requests.Eir request = new Requests.Eir(null, "rfid", "00123", "DXB", "3", "2IB01", "visit",
                List.of(new Requests.Token("001"), new Requests.Token("002")),
                List.of(new Requests.Container("ABCD1234567", "2200", "front", "2", "1", "Y")));
        var result = repository.eir(request);
        assertThat(result.eirDetails()).hasSize(1);
        assertThat(result.eirDetails().getFirst().getMovType()).isEqualTo("IN");
        assertThat(result.eirDetails().getFirst().getPrintEir()).isEqualTo("Y");
        assertThat(result.locDetails().getFirst().getLocation()).isEqualTo("YARD-A");
        verify(eirCursor).close();
        verify(locCursor).close();
        verify(connection).prepareCall("{call GAS_WEB_SERVICE_INTERFACE.GET_EIR_LOC_DATA(?,?,?,?,?,?,?,?,?,?,?,?)}");
        ArgumentCaptor<Object[]> attributes = ArgumentCaptor.forClass(Object[].class);
        verify(oracle).createStruct(eq("CAMCO_CONTR_OBJ"), attributes.capture());
        assertThat(attributes.getValue()).containsExactly("ABCD1234567", "2200", "front", "2", "1", "Y");
        verify(call).setString(1, "J");
        verify(call).setString(5, "001,002");
        verify(call).setString(6, "3");
        verify(call).setArray(7, array);
        verify(call).registerOutParameter(10, OracleTypes.CURSOR);
        verify(call).registerOutParameter(11, OracleTypes.CURSOR);
        var order = inOrder(oracle, call, array, connection);
        order.verify(oracle).createOracleArray(eq("TBL_CAMCO_CONTR_OBJ"), any());
        order.verify(call).execute();
        order.verify(call).close();
        order.verify(array).free();
        order.verify(connection).close();
        verify(dataSource, times(1)).getConnection();
    }

    @Test void eirFreesArrayAndDoesNotRetryOnFailure() throws Exception {
        Array array = mock(Array.class);
        when(oracle.createOracleArray(eq("TBL_CAMCO_CONTR_OBJ"), any())).thenReturn(array);
        when(call.execute()).thenThrow(new SQLException("connection lost", "08006"));
        assertThatThrownBy(() -> repository.eir(new Requests.Eir(null, null, null, null, null, "lane", null, null, null)))
                .isInstanceOf(DataAccessException.class);
        verify(array).free();
        verify(call).close();
        verify(dataSource, times(1)).getConnection();
    }

    @Test void businessErrorIsNotReturnedAsSuccess() throws Exception {
        when(call.getString(3)).thenReturn("private Oracle details");
        assertThatThrownBy(() -> repository.containers("T1"))
                .isInstanceOf(ProcedureRejectedException.class)
                .hasMessageNotContaining("private Oracle details");
        verify(call).close();
    }

    @Test void exceptionProcedureBindsAllFieldsAndRunsOnce() throws Exception {
        repository.exception(new Requests.GateException("30-OCT-2026 08:00:00", "123", "DXB", "ABCD1234567", "1", "2IB01", "E1", "Camera unavailable"));
        verify(connection).prepareCall("{call GAS_WEB_SERVICE_INTERFACE.INS_CAMCO_EXCEPTION_DATA(?,?,?,?,?,?,?,?,?)}");
        verify(call).setString(1, "30-OCT-2026 08:00:00");
        verify(call).setString(8, "Camera unavailable");
        verify(call).registerOutParameter(9, Types.VARCHAR);
        verify(call, times(1)).execute();
    }
}
