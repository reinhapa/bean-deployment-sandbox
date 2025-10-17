/**
 * File Name: ThreadExecutorBean.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.inject.Inject;

import org.slf4j.Logger;

@Stateless
public class ThreadExecutorBean {
	@Inject
	Logger logger;

	@Resource
	ManagedExecutorService executorService;

	@Schedule(hour = "*", minute = "*/2", persistent = false)
	public void onTimer() {
		for (int i = 0; i < 1000; i++) {
			executorService.submit(this::workload);
		}
	}

	void workload() {
		Integer total = Integer.valueOf(0);
		for (int i = 0; i < 500_000; i++) {
			total = total + i;
		}
	}
}
