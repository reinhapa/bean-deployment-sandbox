package test.batch;

import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.slf4j.Logger;

@Named
public class DemoItemReader extends AbstractItemReader {
	@Inject
	Logger logger;
	@Inject
	JobContext jobContext;

	int count = 10;

	@Override
	public Object readItem() throws Exception {
		logger.info("read items - context properties {}", jobContext.getProperties());
		if (count > 0) {
			return Long.valueOf(count--);
		}
		return null;
	}

}
