
package com.starboard.b2b.model;

public class ProductPriceGroup extends BaseModel {

	private String productPriceGroupId;
	private String productPriceGroupName;
	private String description;

	public String getProductPriceGroupId() {
		return productPriceGroupId;
	}

	public void setProductPriceGroupId(String productPriceGroupId) {
		this.productPriceGroupId = productPriceGroupId;
	}

	public String getProductPriceGroupName() {
		return productPriceGroupName;
	}

	public void setProductPriceGroupName(String productPriceGroupName) {
		this.productPriceGroupName = productPriceGroupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
