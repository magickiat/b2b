
package com.starboard.b2b.dto;

public class ProductBuyerGroupDTO {

	private String productBuyerGroupId;
	private String productBuyerGroupName;
	private String description;
	private int seq;

	public ProductBuyerGroupDTO() {
	}

	public ProductBuyerGroupDTO(String productBuyerGroupId, String productBuyerGroupName, String description, int seq) {
		this.productBuyerGroupId = productBuyerGroupId;
		this.productBuyerGroupName = productBuyerGroupName;
		this.description = description;
		this.seq = seq;
	}

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
