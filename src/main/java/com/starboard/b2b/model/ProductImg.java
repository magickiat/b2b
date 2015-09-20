
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_img")
public class ProductImg extends BaseModel {
	@Id
	@Column(name = "product_img_id")
	private long productImgId;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "img_path")
	private String imgPath;
	@Column(name = "product_img_type")
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
