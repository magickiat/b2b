package com.starboard.b2b.model;
// Generated Oct 12, 2015 10:55:07 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductStock generated by hbm2java
 */
@Entity
@Table(name = "product_stock")
public class ProductStock implements java.io.Serializable {

	private long productStockId;
	private String productCode;
	private String custCode;
	private Long amount;
	private Date asOf;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public ProductStock() {
	}

	public ProductStock(long productStockId, String productCode, String custCode) {
		this.productStockId = productStockId;
		this.productCode = productCode;
		this.custCode = custCode;
	}

	public ProductStock(long productStockId, String productCode, String custCode, Long amount, Date asOf,
			String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.productStockId = productStockId;
		this.productCode = productCode;
		this.custCode = custCode;
		this.amount = amount;
		this.asOf = asOf;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Id

	@Column(name = "product_stock_id", unique = true, nullable = false)
	public long getProductStockId() {
		return this.productStockId;
	}

	public void setProductStockId(long productStockId) {
		this.productStockId = productStockId;
	}

	@Column(name = "product_code", nullable = false, length = 16)
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "cust_code", nullable = false, length = 100)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "amount", precision = 10, scale = 0)
	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "as_of", length = 19)
	public Date getAsOf() {
		return this.asOf;
	}

	public void setAsOf(Date asOf) {
		this.asOf = asOf;
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
