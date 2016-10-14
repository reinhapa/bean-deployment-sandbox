/**
 * File Name: TestReplicator.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;

@Singleton
public class TestReplicator {
	@Inject
	Logger logger;
	@Inject
	Event<Object> eventSink;

	public void onEvent(@Observes ReplicatorEvent<?> event) {
		logger.info("got event type {}", event.getClass());
	}

	public void onMyEvent(@Observes ReplicatorEvent<MyEvent> event) {
		logger.info("got my event type {}", event.getClass());
	}

	public void onMySecondEvent(@Observes ReplicatorEvent<MySecondEvent> event) {
		logger.info("got my second event type {}", event.getClass());
	}

	public void onCommandEvent(@Observes CommandEvent<?, ?> event) {
		logger.info("got command event type {}", event.getClass());
	}

	public void onCommandMyEvent(@Observes CommandEvent<MyEvent, String> event) {
		logger.info("got command my event type {}", event.getClass());
	}

	public void onCommandMySecondEvent(@Observes CommandEvent<MySecondEvent, String> event) {
		logger.info("got command my second event type {}", event.getClass());
	}
}
