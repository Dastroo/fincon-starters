package eu.fincon.starterapp.operationhistory.controller;

import eu.fincon.starterapp.operationhistory.model.OperationHistory;
import eu.fincon.starterapp.operationhistory.service.OperationHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class OperationHistoryController {

  private final OperationHistoryService operationHistoryService;

  @GetMapping
  public ResponseEntity<Page<OperationHistory>> findAll(Pageable pageable) {
    return ResponseEntity.ok(operationHistoryService.findAll(pageable));
  }
}
