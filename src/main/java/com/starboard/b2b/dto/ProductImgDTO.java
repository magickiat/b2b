
package com.starboard.b2b.dto;

public class ProductImgDTO {

	private long productImgId;
	private String productCode;
	private String imgPath;
	private String productImgType;

	public long getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(long productImgId) {
		this.productImgId = productImgId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getProductImgType() {
		return productImgType;
	}

	public void setProductImgType(String productImgType) {
		this.productImgType = productImgType;
	}

}
