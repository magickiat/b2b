package com.starboard.b2b.model.sync;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TmpProduct generated by hbm2java
 */
@Entity
@Table(name = "tmp_product")
public class TmpProduct implements java.io.Serializable {

	private long productId;
	private Long productTypeId;
	private Long productCatalogId;
	private Long productGroupId;
	private String productCode;
	private String productNameTh;
	private String productNameEn;
	private BigDecimal productPrice;
	private BigDecimal productDiscount;
	private BigDecimal productTotalPrice;
	private String productBand;
	private Long productQuantity;
	private BigDecimal productWeight;
	private String productPreintro;
	private String productIntro;
	private String productDetail;
	private String productSummarize;
	private String productLink;
	private String productPictureSmall;
	private String productPictureMeduim;
	private String productPictureBig;
	private Long productStatus;
	private Long productStock;
	private String productItemGroupId;
	private String vendor;
	private String productItemTypeId;
	private String productSubcategoryId;
	private String searchName;
	private String productTechnologyId;
	private String productDesign;
	private String supCatG;
	private Long productWidth;
	private Long productLength;
	private String supGroup;
	private String productBuyerGroupId;
	private String productCategoryId;
	private String productModelId;
	private String productYearId;
	private String productUnitId;
	private BigDecimal sortBy;
	private String isActive;
	private String dtsSystem;
	private Date dtsUpdate;

	public TmpProduct() {
	}

	public TmpProduct(long productId) {
		this.productId = productId;
	}

	public TmpProduct(long productId, Long productTypeId, Long productCatalogId, Long productGroupId,
			String productCode, String productNameTh, String productNameEn, BigDecimal productPrice,
			BigDecimal productDiscount, BigDecimal productTotalPrice, String productBand, Long productQuantity,
			BigDecimal productWeight, String productPreintro, String productIntro, String productDetail,
			String productSummarize, String productLink, String productPictureSmall, String productPictureMeduim,
			String productPictureBig, Long productStatus, Long productStock, String productItemGroupId, String vendor,
			String productItemTypeId, String productSubcategoryId, String searchName, String productTechnologyId,
			String productDesign, String supCatG, Long productWidth, Long productLength, String supGroup,
			String productBuyerGroupId, String productCategoryId, String productModelId, String productYearId,
			String productUnitId, BigDecimal sortBy, String isActive, String dtsSystem, Date dtsUpdate) {
		this.productId = productId;
		this.productTypeId = productTypeId;
		this.productCatalogId = productCatalogId;
		this.productGroupId = productGroupId;
		this.productCode = productCode;
		this.productNameTh = productNameTh;
		this.productNameEn = productNameEn;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productTotalPrice = productTotalPrice;
		this.productBand = productBand;
		this.productQuantity = productQuantity;
		this.productWeight = productWeight;
		this.productPreintro = productPreintro;
		this.productIntro = productIntro;
		this.productDetail = productDetail;
		this.productSummarize = productSummarize;
		this.productLink = productLink;
		this.productPictureSmall = productPictureSmall;
		this.productPictureMeduim = productPictureMeduim;
		this.productPictureBig = productPictureBig;
		this.productStatus = productStatus;
		this.productStock = productStock;
		this.productItemGroupId = productItemGroupId;
		this.vendor = vendor;
		this.productItemTypeId = productItemTypeId;
		this.productSubcategoryId = productSubcategoryId;
		this.searchName = searchName;
		this.productTechnologyId = productTechnologyId;
		this.productDesign = productDesign;
		this.supCatG = supCatG;
		this.productWidth = productWidth;
		this.productLength = productLength;
		this.supGroup = supGroup;
		this.productBuyerGroupId = productBuyerGroupId;
		this.productCategoryId = productCategoryId;
		this.productModelId = productModelId;
		this.productYearId = productYearId;
		this.productUnitId = productUnitId;
		this.sortBy = sortBy;
		this.isActive = isActive;
		this.dtsSystem = dtsSystem;
		this.dtsUpdate = dtsUpdate;
	}

	@Id

	@Column(name = "product_id", unique = true, nullable = false)
	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Column(name = "product_type_id")
	public Long getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Column(name = "product_catalog_id")
	public Long getProductCatalogId() {
		return this.productCatalogId;
	}

	public void setProductCatalogId(Long productCatalogId) {
		this.productCatalogId = productCatalogId;
	}

	@Column(name = "product_group_id")
	public Long getProductGroupId() {
		return this.productGroupId;
	}

	public void setProductGroupId(Long productGroupId) {
		this.productGroupId = productGroupId;
	}

