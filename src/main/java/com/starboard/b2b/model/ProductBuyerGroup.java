
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_buyer_group")
public class ProductBuyerGroup extends BaseModel {
	@Id
	@Column(name = "product_buyer_group_id")
	private String productBuyerGroupId;
	
	@Column(name = "product_buyer_group_name")
	private String productBuyerGroupName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "seq")
	private int seq;

	public String getProductBuyerGroupId() {
		return productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	public String getProductBuyerGroupName() {
		return productBuyerGroupName;
	}

	public void setProductBuyerGroupName(String productBuyerGroupName) {
		this.productBuyerGroupName = productBuyerGroupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}
