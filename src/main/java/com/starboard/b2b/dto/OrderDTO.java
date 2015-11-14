package com.starboard.b2b.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {

	private long orderId;
	private String orderCode;
	private String soCode;
	private Long custId;
	private String custCode;
	private String custUserId;
	private Long memberId;
	private Long brandGroupId;
	private BigDecimal discount;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private BigDecimal shipPrice;
	private BigDecimal netPrice;
	private String productUnitId;
	private String trackId;
	private String shippingId;
	private String paymentId;
	private String paymentCurrencyId;
	private String paymentTermId;
	private String paymentMethodId;
	private String orderStatus;
	private Date orderDate;
	private Date expectShipmentDate;
	private Date expectReceiptDate;
	private String remarkCustomer;
	private String remarkOrders;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public OrderDTO() {
	}
	
	

	public OrderDTO(long orderId, String orderCode, String soCode, Long custId, String custCode, String custUserId, Long memberId, Long brandGroupId,
			BigDecimal discount, BigDecimal price, BigDecimal totalPrice, BigDecimal shipPrice, BigDecimal netPrice, String productUnitId,
			String trackId, String shippingId, String paymentId, String paymentCurrencyId, String paymentTermId, String paymentMethodId,
			String orderStatus, Date orderDate, Date expectShipmentDate, Date expectReceiptDate, String remarkCustomer, String remarkOrders,
			String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.orderId = orderId;
		this.orderCode = orderCode;
		this.soCode = soCode;
		this.custId = custId;
		this.custCode = custCode;
		this.custUserId = custUserId;
		this.memberId = memberId;
		this.brandGroupId = brandGroupId;
		this.discount = discount;
		this.price = price;
		this.totalPrice = totalPrice;
		this.shipPrice = shipPrice;
		this.netPrice = netPrice;
		this.productUnitId = productUnitId;
		this.trackId = trackId;
		this.shippingId = shippingId;
		this.paymentId = paymentId;
		this.paymentCurrencyId = paymentCurrencyId;
		this.paymentTermId = paymentTermId;
		this.paymentMethodId = paymentMethodId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.expectShipmentDate = expectShipmentDate;
		this.expectReceiptDate = expectReceiptDate;
		this.remarkCustomer = remarkCustomer;
		this.remarkOrders = remarkOrders;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}



	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSoCode() {
		return soCode;
	}

	public void setSoCode(String soCode) {
		this.soCode = soCode;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustUserId() {
		return custUserId;
	}

	public void setCustUserId(String custUserId) {
		this.custUserId = custUserId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getBrandGroupId() {
		return brandGroupId;
	}

	public void setBrandGroupId(Long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(BigDecimal shipPrice) {
		this.shipPrice = shipPrice;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentCurrencyId() {
		return paymentCurrencyId;
	}

	public void setPaymentCurrencyId(String paymentCurrencyId) {
		this.paymentCurrencyId = paymentCurrencyId;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getExpectShipmentDate() {
		return expectShipmentDate;
	}

	public void setExpectShipmentDate(Date expectShipmentDate) {
		this.expectShipmentDate = expectShipmentDate;
	}

	public Date getExpectReceiptDate() {
		return expectReceiptDate;
	}

	public void setExpectReceiptDate(Date expectReceiptDate) {
		this.expectReceiptDate = expectReceiptDate;
	}

	public String getRemarkCustomer() {
		return remarkCustomer;
	}

	public void setRemarkCustomer(String remarkCustomer) {
		this.remarkCustomer = remarkCustomer;
	}

	public String getRemarkOrders() {
		return remarkOrders;
	}

	public void setRemarkOrders(String remarkOrders) {
		this.remarkOrders = remarkOrders;
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
