package com.starboard.b2b.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tmp_orders")
public class TmpOrders {

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

	public TmpOrders() {
	}

	public TmpOrders(long orderId) {
		this.orderId = orderId;
	}

	public TmpOrders(long orderId, String orderCode, String soCode, Long custId, String custCode, String custUserId, Long memberId, Long brandGroupId,
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

	@Id
	@Column(name = "order_id", unique = true, nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "order_code", length = 100)
	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name = "so_code", length = 32)
	public String getSoCode() {
		return this.soCode;
	}

	public void setSoCode(String soCode) {
		this.soCode = soCode;
	}

	@Column(name = "cust_id")
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "cust_code", length = 32)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "cust_user_id", length = 32)
	public String getCustUserId() {
		return this.custUserId;
	}

	public void setCustUserId(String custUserId) {
		this.custUserId = custUserId;
	}

	@Column(name = "member_id")
	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@Column(name = "brand_group_id")
	public Long getBrandGroupId() {
		return this.brandGroupId;
	}

	public void setBrandGroupId(Long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

	@Column(name = "discount", precision = 10)
	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Column(name = "price", precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "total_price", precision = 10)
	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "ship_price", precision = 10)
	public BigDecimal getShipPrice() {
		return this.shipPrice;
	}

	public void setShipPrice(BigDecimal shipPrice) {
		this.shipPrice = shipPrice;
	}

	@Column(name = "net_price", precision = 10)
	public BigDecimal getNetPrice() {
		return this.netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	@Column(name = "product_unit_id", length = 3)
	public String getProductUnitId() {
		return this.productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	@Column(name = "track_id", length = 32)
	public String getTrackId() {
		return this.trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	@Column(name = "shipping_id", length = 16)
	public String getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "payment_id", length = 2)
	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "payment_currency_id", length = 16)
	public String getPaymentCurrencyId() {
		return this.paymentCurrencyId;
	}

	public void setPaymentCurrencyId(String paymentCurrencyId) {
		this.paymentCurrencyId = paymentCurrencyId;
	}

	@Column(name = "payment_term_id", length = 16)
	public String getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	@Column(name = "payment_method_id", length = 16)
	public String getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	@Column(name = "order_status", length = 2)
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expect_shipment_date", length = 19)
	public Date getExpectShipmentDate() {
		return this.expectShipmentDate;
	}

	public void setExpectShipmentDate(Date expectShipmentDate) {
		this.expectShipmentDate = expectShipmentDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expect_receipt_date", length = 19)
	public Date getExpectReceiptDate() {
		return this.expectReceiptDate;
	}

	public void setExpectReceiptDate(Date expectReceiptDate) {
		this.expectReceiptDate = expectReceiptDate;
	}

	@Column(name = "remark_customer", length = 1024)
	public String getRemarkCustomer() {
		return this.remarkCustomer;
	}

	public void setRemarkCustomer(String remarkCustomer) {
		this.remarkCustomer = remarkCustomer;
	}

	@Column(name = "remark_orders", length = 1024)
	public String getRemarkOrders() {
		return this.remarkOrders;
	}

	public void setRemarkOrders(String remarkOrders) {
		this.remarkOrders = remarkOrders;
	}

	@Column(name = "user_create", length = 32)
	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	@Column(name = "user_update", length = 32)
	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_create", length = 19)
	public Date getTimeCreate() {
		return this.timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_update", length = 19)
	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

}
