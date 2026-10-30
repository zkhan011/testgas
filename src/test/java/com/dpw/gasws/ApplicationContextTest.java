package com.dpw.gasws;

import com.dpw.gasws.repository.GateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
    "gasws.security.username=test",
    "gasws.security.password-hash=$2a$10$dXJ3SW6G7P50lGmMkkmwe.20M5z5GSWOR1OMLNjUwS4fQJpV3wB2a"
})
class ApplicationContextTest {
    @Autowired GateRepository repository;
    @Autowired JdbcTemplate jdbc;
    @Test void applicationWiresWithoutOpeningOracleConnections() {
        assertThat(repository).isNotNull();
        assertThat(jdbc.getQueryTimeout()).isEqualTo(30);
    }
}
