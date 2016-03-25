
package com.starboard.b2b.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long productId;

	private long productTypeId;
	private long productCatalogId;
	private long productGroupId;
	private String productCode;
	private String productNameTh;
	private String productNameEn;
	private java.math.BigDecimal productPrice;
	private java.math.BigDecimal productDiscount;
	private java.math.BigDecimal productTotalPrice;
	private String productCurrency;
	private String productBand;
	private long productQuantity;
	private java.math.BigDecimal productWeight;
	private String productPreintro;
	private int productIntro;
	private String productDetail;
	private String productSummarize;
	private String productLink;
	private long productStatus;
	private long productStock;
	private String productItemGroupId;
	private String vendor;
	private String productItemTypeId;
	private String productSubcategoryId;
	private String searchName;
	private String productTechnologyId;
	private String productDesign;
	private String supCatG;
	private java.math.BigDecimal productWidth;
	private String productLength;
	private String supGroup;
	private String productBuyerGroupId;
	private String productCategoryId;
	private String productModelId;
	private String productYearId;
	private String productUnitId;
	private java.math.BigDecimal sortBy;
	private String isActive;
	private String company;
	private String soCategory;

	private String productPictureSmallHorizontal;
	private String productPictureSmallVertical;
	private String productPictureMedium;
	private String productPictureBig;
	
	private String statusFlag;
	
	public ProductDTO() {
	}
	
	public ProductDTO(Long productId, Long productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public long getProductCatalogId() {
		return productCatalogId;
	}

	public void setProductCatalogId(long productCatalogId) {
		this.productCatalogId = productCatalogId;
	}

	public long getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(long productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductNameTh() {
		return productNameTh;
	}

	public void setProductNameTh(String productNameTh) {
		this.productNameTh = productNameTh;
	}

	public String getProductNameEn() {
		return productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}

	public java.math.BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(java.math.BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public java.math.BigDecimal getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(java.math.BigDecimal productDiscount) {
		this.productDiscount = productDiscount;
	}

	public java.math.BigDecimal getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(java.math.BigDecimal productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public String getProductBand() {
		return productBand;
	}

	public void setProductBand(String productBand) {
		this.productBand = productBand;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public java.math.BigDecimal getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(java.math.BigDecimal productWeight) {
		this.productWeight = productWeight;
	}

	public String getProductPreintro() {
		return productPreintro;
	}

	public void setProductPreintro(String productPreintro) {
		this.productPreintro = productPreintro;
	}

	public int getProductIntro() {
		return productIntro;
	}

	public void setProductIntro(int productIntro) {
		this.productIntro = productIntro;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getProductSummarize() {
		return productSummarize;
	}

	public void setProductSummarize(String productSummarize) {
		this.productSummarize = productSummarize;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	public long getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(long productStatus) {
		this.productStatus = productStatus;
	}

	public long getProductStock() {
		return productStock;
	}

	public void setProductStock(long productStock) {
		this.productStock = productStock;
	}

	public String getProductItemGroupId() {
		return productItemGroupId;
	}

	public void setProductItemGroupId(String productItemGroupId) {
		this.productItemGroupId = productItemGroupId;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getProductItemTypeId() {
		return productItemTypeId;
	}

	public void setProductItemTypeId(String productItemTypeId) {
		this.productItemTypeId = productItemTypeId;
	}

	public String getProductSubcategoryId() {
		return productSubcategoryId;
	}

	public void setProductSubcategoryId(String productSubcategoryId) {
		this.productSubcategoryId = productSubcategoryId;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getProductTechnologyId() {
		return productTechnologyId;
	}

	public void setProductTechnologyId(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	public String getProductDesign() {
		return productDesign;
	}

	public void setProductDesign(String productDesign) {
		this.productDesign = productDesign;
	}

	public String getSupCatG() {
		return supCatG;
	}

	public void setSupCatG(String supCatG) {
		this.supCatG = supCatG;
	}

	public java.math.BigDecimal getProductWidth() {
		return productWidth;
	}

	public void setProductWidth(java.math.BigDecimal productWidth) {
		this.productWidth = productWidth;
	}

	public String getProductLength() {
		return productLength;
	}

	public void setProductLength(String productLength) {
		this.productLength = productLength;
	}

	public String getSupGroup() {
		return supGroup;
	}

	public void setSupGroup(String supGroup) {
		this.supGroup = supGroup;
	}

	public String getProductBuyerGroupId() {
		return productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductModelId() {
		return productModelId;
	}

	public void setProductModelId(String productModelId) {
		this.productModelId = productModelId;
	}

	public String getProductYearId() {
		return productYearId;
	}

	public void setProductYearId(String productYearId) {
		this.productYearId = productYearId;
	}

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public java.math.BigDecimal getSortBy() {
		return sortBy;
	}

	public void setSortBy(java.math.BigDecimal sortBy) {
		this.sortBy = sortBy;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSoCategory() {
		return soCategory;
	}

	public void setSoCategory(String soCategory) {
		this.soCategory = soCategory;
	}

	public String getProductPictureSmallHorizontal() {
		return productPictureSmallHorizontal;
	}

	public void setProductPictureSmallHorizontal(String productPictureSmallHorizontal) {
		this.productPictureSmallHorizontal = productPictureSmallHorizontal;
	}

	public String getProductPictureSmallVertical() {
		return productPictureSmallVertical;
	}

	public void setProductPictureSmallVertical(String productPictureSmallVertical) {
		this.productPictureSmallVertical = productPictureSmallVertical;
	}

	public String getProductPictureMedium() {
		return productPictureMedium;
	}

	public void setProductPictureMedium(String productPictureMedium) {
		this.productPictureMedium = productPictureMedium;
	}

	public String getProductPictureBig() {
		return productPictureBig;
	}

	public void setProductPictureBig(String productPictureBig) {
		this.productPictureBig = productPictureBig;
	}

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}
}
