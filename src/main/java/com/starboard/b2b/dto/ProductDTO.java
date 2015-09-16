package com.starboard.b2b.dto;

import com.starboard.b2b.model.product.Product;

public class ProductDTO extends BaseDTO {
	private String code;
	private String name;
	private BrandDTO brand;
	private ModelDTO model;
	private String pictureBig;
	private String pictureMedium;
	private String pictureSmallHorizontal;
	private String pictureSmallVertical;

	public ProductDTO() {
	}

	public ProductDTO(Product product) {
		super(product);
		this.code = product.getCode();
		this.name = product.getName();
		this.brand = new BrandDTO(product.getBrand());
		this.model = new ModelDTO(product.getModel());
		this.pictureBig = product.getPictureBig();
		this.pictureMedium = product.getPictureMedium();
		this.pictureSmallHorizontal = product.getPictureSmallHorizontal();
		this.pictureSmallVertical = product.getPictureSmallVertical();
	}

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

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public ModelDTO getModel() {
		return model;
	}

	public void setModel(ModelDTO model) {
		this.model = model;
	}
}
