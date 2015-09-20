
package com.starboard.b2b.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_img")
public class ProductImg extends BaseModel {
	@Id
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
