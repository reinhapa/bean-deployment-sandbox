package test.batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Inject;
import javax.inject.Named;

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
