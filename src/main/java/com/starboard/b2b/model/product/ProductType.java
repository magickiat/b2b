package com.starboard.b2b.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;

@Entity
@Table(name = "product_type")
public class ProductType extends BaseModel {

	@Id
	@Column(name = "product_type_id", length = 20)
	private Integer productTypeId;

	@OneToOne(optional = true)
	private ProductType parent;

	@Column(name = "product_type_description", length = 1024)
	private String productTypeDescription;

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public ProductType getParent() {
		return parent;
	}

	public void setParent(ProductType parent) {
		this.parent = parent;
	}

	public String getProductTypeDescription() {
		return productTypeDescription;
	}

	public void setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
	}

}
