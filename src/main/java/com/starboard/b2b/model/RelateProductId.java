package com.starboard.b2b.model;
// Generated Sep 26, 2015 11:05:02 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RelateProductId generated by hbm2java
 */
@Embeddable
public class RelateProductId implements java.io.Serializable {

	private long productId;
	private long relateProductId;

	public RelateProductId() {
	}

	public RelateProductId(long productId, long relateProductId) {
		this.productId = productId;
		this.relateProductId = relateProductId;
	}

	@Column(name = "product_id", nullable = false)
	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Column(name = "relate_product_id", nullable = false)
	public long getRelateProductId() {
		return this.relateProductId;
	}

	public void setRelateProductId(long relateProductId) {
		this.relateProductId = relateProductId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RelateProductId))
			return false;
		RelateProductId castOther = (RelateProductId) other;

		return (this.getProductId() == castOther.getProductId())
				&& (this.getRelateProductId() == castOther.getRelateProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getProductId();
		result = 37 * result + (int) this.getRelateProductId();
		return result;
	}

}
