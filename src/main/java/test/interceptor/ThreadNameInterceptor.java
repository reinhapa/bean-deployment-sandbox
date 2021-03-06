/**
 * File Name: ThreadNameInterceptor.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test.interceptor;

import java.util.StringJoiner;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@ThreadNaming
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ThreadNameInterceptor {

	@AroundInvoke
	public Object renameThread(InvocationContext ctx) throws Exception {
		Thread currentThread = Thread.currentThread();
		final String threadName = currentThread.getName();
		try {
			StringJoiner joiner = new StringJoiner(" ");
			joiner.add(threadName);
			joiner.add(ctx.getMethod().toString());
			for (Object param : ctx.getParameters()) {
				joiner.add(String.valueOf(param));
			}
			currentThread.setName(joiner.toString());
			return ctx.proceed();
		} finally {
			currentThread.setName(threadName);
		}
	}
}
