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

}
