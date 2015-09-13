package com.starboard.b2b.dto;

import com.starboard.b2b.model.Brand;

public class BrandDTO extends BaseDTO {
	private String name;
	private String logo;
	private boolean commonBrand;
	
	public BrandDTO() {
	}

	public BrandDTO(Brand brand) {
		super(brand);
		this.name = brand.getName();
		this.logo = brand.getLogo();
		this.commonBrand = brand.isCommonBrand();
	}
	
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
