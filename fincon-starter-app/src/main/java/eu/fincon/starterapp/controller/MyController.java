package eu.fincon.starterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import eu.fincon.metricsstarter.aop.LogMethodExecutionTime;
import eu.fincon.examplestarter.service.ExampleStarterService;

@RestController
public class MyController {

    @Autowired
    ExampleStarterService exampleStarterService;

    @GetMapping("/")
    @LogMethodExecutionTime
    public String helloWorld() {
        return exampleStarterService.helloWorld();
    }
}