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
@Table(name = "tmp_ord_detail_from_ax")
public class TmpOrdDetailFromAx {

	private long orderDetailId;
	private Long orderId;
	private String orderCode;
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

	public TmpOrdDetailFromAx() {
	}

	public TmpOrdDetailFromAx(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public TmpOrdDetailFromAx(long orderDetailId, Long orderId, Long productId, Long amount, Long status, BigDecimal price, String productUnitId,
			String productBuyerGroupId, String productCurrency, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.orderDetailId = orderDetailId;
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

	@Column(name = "order_id")
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "product_id")
	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Column(name = "amount")
	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Column(name = "status")
	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Column(name = "price", precision = 20, scale = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "product_unit_id", length = 16)
	public String getProductUnitId() {
		return this.productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	@Column(name = "product_buyer_group_id", length = 32)
	public String getProductBuyerGroupId() {
		return this.productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	@Column(name = "product_currency", length = 16)
	public String getProductCurrency() {
		return this.productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	@Column(name = "user_create", length = 20)
	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	@Column(name = "user_update", length = 20)
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

	@Id
	@Column(name = "order_detail_id", unique = true, nullable = false)
	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	@Column(name = "order_code", length = 100)
	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

}
