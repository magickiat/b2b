package com.starboard.b2b.dto;

public class OrderStatusDTO {

	private String orderStatusId;
	private String orderStatusName;
	private String orderStatusDescription;

	public OrderStatusDTO() {
	}

	public OrderStatusDTO(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public OrderStatusDTO(String orderStatusId, String orderStatusName, String orderStatusDescription) {
		this.orderStatusId = orderStatusId;
		this.orderStatusName = orderStatusName;
		this.orderStatusDescription = orderStatusDescription;
	}

	public String getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatusName() {
		return this.orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getOrderStatusDescription() {
		return this.orderStatusDescription;
	}

	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}

}
