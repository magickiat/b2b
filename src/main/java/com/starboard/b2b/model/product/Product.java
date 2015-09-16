package com.starboard.b2b.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;
import com.starboard.b2b.model.Brand;

@Entity
@Table(name = "product")
public class Product extends BaseModel {

	@Column(length = 50)
	private String code;

	@Column(length = 100)
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	private Brand brand;

	@Column(name = "picture_big", length = 255)
	private String pictureBig;

	@Column(name = "picture_medium", length = 255)
	private String pictureMedium;

	@Column(name = "picture_small_horizontal", length = 255)
	private String pictureSmallHorizontal;

	@Column(name = "picture_small_vertical", length = 255)
	private String pictureSmallVertical;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	private Model model;

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

	public String getPictureSmallHorizontal() {
		return pictureSmallHorizontal;
	}

	public void setPictureSmallHorizontal(String pictureSmallHorizontal) {
		this.pictureSmallHorizontal = pictureSmallHorizontal;
	}

	public String getPictureSmallVertical() {
		return pictureSmallVertical;
	}

	public void setPictureSmallVertical(String pictureSmallVertical) {
		this.pictureSmallVertical = pictureSmallVertical;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
