package eu.fincon.starterapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
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

/*
  https://maciejwalkowiak.com/blog/testcontainers-spring-boot-setup/
 */
@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {MyTest.Initializer.class})
public class MyTest {

  @Autowired BookService bookService;

  @ClassRule
  public static PostgreSQLContainer postgreSQLContainer =
      new PostgreSQLContainer("postgres:15.4-alpine")
          .withDatabaseName("integration-tests-db")
          .withUsername("sa")
          .withPassword("sa");

  static class Initializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues.of(
              "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
              "spring.datasource.username=" + postgreSQLContainer.getUsername(),
              "spring.datasource.password=" + postgreSQLContainer.getPassword())
          .applyTo(configurableApplicationContext.getEnvironment());
    }
  }

  @BeforeAll
  static void beforeAll() {
    postgreSQLContainer.start();
  }

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
