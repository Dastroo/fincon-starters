package eu.fincon.starterapp.math.controller;

import eu.fincon.examplestarter.service.ExampleStarterService;
import eu.fincon.metricsstarter.aop.LogMethodExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired ExampleStarterService exampleStarterService;

  @GetMapping("/")
  @LogMethodExecutionTime
  public String helloWorld() {
    return exampleStarterService.helloWorld();
  }
}
