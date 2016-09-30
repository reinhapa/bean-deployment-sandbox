/**
 * File Name: LoggerProducer.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerProducer {

	@Produces
	Logger createLogger(InjectionPoint io) {
		return LoggerFactory.getLogger(io.getMember().getDeclaringClass());
	}

}
