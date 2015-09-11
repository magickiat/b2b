package com.starboard.b2b.web.form.brand;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BrandForm {
	private Integer custId;
	private List<Integer> selectedBrand;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

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
}
