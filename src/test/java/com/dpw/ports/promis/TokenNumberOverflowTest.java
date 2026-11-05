package com.dpw.ports.promis;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TokenNumberOverflowTest {
    private static final String[] VALUES = {"2147483647", "2147483648", "9223372036854775808",
            "99999999999999999999999999999999999999"};

    @Test void tokenCursorMappingsReadWithoutNarrowingAndPreserveJsonDigits() throws Exception {
        var config = new MigrationTest().mappings();
        var json = new ObjectMapper();
        int checked = 0;
        for (String id : config.getResultMapNames()) {
            if (!id.startsWith("hht.")) continue;
            var map = config.getResultMap(id);
            for (var mapping : map.getResultMappings()) {
                if (!mapping.getProperty().equalsIgnoreCase("tokenno")) continue;
                for (String digits : VALUES) {
                    var rs = mock(ResultSet.class);
                    when(rs.getInt(mapping.getColumn())).thenThrow(new SQLException("ORA-17026: Numeric overflow"));
                    when(rs.getLong(mapping.getColumn())).thenThrow(new SQLException("ORA-17026: Numeric overflow"));
                    when(rs.getBigDecimal(mapping.getColumn())).thenReturn(new BigDecimal(digits));
                    when(rs.getString(mapping.getColumn())).thenReturn(digits);
                    Object value = mapping.getTypeHandler().getResult(rs, mapping.getColumn());
                    assertEquals(digits, value.toString(), id);
                    Object bean = map.getType().getDeclaredConstructor().newInstance();
                    config.newMetaObject(bean).setValue(mapping.getProperty(), value);
                    var encoded = json.readTree(json.writeValueAsString(bean));
                    assertEquals(digits, encoded.get(mapping.getProperty()).asText(), id);
                    Object decoded = json.readValue(json.writeValueAsString(bean), map.getType());
                    assertEquals(value, config.newMetaObject(decoded).getValue(mapping.getProperty()), id);
                    verify(rs, never()).getInt(anyString());
                    verify(rs, never()).getLong(anyString());
                }
                var empty = mock(ResultSet.class);
                when(empty.wasNull()).thenReturn(true);
                assertNull(mapping.getTypeHandler().getResult(empty, mapping.getColumn()));
                checked++;
            }
        }
        assertTrue(checked >= 8, "Expected all token cursor result mappings");
    }

    @SuppressWarnings("unchecked")
    @Test void numericTokenParametersBindAsExactOracleNumbers() throws Exception {
        var config = new MigrationTest().mappings();
        int checked = 0;
        for (String id : config.getMappedStatementNames()) {
            if (!id.startsWith("hht.")) continue;
            for (var mapping : config.getMappedStatement(id).getBoundSql(new HashMap<>()).getParameterMappings()) {
                if (!mapping.getProperty().replace("_", "").equalsIgnoreCase("tokenno")
                        && !mapping.getProperty().equals("PI_TOKEN_NO")) continue;
                if (mapping.getJdbcType() == JdbcType.VARCHAR) continue;
                assertEquals(JdbcType.NUMERIC, mapping.getJdbcType(), id);
                assertEquals(BigInteger.class, mapping.getJavaType(), id);
                for (String digits : VALUES) {
                    var statement = mock(PreparedStatement.class);
                    ((TypeHandler<BigInteger>) mapping.getTypeHandler()).setParameter(statement, 1,
                            new BigInteger(digits), JdbcType.NUMERIC);
                    verify(statement).setBigDecimal(1, new BigDecimal(digits));
                    verify(statement, never()).setInt(anyInt(), anyInt());
                    verify(statement, never()).setLong(anyInt(), anyLong());
                }
                checked++;
            }
        }
        assertEquals(8, checked);
    }
}
