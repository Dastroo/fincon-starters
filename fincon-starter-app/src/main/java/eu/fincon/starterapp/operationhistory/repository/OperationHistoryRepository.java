package eu.fincon.starterapp.operationhistory.repository;

import eu.fincon.examplestarter.base.repository.BasePagingAndSortingRepository;
import eu.fincon.starterapp.operationhistory.model.OperationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationHistoryRepository
    extends BasePagingAndSortingRepository<OperationHistory> {}
