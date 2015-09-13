package com.starboard.b2b.dto;

import java.util.Date;

import com.starboard.b2b.model.BaseModel;

public class BaseDTO {
	protected Integer id;
	protected String createdBy;
	protected Date createdDate;
	protected String updatedBy;
	protected Date updatedDate;

	public BaseDTO() {
	}
	
	public BaseDTO(BaseModel base){
		this.id = base.getId();
		this.createdBy = base.getCreatedBy();
		this.createdDate = base.getCreatedDate();
		this.updatedBy = base.getUpdatedBy();
		this.updatedDate = base.getUpdatedDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
