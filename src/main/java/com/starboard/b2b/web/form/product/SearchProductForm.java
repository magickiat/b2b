package com.starboard.b2b.web.form.product;

import java.util.List;

public class SearchProductForm {
	private String searchCondition;
	private List<String> selectedBrand;
	private List<String> selectedCategory;
	private List<String> selectedModel;
	private List<String> selectedYear;
	private List<String> selectedTechnology;

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public List<String> getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(List<String> selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public List<String> getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(List<String> selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public List<String> getSelectedModel() {
		return selectedModel;
	}

	public void setSelectedModel(List<String> selectedModel) {
		this.selectedModel = selectedModel;
	}

	public List<String> getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(List<String> selectedYear) {
		this.selectedYear = selectedYear;
	}

	public List<String> getSelectedTechnology() {
		return selectedTechnology;
	}

	public void setSelectedTechnology(List<String> selectedTechnology) {
		this.selectedTechnology = selectedTechnology;
	}
}
