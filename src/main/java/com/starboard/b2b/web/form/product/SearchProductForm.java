package com.starboard.b2b.web.form.product;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchProductForm {
	private int page = 1;
	private long brandId;

	private String keyword;
	private String showType;
	private String selectedBrand;
	private String selectedBuyerGroup;
	private String selectedModel;
	private String selectedYear;
	private String selectedTechnology;

	public String getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(String selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public String getSelectedModel() {
		return selectedModel;
	}

	public void setSelectedModel(String selectedModel) {
		this.selectedModel = selectedModel;
	}

	public String getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(String selectedYear) {
		this.selectedYear = selectedYear;
	}

	public String getSelectedTechnology() {
		return selectedTechnology;
	}

	public void setSelectedTechnology(String selectedTechnology) {
		this.selectedTechnology = selectedTechnology;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public String getSelectedBuyerGroup() {
		return selectedBuyerGroup;
	}

	public void setSelectedBuyerGroup(String selectedBuyerGroup) {
		this.selectedBuyerGroup = selectedBuyerGroup;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
