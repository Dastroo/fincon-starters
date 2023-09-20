package eu.fincon.starterapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import eu.fincon.starterapp.base.BaseTest;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import eu.fincon.starterapp.book.model.Book;
import eu.fincon.starterapp.book.service.BookService;

public class MyControllerTest extends BaseTest {

  @Autowired BookService bookService;

  @Test
  void myFirstTest() {
    // Given
    bookService.save(
        Book.builder().id(1L).title("Encyklopedia PWN").price(new BigDecimal("99.99")).build());

    // When
    Book book = bookService.findOne(1L).orElseThrow();

    // Then
    assertEquals("Encyklopedia PWN", book.getTitle());
    assertTrue(book.getPrice().compareTo(new BigDecimal("99.99")) == 0);
  }
}
