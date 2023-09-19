package eu.fincon.examplestarter.base.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface BasePagingAndSortingRepository<T>
    extends ListPagingAndSortingRepository<T, Long> {}
