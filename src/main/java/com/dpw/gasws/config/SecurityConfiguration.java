package com.dpw.gasws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    InMemoryUserDetailsManager users(@Value("${gasws.security.username}") String username,
                                    @Value("${gasws.security.password-hash}") String hash) {
        if (username.isBlank() || !hash.matches("\\$2[aby]\\$\\d{2}\\$[./A-Za-z0-9]{53}")) {
            throw new IllegalArgumentException("Configure gasws.security.username and a BCrypt password-hash");
        }
        return new InMemoryUserDetailsManager(User.withUsername(username).password(hash).roles("GATE").build());
    }

    @Bean
    SecurityFilterChain security(HttpSecurity http) throws Exception {
        // Machine-to-machine API only; no cookie/session or browser form authentication.
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a -> a.requestMatchers("/actuator/health", "/actuator/health/**").permitAll()
                        .anyRequest().hasRole("GATE"))
                .httpBasic(Customizer.withDefaults()).build();
    }
}
