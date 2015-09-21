
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseModel {

	@Id
	@Column(name = "product_id")
	private long productId;
	@Column(name = "product_type_id")
	private long productTypeId;
	@Column(name = "product_catalog_id")
	private long productCatalogId;
	@Column(name = "product_group_id")
	private long productGroupId;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "product_name_th")
	private String productNameTh;
	@Column(name = "product_name_en")
	private String productNameEn;
	@Column(name = "product_price")
	private java.math.BigDecimal productPrice;
	@Column(name = "product_discount")
	private java.math.BigDecimal productDiscount;
	@Column(name = "product_total_price")
	private java.math.BigDecimal productTotalPrice;
	@Column(name = "product_band")
	private String productBand;
	@Column(name = "product_quantity")
	private long productQuantity;
	@Column(name = "product_weight")
	private java.math.BigDecimal productWeight;
	@Column(name = "product_preintro")
	private String productPreintro;
	@Column(name = "product_intro")
	private int productIntro;
	@Column(name = "product_detail")
	private String productDetail;
	@Column(name = "product_summarize")
	private String productSummarize;
	@Column(name = "product_link")
	private String productLink;
	@Column(name = "product_picture_medium")
	private String productPictureMedium;
	@Column(name = "product_picture_big")
	private String productPictureBig;
	@Column(name = "product_status")
	private long productStatus;
	@Column(name = "product_stock")
	private long productStock;
	@Column(name = "product_item_group_id")
	private String productItemGroupId;
	@Column(name = "vendor")
	private String vendor;
	@Column(name = "product_item_type_id")
	private String productItemTypeId;
	@Column(name = "product_subcategory_id")
	private String productSubcategoryId;
	@Column(name = "search_name")
	private String searchName;
	@Column(name = "product_technology_id")
	private String productTechnologyId;
	@Column(name = "product_design")
	private String productDesign;
	@Column(name = "sup_cat_g")
	private String supCatG;
	@Column(name = "product_width")
	private java.math.BigDecimal productWidth;
	@Column(name = "product_length")
	private String productLength;
	@Column(name = "sup_group")
	private String supGroup;
	@Column(name = "product_buyer_group_id")
	private String productBuyerGroupId;
	@Column(name = "product_category_id")
	private String productCategoryId;
	@Column(name = "product_model_id")
	private String productModelId;
	@Column(name = "product_year_id")
	private String productYearId;
	@Column(name = "product_unit_id")
	private String productUnitId;
	@Column(name = "sort_by")
	private java.math.BigDecimal sortBy;
	@Column(name = "is_active")
	private String isActive;
	@Column(name = "company")
	private String company;
	@Column(name = "so_category")
	private String soCategory;
	@Column(name = "product_picture_small_horizontal")
	private String productPictureSmallHorizontal;
	@Column(name = "product_picture_small_vertical")
	private String productPictureSmallVertical;

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
}
