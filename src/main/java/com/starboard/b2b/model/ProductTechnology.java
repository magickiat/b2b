
package com.starboard.b2b.model;

public class ProductTechnology extends BaseModel {

	private String productTechnologyId;
	private String productTechnologyName;
	private String description;

	public String getProductTechnologyId() {
		return productTechnologyId;
	}

	public void setProductTechnologyId(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	public String getProductTechnologyName() {
		return productTechnologyName;
	}

	public void setProductTechnologyName(String productTechnologyName) {
		this.productTechnologyName = productTechnologyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
