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

    @GetMapping("/tokens")
    public Responses.Tokens tokens(@RequestParam("terminalId") @NotBlank String terminalId,
                                   @RequestParam(value = "rfIdNo", required = false) String rfIdNo,
                                   @RequestParam(value = "truckNo", required = false) String truckNo,
                                   @RequestParam(value = "regPlace", required = false) String regPlace) {
        if ((rfIdNo == null || rfIdNo.isBlank()) &&
                (truckNo == null || truckNo.isBlank() || regPlace == null || regPlace.isBlank())) {
            throw new IllegalArgumentException("Supply rfIdNo or both truckNo and regPlace");
        }
        return repository.tokens(terminalId, rfIdNo, truckNo, regPlace);
    }

    @GetMapping("/containers")
    public Responses.Containers containers(@RequestParam("terminalId") @NotBlank String terminalId) {
        return repository.containers(terminalId);
    }

    @PostMapping("/eir-location-requests")
    public Responses.Eir eir(@Valid @RequestBody Requests.Eir request) { return repository.eir(request); }

    @PostMapping("/gate-exceptions")
    public Responses.Accepted exception(@Valid @RequestBody Requests.GateException request) {
        repository.exception(request);
        return new Responses.Accepted(true);
    }
}
