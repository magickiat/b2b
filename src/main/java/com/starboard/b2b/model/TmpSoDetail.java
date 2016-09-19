package com.starboard.b2b.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tmp_so_detail")
public class TmpSoDetail {

	private long soProductId;
	private Long orderProductId;
	private Long soId;
	private String soNo;
	private Long amount;
	private String productBuyerGroupId;
	private BigDecimal price;
	private String productCurrency;
	private String productUnitId;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public TmpSoDetail() {
	}

	public TmpSoDetail(long soProductId) {
		this.soProductId = soProductId;
	}

	public TmpSoDetail(long soProductId, Long orderProductId, Long soId, Long amount, String productBuyerGroupId, BigDecimal price,
			String productCurrency, String productUnitId, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.soProductId = soProductId;
		this.orderProductId = orderProductId;
		this.soId = soId;
		this.amount = amount;
		this.productBuyerGroupId = productBuyerGroupId;
		this.price = price;
		this.productCurrency = productCurrency;
		this.productUnitId = productUnitId;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "so_product_id", unique = true, nullable = false)
	public long getSoProductId() {
		return this.soProductId;
	}

	public void setSoProductId(long soProductId) {
		this.soProductId = soProductId;
	}

	@Column(name = "order_product_id")
	public Long getOrderProductId() {
		return this.orderProductId;
	}

	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}

	@Column(name = "so_id")
	public Long getSoId() {
		return this.soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Column(name = "amount")
	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Column(name = "product_buyer_group_id", length = 32)
	public String getProductBuyerGroupId() {
		return this.productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	@Column(name = "price", precision = 20, scale = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "product_currency", length = 16)
	public String getProductCurrency() {
		return this.productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	@Column(name = "product_unit_id", length = 16)
	public String getProductUnitId() {
		return this.productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
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

	@Column(name = "so_no", nullable = false, length = 32)
	public String getSoNo() {
		return this.soNo;
	}

	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
}
