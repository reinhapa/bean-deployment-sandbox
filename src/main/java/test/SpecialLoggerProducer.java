/**
 * File Name: SpecialLoggerProducer.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;

@Specializes
public class SpecialLoggerProducer extends LoggerProducer {

	@Produces
	@Override
	Logger createLogger(InjectionPoint io) {
		return super.createLogger(io);
	}
}
