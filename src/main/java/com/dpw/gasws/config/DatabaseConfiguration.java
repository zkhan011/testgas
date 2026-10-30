package com.dpw.gasws.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfiguration {
    @Bean @ConfigurationProperties("gasws.datasource.promis")
    DataSourceProperties promisProperties() { return new DataSourceProperties(); }

    @Bean @ConfigurationProperties("gasws.datasource.gold")
    DataSourceProperties goldProperties() { return new DataSourceProperties(); }

    @Bean @Primary @ConfigurationProperties("gasws.datasource.promis.hikari")
    HikariDataSource promisDataSource(@Qualifier("promisProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean @ConfigurationProperties("gasws.datasource.gold.hikari")
    HikariDataSource goldDataSource(@Qualifier("goldProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    JdbcTemplate gateJdbcTemplate(@Qualifier("promisDataSource") HikariDataSource promis,
                                 @Qualifier("goldDataSource") HikariDataSource gold,
                                 @Value("${gasws.database:promis}") String database,
                                 @Value("${gasws.query-timeout-seconds:30}") int timeout) {
        var selected = switch (database) {
            case "promis" -> promis;
            case "gold" -> gold;
            default -> throw new IllegalArgumentException("gasws.database must be promis or gold");
        };
        var jdbc = new JdbcTemplate(selected);
        jdbc.setQueryTimeout(timeout);
        return jdbc;
    }
}
