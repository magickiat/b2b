package com.starboard.b2b.model.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;

@Entity
@Table(name = "product_group")
public class ProductGroup extends BaseModel {
	
	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
