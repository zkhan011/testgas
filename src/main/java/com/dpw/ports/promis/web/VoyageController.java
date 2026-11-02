package com.dpw.ports.promis.web;

import com.dpw.ports.promis.aqoperations.service.ManageVoyageServiceImpl;
import com.dpw.ports.promis.common.integration.domain.Voyage;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class VoyageController {
    private final ManageVoyageServiceImpl service;
    public VoyageController(ManageVoyageServiceImpl service) { this.service = service; }
    public record Actor(@NotNull Long twsId, @NotBlank String userName) {}
    public record VoyageId(@NotNull Long twsId) {}
    public record Rotation(Long rotationNumber) {}
    public record Outcome(String error) {}

    @PostMapping(value = "/generateRotationNo", consumes = "application/json")
    public Rotation generateRotationNo(@Valid @RequestBody Voyage request) {
        request.performBusinessRules();
        return new Rotation(service.generateRotationNo(request));
    }

    @PostMapping(value = "/adviceVoyage", consumes = "application/json")
    public Outcome adviceVoyage(@Valid @RequestBody Actor request) {
        return new Outcome(service.adviceVoyage(request.twsId(), request.userName()));
    }

    @PostMapping(value = "/cancelVoyage", consumes = "application/json")
    public Outcome cancelVoyage(@Valid @RequestBody Actor request) {
        return new Outcome(service.cancelVoyage(request.twsId(), request.userName()));
    }

    @PostMapping(value = "/billVoyage", consumes = "application/json")
    public Outcome billVoyage(@Valid @RequestBody VoyageId request) {
        return new Outcome(service.billVoyage(request.twsId()));
    }
}
