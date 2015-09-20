
package com.starboard.b2b.model;

public class ProductCat extends BaseModel {

	private long productCatId;
	private String productCatName;
	private long productCatParentId;
	private String productCatDescription;

	public long getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(long productCatId) {
		this.productCatId = productCatId;
	}

	public String getProductCatName() {
		return productCatName;
	}

	public void setProductCatName(String productCatName) {
		this.productCatName = productCatName;
	}

	public long getProductCatParentId() {
		return productCatParentId;
	}

	public void setProductCatParentId(long productCatParentId) {
		this.productCatParentId = productCatParentId;
	}

	public String getProductCatDescription() {
		return productCatDescription;
	}

	public void setProductCatDescription(String productCatDescription) {
		this.productCatDescription = productCatDescription;
	}

}
