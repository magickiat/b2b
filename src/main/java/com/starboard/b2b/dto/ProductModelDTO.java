
package com.starboard.b2b.dto;

public class ProductModelDTO {

	private String productModelId;
	private String productModelName;
	private String description;
	private String image;
	private String headerText1;
	private String headerText2;

	public ProductModelDTO() {
	}

	public ProductModelDTO(String productModelId, String productModelName, String description, String image,
			String headerText1, String headerText2) {
		this.productModelId = productModelId;
		this.productModelName = productModelName;
		this.description = description;
		this.image = image;
		this.headerText1 = headerText1;
		this.headerText2 = headerText2;
	}

	public String getProductModelId() {
		return productModelId;
	}

	public void setProductModelId(String productModelId) {
		this.productModelId = productModelId;
	}

	public String getProductModelName() {
		return productModelName;
	}

	public void setProductModelName(String productModelName) {
		this.productModelName = productModelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHeaderText1() {
		return headerText1;
	}

	public void setHeaderText1(String headerText1) {
		this.headerText1 = headerText1;
	}

	public String getHeaderText2() {
		return headerText2;
	}

	public void setHeaderText2(String headerText2) {
		this.headerText2 = headerText2;
	}

}
