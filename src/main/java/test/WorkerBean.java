/**
 * File Name: WorkerBean.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import java.security.SecureRandom;

import jakarta.ejb.Asynchronous;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import org.slf4j.Logger;

import test.interceptor.ThreadNaming;

@Stateless
public class WorkerBean {
	@Inject
	Logger logger;

	@ThreadNaming
	@Asynchronous
	public void onEvent(@Observes WorkerEvent event) {
		long sum = 0;
		SecureRandom random = new SecureRandom();
		for (int i = 0, n = random.nextInt(10_000); i < n; i++) {
			sum += random.nextInt();
		}
		BlackHole.consume(sum);
		logger.info("finished onEvent");
	}
}
