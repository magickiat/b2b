
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_brand_group")
public class ProductBrandGroup extends BaseModel {

	@Id
	@Column(name = "brand_group_id")
	private long brandGroupId;
	@Column(name = "product_type_id")
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
