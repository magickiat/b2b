package com.starboard.b2b.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;
import com.starboard.b2b.model.Brand;

@Entity
@Table(name = "product")
public class Product extends BaseModel {
	private String code;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Brand brand;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Image image;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
