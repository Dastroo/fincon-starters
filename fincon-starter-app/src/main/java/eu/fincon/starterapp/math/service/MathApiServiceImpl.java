package eu.fincon.starterapp.math.service;

import eu.fincon.starterapp.operationhistory.model.OperationHistory;
import eu.fincon.starterapp.operationhistory.service.OperationHistoryService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MathApiServiceImpl implements MathApiService {

  private final OperationHistoryService operationHistoryService;

  @Override
  public Integer doubleValue(Integer value) {
    log.info("Double value " + value);
    operationHistoryService.save(
        OperationHistory.builder()
            .createDate(LocalDateTime.now())
            .operation("/math/double")
            .params(value.toString())
            .build());
    return 2 * value;
  }

  @Override
  public Integer multiplyValues(Integer a, Integer b) {
    log.info(String.format("Multiply values %s by %s", a, b));
    operationHistoryService.save(
        OperationHistory.builder()
            .createDate(LocalDateTime.now())
            .operation("/math/multiply")
            .params(String.format("%s,%s", a, b))
            .build());
    return a * b;
  }
}
