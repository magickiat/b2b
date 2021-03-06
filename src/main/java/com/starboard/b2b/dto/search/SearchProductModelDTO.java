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
	private String modelImage;
	private String productPreintro;
	private String isActive;
	private String productTechnologyId;
	private String year;
	private Long productTypeId;
	private String productBuyerGroupId;
	private String productLength;
	private String vendor;
	private String productCategoryId;
	private String statusFlag;
	private String productTypeName;

	public SearchProductModelDTO(long productId, String productCode, String productPictureMedium, String productModelId, String productModelName,
			String productNameEn, BigDecimal productPrice, String productUnitId, String productCurrency, String modelImage, String productPreintro,
			String isActive, String productTechnologyId, String year, Long productTypeId, String productBuyerGroupId, String productLength,
			String vendor, String productCategoryId, String statusFlag, String productTypeName) {
		this.productId = productId;
		this.productCode = productCode;
		this.productPictureMedium = productPictureMedium;
		this.productModelId = productModelId;
		this.productModelName = productModelName;
		this.productNameEn = productNameEn;
		this.productPrice = productPrice;
		this.productUnitId = productUnitId;
		this.modelImage = modelImage;
		this.productPreintro = productPreintro;
		this.isActive = isActive;
		this.productTechnologyId = productTechnologyId;
		this.year = year;
		this.productTypeId = productTypeId;
		this.productBuyerGroupId = productBuyerGroupId;
		this.productLength = productLength;
		this.vendor = vendor;
		this.productCategoryId = productCategoryId;
		this.statusFlag = statusFlag;
		this.productTypeName = productTypeName;
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

	public String getModelImage() {
		return modelImage;
	}

	public void setModelImage(String modelImage) {
		this.modelImage = modelImage;
	}

	public String getProductPreintro() {
		return productPreintro;
	}

	public void setProductPreintro(String productPreintro) {
		this.productPreintro = productPreintro;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getProductTechnologyId() {
		return productTechnologyId;
	}

	public void setProductTechnologyId(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductBuyerGroupId() {
		return productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	public String getProductLength() {
		return productLength;
	}

	public void setProductLength(String productLength) {
		this.productLength = productLength;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

}
