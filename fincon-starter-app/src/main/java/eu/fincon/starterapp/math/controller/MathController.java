package eu.fincon.starterapp.math.controller;

import eu.fincon.starterapp.math.model.MultiplyRequest;
import eu.fincon.starterapp.math.model.MultiplyResponse;
import eu.fincon.starterapp.math.service.MathApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
@RequiredArgsConstructor
public class MathController {

  private final MathApiService mathApiService;

  @GetMapping("/double/{value}")
  public Integer doubleValue(@PathVariable Integer value) {
    return mathApiService.doubleValue(value);
  }

  @PostMapping("/multiply")
  public ResponseEntity<MultiplyResponse> multiply(@RequestBody MultiplyRequest request) {
    MultiplyResponse response =
        new MultiplyResponse(
            request.a(), request.b(), mathApiService.multiplyValues(request.a(), request.b()));
    return ResponseEntity.ok(response);
  }
}
