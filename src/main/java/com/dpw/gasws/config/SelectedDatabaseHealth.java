package com.dpw.gasws.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("selectedDatabase")
public class SelectedDatabaseHealth implements HealthIndicator {
    private final JdbcTemplate jdbc;
    public SelectedDatabaseHealth(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    @Override public Health health() {
        try {
            Integer value = jdbc.queryForObject("SELECT 1 FROM DUAL", Integer.class);
            return Integer.valueOf(1).equals(value) ? Health.up().build() : Health.down().build();
        } catch (RuntimeException failure) {
            return Health.down().build();
        }
    }
}
