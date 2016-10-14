/**
 * File Name: AsynchObserverBean.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import java.security.SecureRandom;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
@Asynchronous
public class WorkerBean {
	@Inject
	Logger logger;

	public void onEvent(@Observes WorkerEvent event) {
		long sum = 0;
		SecureRandom random = new SecureRandom();
		for (int i = 0, n = random.nextInt(10_000); i < n; i++) {
			sum += random.nextInt();
		}
		BlackHole.consume(sum);
	}
}
