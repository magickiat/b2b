
package com.starboard.b2b.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_year")
public class ProductYear extends BaseModel {
	@Id
	private String productYearId;
	private String productYearName;
	private String description;

	public String getProductYearId() {
		return productYearId;
	}

	public void setProductYearId(String productYearId) {
		this.productYearId = productYearId;
	}

	public String getProductYearName() {
		return productYearName;
	}

	public void setProductYearName(String productYearName) {
		this.productYearName = productYearName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
