package com.dpw.ports.promis.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/** HHT routes use the existing client/admin X-API-Key interceptor, not GAS HTTP Basic. */
@Configuration
public class HhtSecurityConfiguration {
    @Bean @Order(1)
    SecurityFilterChain hhtSecurity(HttpSecurity http) throws Exception {
        return http.securityMatcher(
                "/api/v1/admin/schedulers",
                "/api/v1/admin/schedulers/{name}/starts",
                "/api/v1/admin/schedulers/{name}/stops",
                "/api/v1/berths/search",
                "/api/v1/commercial-trucks/token-search",
                "/api/v1/configuration/major-damage-flag",
                "/api/v1/containers/damage-history/search",
                "/api/v1/containers/damage-updates",
                "/api/v1/containers/empty-allocations",
                "/api/v1/containers/empty-refusals",
                "/api/v1/containers/location-search",
                "/api/v1/containers/planned-moves/search",
                "/api/v1/containers/seal-history/search",
                "/api/v1/containers/seal-updates",
                "/api/v1/containers/standing-damage-updates",
                "/api/v1/containers/standing-damages/search",
                "/api/v1/containers/truck-search",
                "/api/v1/containers/weight-updates",
                "/api/v1/containers/weights/search",
                "/api/v1/ctms/voyage-updates",
                "/api/v1/ctms/voyages/search",
                "/api/v1/damage-codes/search",
                "/api/v1/eirs/print-jobs",
                "/api/v1/eirs/search",
                "/api/v1/gate-passes/movements",
                "/api/v1/gate-passes/search",
                "/api/v1/gates/customs-entries",
                "/api/v1/gates/exit-confirmations",
                "/api/v1/marine/signatures",
                "/api/v1/marine/transactions",
                "/api/v1/marine/voyages/search",
                "/api/v1/reference-data/search",
                "/api/v1/tokens/acceptances",
                "/api/v1/tokens/search",
                "/api/v1/tokens/time-slot-adjustments",
                "/api/v1/tokens/time-slots/search",
                "/api/v1/tos/messages",
                "/api/v1/trucks/eirs/search",
                "/api/v1/trucks/token-search",
                "/api/v1/users/verifications",
                "/api/v1/vessels/notice-updates",
                "/api/v1/vessels/notices/search",
                "/api/v1/voyages/rotations",
                "/api/v1/voyages/{twsId}/advices",
                "/api/v1/voyages/{twsId}/billings",
                "/api/v1/voyages/{twsId}/cancellations")
                .csrf(csrf -> csrf.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a -> a.anyRequest().permitAll())
                .build();
    }
}
