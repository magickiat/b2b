package com.starboard.b2b.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrdDetailDTO {

	private long orderProductId;
	private Long orderId;
	private Long productId;
	private Long amount;
	private Long status;
	private BigDecimal price;
	private String productUnitId;
	private String productBuyerGroupId;
	private String productCurrency;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public OrdDetailDTO() {
	}

	public OrdDetailDTO(long orderProductId) {
		this.orderProductId = orderProductId;
	}

	public OrdDetailDTO(long orderProductId, Long orderId, Long productId, Long amount, Long status, BigDecimal price, String productUnitId,
			String productBuyerGroupId, String productCurrency, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.orderProductId = orderProductId;
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.status = status;
		this.price = price;
		this.productUnitId = productUnitId;
		this.productBuyerGroupId = productBuyerGroupId;
		this.productCurrency = productCurrency;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	public long getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(long orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getProductBuyerGroupId() {
		return productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

}
