package com.starboard.b2b.model;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CustPriceGroup generated by hbm2java
 */
@Entity
@Table(name = "cust_price_group")
public class CustPriceGroup implements java.io.Serializable {

	private long custPriceGroupId;
	private String custCode;
	private Long productTypeId;
	private String productBuyerGroupId;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public CustPriceGroup() {
	}

	public CustPriceGroup(long custPriceGroupId, String custCode) {
		this.custPriceGroupId = custPriceGroupId;
		this.custCode = custCode;
	}

	public CustPriceGroup(long custPriceGroupId, String custCode, Long productTypeId, String productBuyerGroupId,
			String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.custPriceGroupId = custPriceGroupId;
		this.custCode = custCode;
		this.productTypeId = productTypeId;
		this.productBuyerGroupId = productBuyerGroupId;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Id

	@Column(name = "cust_price_group_id", unique = true, nullable = false)
	public long getCustPriceGroupId() {
		return this.custPriceGroupId;
	}

	public void setCustPriceGroupId(long custPriceGroupId) {
		this.custPriceGroupId = custPriceGroupId;
	}

	@Column(name = "cust_code", nullable = false, length = 32)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "product_type_id")
	public Long getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Column(name = "product_buyer_group_id", length = 16)
	public String getProductBuyerGroupId() {
		return this.productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
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
