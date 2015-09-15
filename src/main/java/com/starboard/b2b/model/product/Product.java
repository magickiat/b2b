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

	private String pictureBig;
	private String pictureMedium;
	private String pictureSmall;

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

	public String getPictureBig() {
		return pictureBig;
	}

	public void setPictureBig(String pictureBig) {
		this.pictureBig = pictureBig;
	}

	public String getPictureMedium() {
		return pictureMedium;
	}

	public void setPictureMedium(String pictureMedium) {
		this.pictureMedium = pictureMedium;
	}

	public String getPictureSmall() {
		return pictureSmall;
	}

	public void setPictureSmall(String pictureSmall) {
		this.pictureSmall = pictureSmall;
	}

}
