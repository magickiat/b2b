package com.starboard.b2b.dto;

import java.util.Date;

public class ShippingTypeDTO {
	private String shippingTypeId;
	private String shippingTypeName;
	private String description;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public ShippingTypeDTO() {
	}

	public ShippingTypeDTO(String shippingTypeId, String shippingTypeName, String description, String userCreate, String userUpdate, Date timeCreate,
			Date timeUpdate) {
		this.shippingTypeId = shippingTypeId;
		this.shippingTypeName = shippingTypeName;
		this.description = description;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	public String getShippingTypeId() {
		return shippingTypeId;
	}

	public void setShippingTypeId(String shippingTypeId) {
		this.shippingTypeId = shippingTypeId;
	}

	public String getShippingTypeName() {
		return shippingTypeName;
	}

	public void setShippingTypeName(String shippingTypeName) {
		this.shippingTypeName = shippingTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
