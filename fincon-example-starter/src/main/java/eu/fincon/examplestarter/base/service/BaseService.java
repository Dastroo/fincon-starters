package eu.fincon.examplestarter.base.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<ENTITY> {

  Page<ENTITY> findAll(Pageable pageable);

  Optional<ENTITY> findOne(Long id);

  ENTITY save(ENTITY dto);
}
