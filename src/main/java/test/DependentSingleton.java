/**
 * File Name: DependentSingleton.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import jakarta.ejb.Singleton;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import org.slf4j.Logger;

@Singleton
public class DependentSingleton {
	@Inject
	Logger logger;

	public void onEvent(@Observes MyEvent event) {
		logger.info("got event: {}", event);
	}
}
