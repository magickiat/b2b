
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_technology")
public class ProductTechnology extends BaseModel {
	@Id
	@Column(name = "product_technology_id")
	private String productTechnologyId;
	@Column(name = "product_technology_name")
	private String productTechnologyName;
	@Column(name = "description")
	private String description;

	public String getProductTechnologyId() {
		return productTechnologyId;
	}

	public void setProductTechnologyId(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	public String getProductTechnologyName() {
		return productTechnologyName;
	}

	public void setProductTechnologyName(String productTechnologyName) {
		this.productTechnologyName = productTechnologyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
