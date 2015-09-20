package com.starboard.b2b.dto;

import com.starboard.b2b.model.Brand;

public class BrandDTO extends BaseDTO {
	private Integer id;
	private String name;
	private String logo;
	
	public BrandDTO() {
	}

	public BrandDTO(Brand brand) {
		this.id = brand.getId();
		this.name = brand.getName();
		this.logo = brand.getLogo();
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
