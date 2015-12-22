package com.starboard.b2b.dto;

import java.util.Date;

import com.starboard.b2b.model.BaseModel;

public class BaseDTO {
	protected String userCreate;
	protected String userUpdate;
	protected Date timeCreate;
	protected Date timeUpdate;

	public BaseDTO() {
	}

	public BaseDTO(BaseModel base) {
		this.userCreate = base.getUserCreate();
		this.userUpdate = base.getUserUpdate();
		this.timeCreate = base.getTimeCreate();
		this.timeUpdate = base.getTimeUpdate();
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
