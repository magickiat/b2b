
package com.starboard.b2b.dto;

public class ProductTypeDTO extends BaseDTO {

	private Long productTypeId;
	private String productTypeName;
	private Long productTypeParentId;
	private String productTypeDescription;
	private Long brandGroupId;

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Long getProductTypeParentId() {
		return productTypeParentId;
	}

	public void setProductTypeParentId(Long productTypeParentId) {
		this.productTypeParentId = productTypeParentId;
	}

	public String getProductTypeDescription() {
		return productTypeDescription;
	}

	public void setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
	}

	public Long getBrandGroupId() {
		return brandGroupId;
	}

	public void setBrandGroupId(Long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

}
