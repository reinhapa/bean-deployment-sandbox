package test.batch;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

@Named
public class DemoBatchlet extends AbstractBatchlet {
  @Inject Logger logger;

  @Override
  public String process() throws Exception {
    logger.info("processing batchlet");
    return BatchStatus.COMPLETED.toString();
  }
  
}
