package test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;

@Singleton
@Startup
public class ReiniSingletonBean {
	@Inject
	Logger logger;
	@Inject
	Event<Object> event;

	@PostConstruct
	public void postConstruct() {
		logger.info("post constuct");
		event.fire(MyEvent.RUNNING);
		event.fire(MySecondEvent.ONE);

		event.fire(new MyCommandEvent(MyEvent.RUNNING, "data"));
		event.fire(new MySecondCommandEvent(MySecondEvent.TWO, "data"));

		// class MyCommandEvent extends CommandEvent<MyCommandEvent, MyEvent,
		// Serializable> {
		//
		// }

	}

	public String getValue() {
		return "the value";
	}

	class MyCommandEvent extends CommandEvent<MyEvent> {
		public MyCommandEvent(MyEvent command, Serializable data) {
			super(command, data);
		}
	}

	class MySecondCommandEvent extends CommandEvent<MySecondEvent> {
		public MySecondCommandEvent(MySecondEvent command, Serializable data) {
			super(command, data);
		}
	}
}