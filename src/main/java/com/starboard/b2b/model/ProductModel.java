
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_model")
public class ProductModel extends BaseModel {
	@Id
	@Column(name = "product_model_id")
	private String productModelId;
	@Column(name = "product_model_name")
	private String productModelName;
	@Column(name = "description")
	private String description;

	public String getProductModelId() {
		return productModelId;
	}

	public void setProductModelId(String productModelId) {
		this.productModelId = productModelId;
	}

	public String getProductModelName() {
		return productModelName;
	}

	public void setProductModelName(String productModelName) {
		this.productModelName = productModelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
