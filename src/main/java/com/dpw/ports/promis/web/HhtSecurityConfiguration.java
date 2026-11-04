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
                "/api/v1/getVoyages",
                "/api/v1/getRefData",
                "/api/v1/pushMarineDetails",
                "/api/v1/uploadSignature",
                "/api/v1/getVoyagesFromCTMS",
                "/api/v1/CTMSVoyageUpdate",
                "/api/v1/getTokens",
                "/api/v1/getTokenForTruck",
                "/api/v1/getDWCTruckEIR",
                "/api/v1/updateCustmGateEntry",
                "/api/v1/getDynamicMTContainer",
                "/api/v1/getDEDContrPlanMoves",
                "/api/v1/sendTOSMsg",
                "/api/v1/updateContainer",
                "/api/v1/acceptToken",
                "/api/v1/getEir",
                "/api/v1/confirmGateoutMove",
                "/api/v1/getFZGPGateInOutSearchList",
                "/api/v1/procFZGPGateInOutUpdate",
                "/api/v1/prevSealDetails",
                "/api/v1/prevDamageDetails",
                "/api/v1/getMajorDamages",
                "/api/v1/verifyUser",
                "/api/v1/getTokenForCommercialTruck",
                "/api/v1/getContrLocation",
                "/api/v1/printEir",
                "/api/v1/addMTRefusal",
                "/api/v1/getNoticeDetailsForVessel",
                "/api/v1/updateNoticeDetailsForVessel",
                "/api/v1/getBerthDetails",
                "/api/v1/getVGMContainerWeightDetails",
                "/api/v1/updateVGMContainerWeightDetails",
                "/api/v1/getTokenTimeSlot",
                "/api/v1/getTruckInfoByContainer",
                "/api/v1/getAdjustTimeSlot",
                "/api/v1/getContainerDamages",
                "/api/v1/updateStdDmgDetails",
                "/api/v1/getMajorDamageFlag",
                "/api/v1/updateContainerWithDamages",
                "/api/v1/generateRotationNo",
                "/api/v1/adviceVoyage",
                "/api/v1/cancelVoyage",
                "/api/v1/billVoyage",
                "/api/v1/getConfiguredJobsForMarineAQ",
                "/api/v1/startScheduler",
                "/api/v1/stopScheduler")
                .csrf(csrf -> csrf.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a -> a.anyRequest().permitAll())
                .build();
    }
}
