# Token number overflow correction

The HHT models previously mapped several Oracle `token_no` cursor columns to Java `Integer`. A token above 2,147,483,647 caused JDBC/MyBatis to read it through `getInt`, producing ORA-17026. Two DAO paths also rejected those values through `Integer.parseInt` before reaching Oracle.

Numeric token properties now use `BigInteger`, with MyBatis reading through `BigDecimal` and binding numeric procedure inputs as `NUMERIC`. This also avoids a second overflow at the Java `Long` limit. Existing string token properties, including GAS token identifiers, remain strings. No stored procedure names, parameter positions, endpoint URLs or JSON field names change. The 12 affected DTOs retain JSON integer values; OpenAPI no longer labels them int32.

Clients using 32-bit token types must widen them. JavaScript consumers must use a lossless JSON parser for numeric identifiers above 9,007,199,254,740,991. Java callers of changed DTO setters now supply `BigInteger`. String-valued token fields retain their original representation.

Regression tests exercise actual mapper-selected JDBC handlers at the int boundary, above the long boundary, at 38 digits, and for SQL NULL. They check exact JSON round trips and numeric parameter binding without getInt/getLong/setInt/setLong. Legacy procedure contract tests allow only the intentional token INTEGER-to-NUMERIC change; other parameter contracts remain checked.

Deploy the newly built `dpw-integration-rest-1.0.0.jar` and restart the service, then repeat the failing request against the real Oracle database. Tests use JDBC mocks; live database validation remains required. Oracle column/procedure precision still applies. This fix targets token identifiers and does not suppress unrelated numeric overflows or convert failed reads to zero/null.
