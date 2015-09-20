
package com.starboard.b2b.model;

public class RelateProduct extends BaseModel {

	private long productId;
	private long relateProductId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getRelateProductId() {
		return relateProductId;
	}

	public void setRelateProductId(long relateProductId) {
		this.relateProductId = relateProductId;
	}

}
