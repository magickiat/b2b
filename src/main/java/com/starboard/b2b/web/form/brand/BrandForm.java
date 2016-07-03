package com.starboard.b2b.web.form.brand;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BrandForm {
	private Long custId;
	private List<Integer> selectedBrand;
	private String userCreate;
	private String userUpdate;


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public List<Integer> getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(List<Integer> selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
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
