
package com.starboard.b2b.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_unit")
public class ProductUnit extends BaseModel {
	@Id
	private String productUnitId;
	private String productUnitName;
	private String description;

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getProductUnitName() {
		return productUnitName;
	}

	public void setProductUnitName(String productUnitName) {
		this.productUnitName = productUnitName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
