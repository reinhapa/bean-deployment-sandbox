package test.batch;

import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.slf4j.Logger;

@Named
public class DemoItemProcessor implements ItemProcessor {
  @Inject
  Logger logger;

  @Override
  public Object processItem(Object item) throws Exception {
    logger.info("Processing item {}", item);
    return item;
  }

}
