package eu.fincon.examplestarter.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "eu.fincon.starter")
public class FinconExampleStarterProperties {

  private String name = "FooBar123";

  private Integer number = 987;
}
