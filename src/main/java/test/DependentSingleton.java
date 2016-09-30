/**
 * File Name: DependentSingleton.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

@Singleton
public class DependentSingleton {
	@Inject
	Logger logger;

	public void onEvent(@Observes MyEvent event) {
		logger.info("got event: {}", event);
	}
}
