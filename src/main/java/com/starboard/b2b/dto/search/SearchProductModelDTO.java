package com.starboard.b2b.dto.search;

import java.math.BigDecimal;

public class SearchProductModelDTO {
	private long productId;
	private String productCode;
	private String productNameEn;
	private String productPictureMedium;
	private String productModelId;
	private String productModelName;
	private BigDecimal productPrice;
	private String productUnitId;
	private String productCurrency;

	public SearchProductModelDTO(long productId, String productCode, String productPictureMedium, String productModelId, String productModelName,
			String productNameEn, BigDecimal productPrice, String productUnitId, String productCurrency) {
		this.productId = productId;
		this.productCode = productCode;
		this.productPictureMedium = productPictureMedium;
		this.productModelId = productModelId;
		this.productModelName = productModelName;
		this.productNameEn = productNameEn;
		this.productPrice = productPrice;
		this.productUnitId = productUnitId;
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

	public String getProductNameEn() {
		return productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}
}
