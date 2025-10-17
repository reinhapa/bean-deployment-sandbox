package test.batch;

import jakarta.batch.api.AbstractBatchlet;
import jakarta.batch.runtime.BatchStatus;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.slf4j.Logger;

@Named
public class DemoBatchlet extends AbstractBatchlet {
	@Inject
	Logger logger;
	@Inject
	JobContext jobContext;

	@Override
	public String process() throws Exception {
		logger.info("processing batchlet context properties {}", jobContext.getProperties());
		return BatchStatus.COMPLETED.toString();
	}

}
