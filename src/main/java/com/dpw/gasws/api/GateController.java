package com.dpw.gasws.api;

import com.dpw.gasws.repository.GateRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class GateController {
    private final GateRepository repository;
    public GateController(GateRepository repository) { this.repository = repository; }

    public record TokenSearch(@NotBlank String terminalId, String rfIdNo, String truckNo, String regPlace) {}
    public record ContainerSearch(@NotBlank String terminalId) {}

    @PostMapping(value = "/getTokenDetails", consumes = "application/json")
    public Responses.Tokens getTokenDetails(@Valid @RequestBody TokenSearch request) {
        if ((request.rfIdNo() == null || request.rfIdNo().isBlank()) &&
                (request.truckNo() == null || request.truckNo().isBlank() || request.regPlace() == null || request.regPlace().isBlank())) {
            throw new IllegalArgumentException("Supply rfIdNo or both truckNo and regPlace");
        }
        return repository.tokens(request.terminalId(), request.rfIdNo(), request.truckNo(), request.regPlace());
    }

    @PostMapping(value = "/getContainerDetails", consumes = "application/json")
    public Responses.Containers getContainerDetails(@Valid @RequestBody ContainerSearch request) {
        return repository.containers(request.terminalId());
    }

    @PostMapping(value = "/getEirLocationDetails", consumes = "application/json")
    public Responses.Eir getEirLocationDetails(@Valid @RequestBody Requests.Eir request) { return repository.eir(request); }

    @PostMapping(value = "/postExceptionData", consumes = "application/json")
    public Responses.Accepted postExceptionData(@Valid @RequestBody Requests.GateException request) {
        repository.exception(request);
        return new Responses.Accepted(true);
    }
}
