# Combined migration validation

Java 21 `mvn clean verify`: **BUILD SUCCESS, 26 tests passed, 0 failures, 0 errors**.

The merge includes Java 21 build verification, existing GAS tests, the imported MDT mapping/parameter/route tests, and combined application/security tests. Tests use JDBC/service mocks and do not execute live Oracle procedures.

Checks include all 50 controller mappings in one application, all 49 MyBatis statements, all 37 imported procedure parameter contracts, all 39 HHT route dispatches, GAS cursor/array cleanup, API key versus Basic authentication isolation, scheduler admin authorization, and DPW mapper resolution.

The executable JAR is built under `target/dpw-integration-rest-1.0.0.jar`; no stale ZIP binaries are committed. CI uploads the freshly built JAR.

Still requires UAT: real Oracle procedure execution, object layouts, cursor/date types, database internal commits, operational client compatibility, and live concurrency. Pools connect lazily; startup alone does not verify database connectivity. The public health endpoint probes only the selected GAS database.
