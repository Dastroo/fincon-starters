package eu.fincon.starterapp.book.repository;

import org.springframework.stereotype.Repository;
import eu.fincon.examplestarter.base.repository.BasePagingAndSortingRepository;
import eu.fincon.starterapp.book.model.Book;

@Repository
public interface BookRepository extends BasePagingAndSortingRepository<Book> {}
