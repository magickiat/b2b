package com.starboard.b2b.dto;

import java.util.Date;

public class MobileTypeDTO extends BaseDTO {
	private String mobileId;
	private String description;
	private String name;
	private Date timeCreate;
	private Date timeUpdate;
	private String userCreate;
	private String userUpdate;
	public MobileTypeDTO(){
		
	}
	public MobileTypeDTO(String mobileId,String description,String name,Date timeCreate,Date timeUpdate,String userCreate,String userUpdate){
		super();
		this.mobileId = mobileId;
		this.description = description;
		this.name = name;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
