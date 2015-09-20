
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_so_category")
public class ProductSoCategory extends BaseModel {
	@Id
	@Column(name = "so_category")
	private String soCategory;
	@Column(name = "site")
	private String site;
	@Column(name = "warehouse")
	private String warehouse;

	public String getSoCategory() {
		return soCategory;
	}

	public void setSoCategory(String soCategory) {
		this.soCategory = soCategory;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

}
