package com.starboard.b2b.web.form.brand;


public class BrandForm {
	private String name;
	private String logo;
	private boolean commonBrand;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public boolean isCommonBrand() {
		return commonBrand;
	}
	public void setCommonBrand(boolean commonBrand) {
		this.commonBrand = commonBrand;
	}
	
}
