package eu.fincon.starterapp.base;

import eu.fincon.starterapp.controller.MyControllerTest;
import io.restassured.RestAssured;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

/*
  https://maciejwalkowiak.com/blog/testcontainers-spring-boot-setup/
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@ContextConfiguration(initializers = {BaseTest.Initializer.class})
public class BaseTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer =
            new PostgreSQLContainer("postgres:15.4-alpine")
                    .withDatabaseName("integration-tests-db")
                    .withUsername("sa")
                    .withPassword("sa");

    @LocalServerPort
    private int port;

    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @BeforeEach
    public void beforeEach() {
        RestAssured.baseURI = String.format("http://localhost:%s", port);
        RestAssured.port = port;
    }

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
}
