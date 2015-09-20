
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relate_product")
public class RelateProduct extends BaseModel {
	@Id
	@Column(name = "product_id")
	private long productId;
	@Column(name = "relate_product_id")
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
