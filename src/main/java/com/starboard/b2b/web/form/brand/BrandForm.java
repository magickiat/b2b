package com.starboard.b2b.web.form.brand;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BrandForm {
	private Long custId;
	private List<Integer> selectedBrand;


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
}