	@Column(name = "product_code", length = 32)
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "product_name_th")
	public String getProductNameTh() {
		return this.productNameTh;
	}

	public void setProductNameTh(String productNameTh) {
		this.productNameTh = productNameTh;
	}

	@Column(name = "product_name_en")
	public String getProductNameEn() {
		return this.productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}

	@Column(name = "product_price", precision = 10)
	public BigDecimal getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "product_discount", precision = 10)
	public BigDecimal getProductDiscount() {
		return this.productDiscount;
	}

	public void setProductDiscount(BigDecimal productDiscount) {
		this.productDiscount = productDiscount;
	}

	@Column(name = "product_total_price", precision = 10)
	public BigDecimal getProductTotalPrice() {
		return this.productTotalPrice;
	}

	public void setProductTotalPrice(BigDecimal productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	@Column(name = "product_band", length = 100)
	public String getProductBand() {
		return this.productBand;
	}

	public void setProductBand(String productBand) {
		this.productBand = productBand;
	}

	@Column(name = "product_quantity")
	public Long getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Column(name = "product_weight", precision = 10)
	public BigDecimal getProductWeight() {
		return this.productWeight;
	}

	public void setProductWeight(BigDecimal productWeight) {
		this.productWeight = productWeight;
	}

	@Column(name = "product_preintro", length = 65535)
	public String getProductPreintro() {
		return this.productPreintro;
	}

	public void setProductPreintro(String productPreintro) {
		this.productPreintro = productPreintro;
	}

	@Column(name = "product_intro", length = 1024)
	public String getProductIntro() {
		return this.productIntro;
	}

	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}

	@Column(name = "product_detail", length = 65535)
	public String getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	@Column(name = "product_summarize", length = 65535)
	public String getProductSummarize() {
		return this.productSummarize;
	}

	public void setProductSummarize(String productSummarize) {
		this.productSummarize = productSummarize;
	}

	@Column(name = "product_link", length = 100)
	public String getProductLink() {
		return this.productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	@Column(name = "product_picture_small")
	public String getProductPictureSmall() {
		return this.productPictureSmall;
	}

	public void setProductPictureSmall(String productPictureSmall) {
		this.productPictureSmall = productPictureSmall;
	}

	@Column(name = "product_picture_meduim")
	public String getProductPictureMeduim() {
		return this.productPictureMeduim;
	}

	public void setProductPictureMeduim(String productPictureMeduim) {
		this.productPictureMeduim = productPictureMeduim;
	}

	@Column(name = "product_picture_big")
	public String getProductPictureBig() {
		return this.productPictureBig;
	}

	public void setProductPictureBig(String productPictureBig) {
		this.productPictureBig = productPictureBig;
	}

	@Column(name = "product_status")
	public Long getProductStatus() {
		return this.productStatus;
	}

	public void setProductStatus(Long productStatus) {
		this.productStatus = productStatus;
	}

	@Column(name = "product_stock")
	public Long getProductStock() {
		return this.productStock;
	}

	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}

	@Column(name = "product_item_group_id", length = 16)
	public String getProductItemGroupId() {
		return this.productItemGroupId;
	}

	public void setProductItemGroupId(String productItemGroupId) {
		this.productItemGroupId = productItemGroupId;
	}

	@Column(name = "vendor", length = 32)
	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Column(name = "product_item_type_id", length = 16)
	public String getProductItemTypeId() {
		return this.productItemTypeId;
	}

	public void setProductItemTypeId(String productItemTypeId) {
		this.productItemTypeId = productItemTypeId;
	}

	@Column(name = "product_subcategory_id", length = 16)
	public String getProductSubcategoryId() {
		return this.productSubcategoryId;
	}

	public void setProductSubcategoryId(String productSubcategoryId) {
		this.productSubcategoryId = productSubcategoryId;
	}

	@Column(name = "search_name", length = 64)
	public String getSearchName() {
		return this.searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	@Column(name = "product_technology_id", length = 16)
	public String getProductTechnologyId() {
		return this.productTechnologyId;
	}

	public void setProductTechnologyId(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	@Column(name = "product_design", length = 32)
	public String getProductDesign() {
		return this.productDesign;
	}

	public void setProductDesign(String productDesign) {
		this.productDesign = productDesign;
	}

	@Column(name = "sup_cat_g", length = 32)
	public String getSupCatG() {
		return this.supCatG;
	}

	public void setSupCatG(String supCatG) {
		this.supCatG = supCatG;
	}

	@Column(name = "product_width", precision = 10, scale = 0)
	public Long getProductWidth() {
		return this.productWidth;
	}

	public void setProductWidth(Long productWidth) {
		this.productWidth = productWidth;
	}

	@Column(name = "product_length", precision = 10, scale = 0)
	public Long getProductLength() {
		return this.productLength;
	}

	public void setProductLength(Long productLength) {
		this.productLength = productLength;
	}

	@Column(name = "sup_group", length = 32)
	public String getSupGroup() {
		return this.supGroup;
	}

	public void setSupGroup(String supGroup) {
		this.supGroup = supGroup;
	}

	@Column(name = "product_buyer_group_id", length = 16)
	public String getProductBuyerGroupId() {
		return this.productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	@Column(name = "product_category_id", length = 16)
	public String getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Column(name = "product_model_id", length = 16)
	public String getProductModelId() {
		return this.productModelId;
	}

	public void setProductModelId(String productModelId) {
		this.productModelId = productModelId;
	}

	@Column(name = "product_year_id", length = 16)
	public String getProductYearId() {
		return this.productYearId;
	}

	public void setProductYearId(String productYearId) {
		this.productYearId = productYearId;
	}

	@Column(name = "product_unit_id", length = 16)
	public String getProductUnitId() {
		return this.productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	@Column(name = "sort_by", precision = 5)
	public BigDecimal getSortBy() {
		return this.sortBy;
	}

	public void setSortBy(BigDecimal sortBy) {
		this.sortBy = sortBy;
	}

	@Column(name = "is_active", length = 1)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "dts_system", length = 32)
	public String getDtsSystem() {
		return this.dtsSystem;
	}

	public void setDtsSystem(String dtsSystem) {
		this.dtsSystem = dtsSystem;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dts_update", length = 19)
	public Date getDtsUpdate() {
		return this.dtsUpdate;
	}

	public void setDtsUpdate(Date dtsUpdate) {
		this.dtsUpdate = dtsUpdate;
	}

}