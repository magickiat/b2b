
package com.starboard.b2b.model;

public class ProductBrandGroup extends BaseModel {

	private long brandGroupId;
	private long productTypeId;

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
