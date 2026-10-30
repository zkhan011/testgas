# Gate Automation REST Service — Java 21

Spring Boot 3.5.16 / Java 21 migration of the legacy GAS SOAP service. The Maven application calls the existing `GAS_WEB_SERVICE_INTERFACE` Oracle package through Spring JDBC. No Oracle package or schema changes are included.

## Build and run

Requirements: JDK 21, Maven 3.6.3+, and access to an Oracle database with the package and object types described below.

```bash
java -version
mvn clean verify
java -jar target/gasws-rest-1.0.0.jar --generate-password-hash
```

The last command securely prompts for an API password in an interactive terminal and prints its BCrypt hash without starting the server. Keep the password for your HTTP client.

Create an external `application-local.yml` (ignored by Git):

```yaml
gasws:
  database: promis
  security:
    username: gate-api
    password-hash: '$2a$10$REPLACE_WITH_THE_COMPLETE_GENERATED_BCRYPT_HASH'
  datasource:
    promis:
      url: jdbc:oracle:thin:@//YOUR_DB_HOST:1521/YOUR_SERVICE
      username: YOUR_DB_USER
      password: YOUR_DB_PASSWORD
    gold:
      url: jdbc:oracle:thin:@//YOUR_GOLD_HOST:1521/YOUR_SERVICE
      username: YOUR_GOLD_USER
      password: YOUR_GOLD_PASSWORD
```

```bash
java -jar target/gasws-rest-1.0.0.jar --spring.config.additional-location=file:./application-local.yml
```

All options, including pool sizes, query timeout and Oracle type names, are defined in `src/main/resources/application.yml`. You can configure them in an external YAML file; environment variables are optional. Startup intentionally fails when the API BCrypt hash is missing or malformed. No default API password is supplied. GOLD credentials are needed only when selecting GOLD.

Use HTTPS at the reverse proxy; HTTP Basic credentials must not travel over an untrusted plaintext connection. The security model is a stateless, machine-to-machine service account with role `GATE`. Browser cookie/session authentication and CORS are not enabled.

## REST contract

| Method | Route | Request | Successful response |
|---|---|---|---|
| GET | `/api/v1/tokens` | `terminalId`, plus `rfIdNo` or both `truckNo` and `regPlace` | `{tokenDetails:[], truckNo:..., regPlace:...}` |
| GET | `/api/v1/containers` | `terminalId` | `{contrDetails:[]}` |
| POST | `/api/v1/eir-location-requests` | EIR JSON below | `{eirDetails:[], locDetails:[]}` |
| POST | `/api/v1/gate-exceptions` | Exception JSON below | `{success:true}` |

Business property names are retained where practical. This is a new JSON contract, not a drop-in SOAP response serializer. SOAP envelopes, `userCredentials`, and embedded `exception`/`errorMessage` fields are removed. Unknown JSON fields are rejected to catch misspellings and accidental legacy credential payloads. Token dates are serialized by Jackson as ISO timestamps; confirm the deployment JVM time zone against Oracle DATE/TIMESTAMP semantics. Numeric identifiers remain strings to preserve leading zeros.

Example commands prompt for the API password (`curl.exe` on Windows):

```bash
curl --user gate-api 'http://localhost:8080/api/v1/containers?terminalId=T1'
curl --user gate-api 'http://localhost:8080/api/v1/tokens?terminalId=T1&truckNo=00123&regPlace=DXB'
curl --user gate-api -H 'Content-Type: application/json' --data-binary @eir-request.json http://localhost:8080/api/v1/eir-location-requests
curl --user gate-api -H 'Content-Type: application/json' --data-binary @exception-request.json http://localhost:8080/api/v1/gate-exceptions
```

`eir-request.json`:

```json
{
  "portCode": "J",
  "rfIdNo": null,
  "truckNo": "00123",
  "regPlace": "DXB",
  "chassisType": "3",
  "laneId": "2IB01",
  "visitId": "test-visit-001",
  "tokenDetails": [{"tokenNo": "00042"}],
  "contrDetails": [{
    "containerNo": "ABCD1234567",
    "isoCode": "2200",
    "doorDirection": "front",
    "contrPosition": "2",
    "chassisNo": "1",
    "sealPresence": "Y"
  }]
}
```

`exception-request.json`:

```json
{
  "errorDate": "30-OCT-2026 08:00:00",
  "truckNo": "00123",
  "regPlace": "DXB",
  "containerNo": "ABCD1234567",
  "tokenNo": "00042",
  "laneId": "2IB01",
  "errorCode": "CAMERA_ERROR",
  "errorDesc": "Camera unavailable"
}
```

