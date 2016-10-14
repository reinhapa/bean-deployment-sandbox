package test.batch;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

@Named
public class DemoItemWriter extends AbstractItemWriter {
  @Inject Logger logger;

  @Override
  public void writeItems(List<Object> items) throws Exception {
    logger.info("Writing items {}", items);
  }

}
