package eu.fincon.starterapp.book.repository;

import org.springframework.stereotype.Repository;
import eu.fincon.examplestarter.base.repository.BaseCrudRepository;
import eu.fincon.starterapp.book.model.Book;

@Repository
public interface BookCrudRepository extends BaseCrudRepository<Book> {}
