
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_price_group")
public class ProductPriceGroup extends BaseModel {
	@Id
	@Column(name = "product_price_group_id")
	private String productPriceGroupId;
	@Column(name = "product_price_group_name")
	private String productPriceGroupName;
	@Column(name = "description")
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
