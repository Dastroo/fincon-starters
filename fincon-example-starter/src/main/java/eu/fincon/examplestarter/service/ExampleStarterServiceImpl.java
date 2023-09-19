package eu.fincon.examplestarter.service;

import eu.fincon.examplestarter.conf.FinconExampleStarterProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExampleStarterServiceImpl implements ExampleStarterService {

  private final FinconExampleStarterProperties properties;

  @Override
  public String helloWorld() {
    return String.format("%s:%s", properties.getName(), properties.getNumber());
  }
}
