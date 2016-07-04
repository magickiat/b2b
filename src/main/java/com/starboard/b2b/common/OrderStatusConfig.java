package com.starboard.b2b.common;

public interface OrderStatusConfig {
	String WAIT_FOR_APPROVE = "10";
	String CANCELED = "20";
	String APPROVED = "30";
	String ON_PRODUCTION = "40";
	String READY_TO_SHIP = "50";
	String RELEASED = "60";
	String SHIP = "70";
	String INVOICE = "80";
	String PARTIAL_SHIPMENT = "90";
	String COMPLETE = "A0";

}
