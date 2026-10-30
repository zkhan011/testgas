package com.dpw.gasws.repository;

import com.dpw.gasws.api.Requests;
import com.dpw.gasws.api.Responses;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GateRepository {
    private final JdbcTemplate jdbc;
    private final String packageName;
    private final String objectType;
    private final String arrayType;

    public GateRepository(JdbcTemplate jdbc,
                          @Value("${gasws.oracle.package-name}") String packageName,
                          @Value("${gasws.oracle.object-type}") String objectType,
                          @Value("${gasws.oracle.array-type}") String arrayType) {
        this.jdbc = jdbc;
        this.packageName = identifier(packageName);
        this.objectType = identifier(objectType);
        this.arrayType = identifier(arrayType);
    }

    private static String identifier(String value) {
        if (!value.matches("[A-Za-z][A-Za-z0-9_$#]*(\\.[A-Za-z][A-Za-z0-9_$#]*)?")) {
            throw new IllegalArgumentException("Invalid Oracle package/type identifier");
        }
        return value;
    }

    public Responses.Tokens tokens(String terminalId, String rfIdNo, String truckNo, String regPlace) {
        return jdbc.execute((ConnectionCallback<Responses.Tokens>) connection -> {
            try (var call = prepare(connection, "GET_TOKEN_DATA", 6)) {
                call.setString(1, rfIdNo);
                call.setString(2, truckNo);
                call.registerOutParameter(2, Types.VARCHAR);
                call.setString(3, regPlace);
                call.registerOutParameter(3, Types.VARCHAR);
                call.setString(4, terminalId);
                call.registerOutParameter(5, OracleTypes.CURSOR);
                call.registerOutParameter(6, Types.VARCHAR);
                call.execute();
                checkError(call, 6);
                return new Responses.Tokens(cursor(call, 5, CursorMappers.TOKEN), call.getString(2), call.getString(3));
            }
        });
    }

    public Responses.Containers containers(String terminalId) {
        return jdbc.execute((ConnectionCallback<Responses.Containers>) connection -> {
            try (var call = prepare(connection, "GET_CONTAINER_DATA", 3)) {
                call.setString(1, terminalId);
                call.registerOutParameter(2, OracleTypes.CURSOR);
                call.registerOutParameter(3, Types.VARCHAR);
                call.execute();
                checkError(call, 3);
                return new Responses.Containers(cursor(call, 2, CursorMappers.CONTAINER));
            }
        });
    }

    public Responses.Eir eir(Requests.Eir request) {
        return jdbc.execute((ConnectionCallback<Responses.Eir>) connection -> {
            // Array and statement must belong to the same physical Oracle connection.
            OracleConnection oracle = connection.unwrap(OracleConnection.class);
            Struct[] objects = new Struct[request.contrDetails().size()];
            for (int i = 0; i < objects.length; i++) {
                var c = request.contrDetails().get(i);
                objects[i] = oracle.createStruct(objectType, new Object[]{c.containerNo(), c.isoCode(),
                        c.doorDirection(), c.contrPosition(), c.chassisNo(), c.sealPresence()});
            }
            try (var resource = new ArrayResource(oracle.createOracleArray(arrayType, objects))) {
                Array array = resource.value();
                try (var call = prepare(connection, "GET_EIR_LOC_DATA", 12)) {
                    call.setString(1, request.portCode());
                    call.setString(2, request.rfIdNo());
                    call.setString(3, request.truckNo());
                    call.setString(4, request.regPlace());
                    String tokens = request.tokenDetails().stream().map(Requests.Token::tokenNo)
                            .collect(Collectors.joining(","));
                    call.setString(5, tokens.isEmpty() ? null : tokens);
                    call.setString(6, request.chassisType());
                    call.setArray(7, array);
                    call.setString(8, request.laneId());
                    call.setString(9, request.visitId());
                    call.registerOutParameter(10, OracleTypes.CURSOR);
                    call.registerOutParameter(11, OracleTypes.CURSOR);
                    call.registerOutParameter(12, Types.VARCHAR);
                    call.execute();
                    checkError(call, 12);
                    return new Responses.Eir(cursor(call, 10, CursorMappers.EIR), cursor(call, 11, CursorMappers.LOCATION));
                }
            }
        });
    }

    public void exception(Requests.GateException request) {
        jdbc.execute((ConnectionCallback<Void>) connection -> {
            try (var call = prepare(connection, "INS_CAMCO_EXCEPTION_DATA", 9)) {
                call.setString(1, request.errorDate());
                call.setString(2, request.truckNo());
                call.setString(3, request.regPlace());
                call.setString(4, request.containerNo());
                call.setString(5, request.tokenNo());
                call.setString(6, request.laneId());
                call.setString(7, request.errorCode());
                call.setString(8, request.errorDesc());
                call.registerOutParameter(9, Types.VARCHAR);
                call.execute();
                checkError(call, 9);
            }
            return null;
        });
    }

    private record ArrayResource(Array value) implements AutoCloseable {
        @Override public void close() throws SQLException { value.free(); }
    }

    private CallableStatement prepare(Connection connection, String procedure, int count) throws SQLException {
        String parameters = String.join(",", java.util.Collections.nCopies(count, "?"));
        // JdbcTemplate's connection proxy applies the configured timeout to prepared statements.
        return connection.prepareCall("{call " + packageName + "." + procedure + "(" + parameters + ")}");
    }

    private static void checkError(CallableStatement call, int index) throws SQLException {
        String error = call.getString(index);
        if (error != null && !error.isBlank()) {
            // Raw Oracle text may contain implementation details; never expose it to clients.
            throw new ProcedureRejectedException();
        }
    }

    private static <T> List<T> cursor(CallableStatement call, int index, RowMapper<T> mapper) throws SQLException {
        List<T> values = new ArrayList<>();
        try (ResultSet rs = (ResultSet) call.getObject(index)) {
            if (rs != null) {
                int row = 0;
                while (rs.next()) values.add(mapper.mapRow(rs, row++));
            }
        }
        return values;
    }
}
