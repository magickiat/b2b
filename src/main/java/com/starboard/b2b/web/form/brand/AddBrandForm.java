package com.starboard.b2b.web.form.brand;

import java.util.List;

public class AddBrandForm {
	private Integer custId;
	private List<String> selectedBrand;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public List<String> getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(List<String> selectedBrand) {
		this.selectedBrand = selectedBrand;
	}
}
