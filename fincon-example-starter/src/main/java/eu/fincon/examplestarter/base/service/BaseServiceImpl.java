package eu.fincon.examplestarter.base.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import eu.fincon.examplestarter.base.repository.BaseCrudRepository;
import eu.fincon.examplestarter.base.repository.BasePagingAndSortingRepository;

public abstract class BaseServiceImpl<
    CRUD_REPO extends BaseCrudRepository<ENTITY>,
    REPO extends BasePagingAndSortingRepository<ENTITY>,
    ENTITY> {

  public abstract CRUD_REPO crudDao();

  public abstract REPO dao();

  public Page<ENTITY> findAll(Pageable pageable) {
    return dao().findAll(pageable);
  }

  public Optional<ENTITY> findOne(Long id) {
    return crudDao().findById(id);
  }

  public ENTITY save(ENTITY entity) {
    return crudDao().save(entity);
  }
}
