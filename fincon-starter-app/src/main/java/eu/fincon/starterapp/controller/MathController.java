package eu.fincon.starterapp.controller;

import eu.fincon.starterapp.math.model.MultiplyRequest;
import eu.fincon.starterapp.math.model.MultiplyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/double/{value}")
    public Integer doubleValue(@PathVariable Integer value) {
        return value * 2;
    }

    @PostMapping("/multiply")
    public ResponseEntity<MultiplyResponse> multiply(@RequestBody MultiplyRequest request) {
        MultiplyResponse response = new MultiplyResponse(request.a(), request.b(), request.a() * request.b());
        return ResponseEntity.ok(response);
    }
}
