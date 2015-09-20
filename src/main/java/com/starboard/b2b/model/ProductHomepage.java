
package com.starboard.b2b.model;

public class ProductHomepage extends BaseModel {

	private long productHomepageId;
	private long homePageId;
	private long productId;
	private long priority;

	public long getProductHomepageId() {
		return productHomepageId;
	}

	public void setProductHomepageId(long productHomepageId) {
		this.productHomepageId = productHomepageId;
	}

	public long getHomePageId() {
		return homePageId;
	}

	public void setHomePageId(long homePageId) {
		this.homePageId = homePageId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

}
