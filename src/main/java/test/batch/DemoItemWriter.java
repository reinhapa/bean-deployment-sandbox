package test.batch;

import java.util.List;

import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.slf4j.Logger;

@Named
public class DemoItemWriter extends AbstractItemWriter {
	@Inject
	Logger logger;
	@Inject
	JobContext jobContext;

	@Override
	public void writeItems(List<Object> items) throws Exception {
		logger.info("Writing items {}, context properties {}", items, jobContext.getProperties());
	}

}
