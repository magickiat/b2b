package com.starboard.b2b.dto;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchProductEmailDTO {
	private ProductTypeDTO productType;
	private List<ProductEmailDTO> emails;

	public ProductTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeDTO productType) {
		this.productType = productType;
	}

	public List<ProductEmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(List<ProductEmailDTO> emails) {
		this.emails = emails;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
