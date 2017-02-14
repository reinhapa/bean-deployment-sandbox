package test.batch;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

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
