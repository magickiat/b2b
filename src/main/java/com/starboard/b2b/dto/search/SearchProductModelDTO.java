package com.starboard.b2b.dto.search;

public class SearchProductModelDTO {
	private long productId;
	private String productCode;
	private String productPictureMedium;
	private String productModelId;
	private String productModelName;

	public SearchProductModelDTO(long productId, String productCode, String productPictureMedium, String productModelId,
			String productModelName) {
		this.productId = productId;
		this.productCode = productCode;
		this.productPictureMedium = productPictureMedium;
		this.productModelId = productModelId;
		this.productModelName = productModelName;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public String getProductPictureMedium() {
		return productPictureMedium;
	}

	public void setProductPictureMedium(String productPictureMedium) {
		this.productPictureMedium = productPictureMedium;
	}
}
