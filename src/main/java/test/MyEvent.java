/**
 * File Name: MyEvent.java
 * 
 * Copyright (c) 2016 BISON Schweiz AG, All Rights Reserved.
 */

package test;

public enum MyEvent implements ReplicatorEvent<MyEvent> {
	RUNNING, STOPPIING;
}
