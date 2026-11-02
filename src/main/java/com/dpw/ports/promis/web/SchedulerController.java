package com.dpw.ports.promis.web;
import com.dpw.ports.promis.aqoperations.service.DBManagerServiceImpl;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping(value="/api/v1/admin/schedulers",produces="application/json")
public class SchedulerController{
 private final DBManagerServiceImpl service;public SchedulerController(DBManagerServiceImpl s){service=s;}
 public record Outcome(String error){}
 @GetMapping public List<String> list(){return service.getConfiguredJobsForMarineAQ();}
 @PostMapping("/{name}/starts") public Outcome start(@PathVariable("name")String name){check(name);return new Outcome(service.startScheduler(name));}
 @PostMapping("/{name}/stops") public Outcome stop(@PathVariable("name")String name){check(name);return new Outcome(service.stopScheduler(name));}
 private void check(String name){if(service.getConfiguredJobsForMarineAQ().stream().noneMatch(v->v.equalsIgnoreCase(name)))throw new IllegalArgumentException("Unknown scheduler");}
}
