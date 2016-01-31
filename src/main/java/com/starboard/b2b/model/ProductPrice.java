package com.starboard.b2b.model;
// Generated Oct 12, 2015 10:55:07 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductPrice generated by hbm2java
 */
@Entity
@Table(name = "product_price")
public class ProductPrice implements java.io.Serializable {

	private ProductPriceId id;
	private BigDecimal amount;
	private String productUnitId;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;
	private BigDecimal msrePrice;

	public ProductPrice() {
	}

	public ProductPrice(ProductPriceId id, BigDecimal msrePrice) {
		this.id = id;
		this.msrePrice = msrePrice;
	}

	public ProductPrice(ProductPriceId id, BigDecimal amount, String productUnitId, String userCreate,
			String userUpdate, Date timeCreate, Date timeUpdate, BigDecimal msrePrice) {
		this.id = id;
		this.amount = amount;
		this.productUnitId = productUnitId;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
		this.msrePrice = msrePrice;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "productCode", column = @Column(name = "product_code", nullable = false, length = 32) ),
			@AttributeOverride(name = "productPriceGroupId", column = @Column(name = "product_price_group_id", nullable = false, length = 32) ),
			@AttributeOverride(name = "productCurrency", column = @Column(name = "product_currency", nullable = false, length = 3) ) })
	public ProductPriceId getId() {
		return this.id;
	}

	public void setId(ProductPriceId id) {
		this.id = id;
	}

	@Column(name = "amount", precision = 20, scale = 10)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	@Column(name = "msre_price", nullable = false, precision = 20, scale = 10)
	public BigDecimal getMsrePrice() {
		return this.msrePrice;
	}

	public void setMsrePrice(BigDecimal msrePrice) {
		this.msrePrice = msrePrice;
	}

}