Use actual UAT identifiers. These examples may invoke business logic and write data. EIR `portCode` defaults to `J`; absent/null arrays become empty lists. Each array is limited to 100 entries. The exception date remains the legacy string format `DD-MMM-YYYY HH24:MI:SS`, interpreted by the Oracle package; verify its NLS/date expectations before production.

Responses: 400 invalid input, 401 unauthenticated, 403 insufficient role, 422 nonblank Oracle `PO_ERROR`, 503 JDBC failure, 500 unexpected failure. Successful empty searches return empty arrays. Database/internal error responses include an `X-Correlation-ID` for server-log diagnosis and omit raw SQL error text. A 503 after a write can mean an unknown outcome: **do not blindly retry**.

## Oracle contract and deployment gates

1. Obtain and inspect the actual package specification/body and the `CAMCO_CONTR_OBJ` and `TBL_CAMCO_CONTR_OBJ` DDL. They are absent from this repository.
2. Confirm the active EIR signature below. The legacy iBATIS XML has an obsolete 11-parameter version; this implementation follows the active Java DAO's 12-parameter version.
3. Confirm schema/synonyms, execute/type privileges, cursor columns, package internal commits, and error conventions. Any nonblank `PO_ERROR` is treated as rejection; adapt only after documenting real success/error values.
4. Confirm `GET_TOKEN_DATA` and `GET_CONTAINER_DATA` have no side effects before exposing the GET routes to clients. EIR and exception calls are POST because their business behavior may write data.
5. Run integration tests against the deployed Oracle version and JDBC driver. Mock tests do not prove database compatibility. Confirm the Maven-resolved `ojdbc11` release is certified for the target Oracle server.
6. Compare legacy and REST results with controlled UAT data; avoid invoking write operations twice on production data.

| Procedure | Parameters in order |
|---|---|
| `GET_TOKEN_DATA` | RFID IN, truck INOUT, registration place INOUT, terminal IN, token cursor OUT, error OUT |
| `GET_CONTAINER_DATA` | terminal IN, container cursor OUT, error OUT |
| `GET_EIR_LOC_DATA` | port, RFID, truck, registration place, comma-separated tokens, chassis type, container array, lane, visit, EIR cursor OUT, location cursor OUT, error OUT |
| `INS_CAMCO_EXCEPTION_DATA` | error date, truck, registration place, container, token, lane, error code, error description, error OUT |

Container object attributes are positional: **containerNo, isoCode, doorDirection, contrPosition, chassisNo, sealPresence**. SQL package/type names may be schema-qualified in YAML. The array is created, bound, consumed and freed on the same physical connection. EIR cursor mapping includes `MOVE_TYPE` and `print_eir`, which are present in the active legacy Java mapper but absent from its XML equivalent.

`gasws.database` chooses PROMIS or GOLD at startup. No shared datasource mutation, automatic failover, or write retry occurs. Switch the configuration and restart only after reconciling in-flight work. Each call uses the pool's default auto-commit behavior; no cross-procedure transaction or distributed transaction is added. Verify package-side transaction semantics with the database owner.

`GET /actuator/health` is public, hides details, and probes only the selected database with `SELECT 1 FROM DUAL`. It returns DOWN/503 if that database is unavailable. It does not prove package/type grants. Other exposed actuator endpoints require authentication.

## Source layout and legacy preservation

- `src/main/java`: only the new Java 21 application is compiled by Maven.
- `src/main/resources`: Spring Boot configuration.
- `src/test/java`: API/security, JDBC contract/resource lifecycle and application wiring tests.
- `.github/workflows/java21.yml`: Java 21 `mvn clean verify` and executable JAR artifact.
- `src/com`, `web`, `encryption`, Ant files and OC4J metadata: preserved legacy reference; **not packaged into the Boot JAR**.

The new application does not load the bundled legacy JARs, JNDI objects, DES utility, static bean locator or XML Spring contexts. The legacy tree contains historical credentials/configuration and must not be used as production secret storage. Review and rotate any still-active historical credentials separately.

## Cutover

Deploy REST alongside SOAP on a separate port, configure TLS and the new service credential, validate all four operations in UAT, update clients to the documented JSON/HTTP contract, then switch traffic. Keep the SOAP deployment available for rollback until business acceptance. Disable it after migration; do not package its old libraries with the new JAR.
