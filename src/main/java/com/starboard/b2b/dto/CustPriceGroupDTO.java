package com.starboard.b2b.dto;

import java.util.Date;

public class CustPriceGroupDTO {

	private long custPriceGroupId;
	private String custCode;
	private Long productTypeId;
	private String productBuyerGroupId;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public CustPriceGroupDTO() {
	}

	public CustPriceGroupDTO(long custPriceGroupId, String custCode) {
		this.custPriceGroupId = custPriceGroupId;
		this.custCode = custCode;
	}

	public CustPriceGroupDTO(long custPriceGroupId, String custCode, Long productTypeId, String productBuyerGroupId,
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

	public long getCustPriceGroupId() {
		return custPriceGroupId;
	}

	public void setCustPriceGroupId(long custPriceGroupId) {
		this.custPriceGroupId = custPriceGroupId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductBuyerGroupId() {
		return productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
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
