
package com.starboard.b2b.dto;

public class ProductTypeDTO {

	private long productTypeId;
	private String productTypeName;
	private long productTypeParentId;
	private String productTypeDescription;

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public long getProductTypeParentId() {
		return productTypeParentId;
	}

	public void setProductTypeParentId(long productTypeParentId) {
		this.productTypeParentId = productTypeParentId;
	}

	public String getProductTypeDescription() {
		return productTypeDescription;
	}

	public void setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
	}

}
