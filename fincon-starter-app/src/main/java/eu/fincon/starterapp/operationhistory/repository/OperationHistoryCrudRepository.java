package eu.fincon.starterapp.operationhistory.repository;

import eu.fincon.examplestarter.base.repository.BaseCrudRepository;
import eu.fincon.starterapp.operationhistory.model.OperationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationHistoryCrudRepository extends BaseCrudRepository<OperationHistory> {}
