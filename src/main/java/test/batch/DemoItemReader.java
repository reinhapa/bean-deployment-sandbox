package test.batch;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

@Named
public class DemoItemReader extends AbstractItemReader {
  @Inject
  Logger logger;

  int count = 10;

  @Override
  public Object readItem() throws Exception {
    logger.info("read items");
    if (count > 0) {
      return Long.valueOf(count--);
    }
    return null;
  }

}
