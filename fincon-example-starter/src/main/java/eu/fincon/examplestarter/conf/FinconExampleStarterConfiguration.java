package eu.fincon.examplestarter.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import eu.fincon.examplestarter.service.ExampleStarterService;
import eu.fincon.examplestarter.service.ExampleStarterServiceImpl;

@Slf4j
@Configuration
@EnableConfigurationProperties(FinconExampleStarterProperties.class)
@ConditionalOnClass(ExampleStarterService.class)
public class FinconExampleStarterConfiguration {

  @Autowired
  FinconExampleStarterProperties properties;

  @Bean
  @ConditionalOnMissingClass
  public ExampleStarterService exampleStarterService() {
    log.info("Creating example starter service...");
    return new ExampleStarterServiceImpl(properties);
  }
}
