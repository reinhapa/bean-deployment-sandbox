/**
 * File Name: DependentSingleton.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import org.slf4j.Logger;

@Singleton
public class OtherDependentSingleton {
	@Inject
	Logger logger;
	@Inject
	ReiniSingletonBean reiniSingletonBean;

	@PostConstruct
	public void postConstruct() {
		logger.info("post construct {}", reiniSingletonBean);
		// logger.info("post construct {}", reiniSingletonBean.getValue());
	}

	public void onEvent(@Observes MySecondEvent event) {
		logger.info("got event: {}", event);
		// logger.info("post construct {}", reiniSingletonBean.getValue());
	}

}
