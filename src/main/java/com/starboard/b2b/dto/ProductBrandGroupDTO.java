
package com.starboard.b2b.dto;

public class ProductBrandGroupDTO {

	private long brandGroupId;
	private long productTypeId;
	
	public ProductBrandGroupDTO() {
	}

	
	public ProductBrandGroupDTO(long brandGroupId, long productTypeId) {
		this.brandGroupId = brandGroupId;
		this.productTypeId = productTypeId;
	}


	public long getBrandGroupId() {
		return brandGroupId;
	}

	public void setBrandGroupId(long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

}
