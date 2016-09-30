/**
 * File Name: DependentSingleton.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

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
