package eu.fincon.starterapp.operationhistory.service;

import eu.fincon.examplestarter.base.service.BaseServiceImpl;
import eu.fincon.starterapp.operationhistory.model.OperationHistory;
import eu.fincon.starterapp.operationhistory.repository.OperationHistoryCrudRepository;
import eu.fincon.starterapp.operationhistory.repository.OperationHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationHistoryServiceImpl
    extends BaseServiceImpl<
        OperationHistoryCrudRepository, OperationHistoryRepository, OperationHistory>
    implements OperationHistoryService {

  private final OperationHistoryCrudRepository operationHistoryCrudRepository;
  private final OperationHistoryRepository operationHistoryRepository;

  @Override
  public OperationHistoryCrudRepository crudDao() {
    return operationHistoryCrudRepository;
  }

  @Override
  public OperationHistoryRepository dao() {
    return operationHistoryRepository;
  }
}
