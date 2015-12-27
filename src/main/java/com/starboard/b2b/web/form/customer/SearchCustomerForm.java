package com.starboard.b2b.web.form.customer;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.ProductTypeDTO;

public class SearchCustomerForm {
	private int page = 1;
	
	private String keyword;
	private Long selectedBrand;
	private String selectedCountry;

	private List<CountryDTO> countryList;
	private List<ProductTypeDTO> productTypeList;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(Long selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public String getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public List<CountryDTO> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryDTO> countryList) {
		this.countryList = countryList;
	}

	public List<ProductTypeDTO> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<ProductTypeDTO> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
