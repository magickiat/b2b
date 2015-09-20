package com.starboard.b2b.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;

@Entity
@Table(name = "product_category")
public class ProductCategory extends BaseModel {
	@Id
	@Column(name = "product_category_id", length = 16)
	private String productCategoryId;
	
	@Column(name = "product_category_name", length = 100)
	private String productCategoryName;
	
	@Column(length = 1024)
	private String description;

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
