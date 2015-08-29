package com.starboard.b2b.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;
import com.starboard.b2b.model.Brand;

@Entity
@Table(name = "product")
public class Product extends BaseModel {
	private String code;
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Brand brand;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Category category;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Image image;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Model model;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Price price;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Technology technology;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Unit unit;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Year year;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}
}
