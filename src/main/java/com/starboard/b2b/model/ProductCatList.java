
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_cat_list")
public class ProductCatList {
	@Id
	@Column(name = "product_id")
	private long productId;

	@Column(name = "product_cat_id")
	private long productCatId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(long productCatId) {
		this.productCatId = productCatId;
	}

}
