package com.dpw.ports.promis;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(properties={"gasws.security.username=test","gasws.security.password-hash=$2a$10$dXJ3SW6G7P50lGmMkkmwe.20M5z5GSWOR1OMLNjUwS4fQJpV3wB2a","gate.security.api-key=test-client-key-more-than-24-characters","gate.security.admin-key=test-admin-key-more-than-24-characters"})
class ApplicationTest{@Test void applicationStartsWithoutOracleServer(){}}
