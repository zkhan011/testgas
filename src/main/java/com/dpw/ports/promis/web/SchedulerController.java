package com.dpw.ports.promis.web;

import com.dpw.ports.promis.aqoperations.service.DBManagerServiceImpl;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class SchedulerController {
    private final DBManagerServiceImpl service;
    public SchedulerController(DBManagerServiceImpl service) { this.service = service; }
    public record SchedulerRequest(@NotBlank String name) {}
    public record Outcome(String error) {}

    @PostMapping(value = "/getConfiguredJobsForMarineAQ", consumes = "application/json")
    public List<String> getConfiguredJobsForMarineAQ() { return service.getConfiguredJobsForMarineAQ(); }

    @PostMapping(value = "/startScheduler", consumes = "application/json")
    public Outcome startScheduler(@Valid @RequestBody SchedulerRequest request) {
        check(request.name());
        return new Outcome(service.startScheduler(request.name()));
    }

    @PostMapping(value = "/stopScheduler", consumes = "application/json")
    public Outcome stopScheduler(@Valid @RequestBody SchedulerRequest request) {
        check(request.name());
        return new Outcome(service.stopScheduler(request.name()));
    }

    private void check(String name) {
        if (service.getConfiguredJobsForMarineAQ().stream().noneMatch(v -> v.equalsIgnoreCase(name)))
            throw new IllegalArgumentException("Unknown scheduler");
    }
}
