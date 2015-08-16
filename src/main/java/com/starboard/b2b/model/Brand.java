package com.starboard.b2b.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand extends BaseModel {
	@Column(length = 255, nullable = false)
	private String name;

	@Column(name = "is_common_brand", nullable = false)
	private boolean commonBrand;
	
	private List<Brand> subBrand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCommonBrand() {
		return commonBrand;
	}

	public void setCommonBrand(boolean commonBrand) {
		this.commonBrand = commonBrand;
	}
}
