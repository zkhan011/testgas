package com.dpw.ports.promis.web;
import com.dpw.ports.promis.aqoperations.service.ManageVoyageServiceImpl;import com.dpw.ports.promis.common.integration.domain.Voyage;import org.springframework.web.bind.annotation.*;import jakarta.validation.Valid;import jakarta.validation.constraints.NotBlank;
@RestController @RequestMapping(value="/api/v1/voyages",produces="application/json")
public class VoyageController{
 private final ManageVoyageServiceImpl service;public VoyageController(ManageVoyageServiceImpl s){service=s;}
 public record Actor(@NotBlank String userName){}public record Rotation(Long rotationNumber){}public record Outcome(String error){}
 @PostMapping(value="/rotations",consumes="application/json") public Rotation create(@RequestBody Voyage r){r.performBusinessRules();return new Rotation(service.generateRotationNo(r));}
 @PostMapping(value="/{twsId}/advices",consumes="application/json") public Outcome advice(@PathVariable("twsId")Long id,@Valid @RequestBody Actor r){return new Outcome(service.adviceVoyage(id,r.userName()));}
 @PostMapping(value="/{twsId}/cancellations",consumes="application/json") public Outcome cancel(@PathVariable("twsId")Long id,@Valid @RequestBody Actor r){return new Outcome(service.cancelVoyage(id,r.userName()));}
 @PostMapping("/{twsId}/billings") public Outcome bill(@PathVariable("twsId")Long id){return new Outcome(service.billVoyage(id));}
}
