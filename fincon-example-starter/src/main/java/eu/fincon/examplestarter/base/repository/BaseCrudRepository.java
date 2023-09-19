package eu.fincon.examplestarter.base.repository;

import org.springframework.data.repository.ListCrudRepository;

public interface BaseCrudRepository<T> extends ListCrudRepository<T, Long> {}
