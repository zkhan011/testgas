package com.dpw.gasws.api;

import com.dpw.gasws.type.*;
import java.util.List;

public final class Responses {
    private Responses() {}
    public record Tokens(List<TokenDetailsType> tokenDetails, String truckNo, String regPlace) {}
    public record Containers(List<ContainerDetailsType> contrDetails) {}
    public record Eir(List<EirDetailsType> eirDetails, List<LocDetailsType> locDetails) {}
    public record Accepted(boolean success) {}
}
