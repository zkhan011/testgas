package com.dpw.gasws.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public final class Requests {
    private Requests() {}

    public record Token(@NotBlank String tokenNo) {}
    public record Container(@NotBlank String containerNo, String isoCode, String doorDirection,
                            String contrPosition, String chassisNo, String sealPresence) {}

    public record Eir(String portCode, String rfIdNo, String truckNo, String regPlace,
                      String chassisType, @NotBlank String laneId, String visitId,
                      @Size(max = 100) List<@NotNull @Valid Token> tokenDetails,
                      @Size(max = 100) List<@NotNull @Valid Container> contrDetails) {
        public Eir {
            portCode = portCode == null || portCode.isBlank() ? "J" : portCode;
            tokenDetails = tokenDetails == null ? List.of() : tokenDetails;
            contrDetails = contrDetails == null ? List.of() : contrDetails;
        }
    }

    // Preserve the legacy Oracle date string contract until the package is versioned.
    public record GateException(@NotBlank String errorDate, String truckNo, String regPlace,
                                String containerNo, String tokenNo, @NotBlank String laneId,
                                @NotBlank String errorCode, @NotBlank String errorDesc) {}
}
