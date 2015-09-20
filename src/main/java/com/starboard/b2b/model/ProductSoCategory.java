
package com.starboard.b2b.model;

public class ProductSoCategory extends BaseModel {

	private String soCategory;
	private String site;
	private String warehouse;
	private String saleOrderCat;
	private String email;

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

	public String getSaleOrderCat() {
		return saleOrderCat;
	}

	public void setSaleOrderCat(String saleOrderCat) {
		this.saleOrderCat = saleOrderCat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
