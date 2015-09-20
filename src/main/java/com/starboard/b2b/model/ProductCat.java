
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_cat")
public class ProductCat extends BaseModel {
	@Id
	@Column(name = "product_cat_id")
	private long productCatId;

	@Column(name = "product_cat_name")
	private String productCatName;

	@Column(name = "product_cat_parent_id")
	private long productCatParentId;

	@Column(name = "product_cat_description")
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
