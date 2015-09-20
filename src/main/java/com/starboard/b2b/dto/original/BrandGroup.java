
package com.starboard.b2b.dto.original;

public class BrandGroup {

	private long brandGroupId;
	private String brandGroupName;
	private String brandGroupDescription;
	private String userCreate;
	private String userUpdate;
	private java.util.Date timeCreate;
	private java.util.Date timeUpdate;

	public long getBrandGroupId() {
		return brandGroupId;
	}

	public void setBrandGroupId(long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

	public String getBrandGroupName() {
		return brandGroupName;
	}

	public void setBrandGroupName(String brandGroupName) {
		this.brandGroupName = brandGroupName;
	}

	public String getBrandGroupDescription() {
		return brandGroupDescription;
	}

	public void setBrandGroupDescription(String brandGroupDescription) {
		this.brandGroupDescription = brandGroupDescription;
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

	public java.util.Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(java.util.Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public java.util.Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(java.util.Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

}
