
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_item_group")
public class ProductItemGroup extends BaseModel {
	@Id
	@Column(name = "product_item_group_id")
	private String productItemGroupId;
	@Column(name = "product_item_group_name")
	private String productItemGroupName;
	@Column(name = "description")
	private String description;

	public String getProductItemGroupId() {
		return productItemGroupId;
	}

	public void setProductItemGroupId(String productItemGroupId) {
		this.productItemGroupId = productItemGroupId;
	}

	public String getProductItemGroupName() {
		return productItemGroupName;
	}

	public void setProductItemGroupName(String productItemGroupName) {
		this.productItemGroupName = productItemGroupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
