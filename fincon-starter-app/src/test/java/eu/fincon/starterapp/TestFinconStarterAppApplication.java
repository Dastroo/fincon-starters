package eu.fincon.starterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * links for reference: <a href="https://www.youtube.com/watch?v=ykEK2xuJrN8">related video</a> <a
 * href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.testing.testcontainers.at-development-time">official
 * documentation</a>
 */
@TestConfiguration(proxyBeanMethods = false)
public class TestFinconStarterAppApplication {

  @Bean
  @RestartScope
  @ServiceConnection
  PostgreSQLContainer<?> postgresContainer() {
    return new PostgreSQLContainer<>(DockerImageName.parse("postgres:15-alpine"));
  }

  public static void main(String[] args) {
    SpringApplication.from(FinconStarterAppApplication::main)
        .with(TestFinconStarterAppApplication.class)
        .run(args);
  }
}
