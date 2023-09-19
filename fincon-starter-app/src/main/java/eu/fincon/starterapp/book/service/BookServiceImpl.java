package eu.fincon.starterapp.book.service;

import eu.fincon.starterapp.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import eu.fincon.examplestarter.base.service.BaseServiceImpl;
import eu.fincon.starterapp.book.model.Book;
import eu.fincon.starterapp.book.repository.BookCrudRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl extends BaseServiceImpl<BookCrudRepository, BookRepository, Book> implements BookService {

    private final BookCrudRepository bookCrudRepository;
    private final BookRepository bookRepository;

    @Override
    public BookCrudRepository crudDao() {
        return bookCrudRepository;
    }

    @Override
    public BookRepository dao() {
        return bookRepository;
    }
}
