package test;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import org.slf4j.Logger;

@Singleton
@Startup
public class ReiniSingletonBean {
	@Inject
	Logger logger;
	@Inject
	Event<Object> event;

	int loops;

	@PostConstruct
	public void postConstruct() {
		logger.info("post constuct");
		event.fire(MyEvent.RUNNING);
		event.fire(MySecondEvent.ONE);

		event.fire(new MyCommandEvent(MyEvent.RUNNING, "data"));
		event.fire(new MySecondCommandEvent(MySecondEvent.TWO, "data"));
	}

	@Schedule(hour = "*", minute = "*/2", persistent = false)
	public void onTimer() {
		loops += 50;
		logger.info("start fire {} events", Integer.valueOf(loops));
		for (int i = 0; i < loops; i++) {
			event.fire(new WorkerEvent());
		}
		logger.info("end fire events");
	}

	public String getValue() {
		return "the value";
	}

	class MyCommandEvent extends CommandEvent<MyEvent, String> {
		public MyCommandEvent(MyEvent command, String data) {
			super(command, data);
		}
	}

	class MySecondCommandEvent extends CommandEvent<MySecondEvent, String> {
		public MySecondCommandEvent(MySecondEvent command, String data) {
			super(command, data);
		}
	}
}