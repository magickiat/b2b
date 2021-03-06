package com.starboard.b2b.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tmp_product")
public class TmpProduct {

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
	private String productCurrency;
	private String productBand;
	private Long productQuantity;
	private BigDecimal productWeight;
	private String productPreintro;
	private Integer productIntro;
	private String productDetail;
	private String productSummarize;
	private String productLink;
	private String productPictureMedium;
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
	private BigDecimal productWidth;
	private String productLength;
	private String supGroup;
	private String productBuyerGroupId;
	private String productCategoryId;
	private String productModelId;
	private String productYearId;
	private String productUnitId;
	private BigDecimal sortBy;
	private String isActive;
	// if flag is 1 or 3 must set "isActive" = 1
	private String statusFlag; 
	private String company;
	private String soCategory;
	private String productPictureSmallHorizontal;
	private String productPictureSmallVertical;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;
	
	private String excelSheet;

	public TmpProduct() {
	}

	public TmpProduct(long productId) {
		this.productId = productId;
	}

	public TmpProduct(long productId, Long productTypeId, Long productCatalogId, Long productGroupId, String productCode,
			String productNameTh, String productNameEn, BigDecimal productPrice, BigDecimal productDiscount,
			BigDecimal productTotalPrice, String productCurrency, String productBand, Long productQuantity,
			BigDecimal productWeight, String productPreintro, Integer productIntro, String productDetail,
			String productSummarize, String productLink, String productPictureMedium, String productPictureBig,
			Long productStatus, Long productStock, String productItemGroupId, String vendor, String productItemTypeId,
			String productSubcategoryId, String searchName, String productTechnologyId, String productDesign,
			String supCatG, BigDecimal productWidth, String productLength, String supGroup, String productBuyerGroupId,
			String productCategoryId, String productModelId, String productYearId, String productUnitId,
			BigDecimal sortBy, String isActive, String company, String soCategory, String productPictureSmallHorizontal,
			String productPictureSmallVertical, String userCreate, String userUpdate, Date timeCreate,
			Date timeUpdate) {
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
		this.productCurrency = productCurrency;
		this.productBand = productBand;
		this.productQuantity = productQuantity;
		this.productWeight = productWeight;
		this.productPreintro = productPreintro;
		this.productIntro = productIntro;
		this.productDetail = productDetail;
		this.productSummarize = productSummarize;
		this.productLink = productLink;
		this.productPictureMedium = productPictureMedium;
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
		this.company = company;
		this.soCategory = soCategory;
		this.productPictureSmallHorizontal = productPictureSmallHorizontal;
		this.productPictureSmallVertical = productPictureSmallVertical;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "product_currency", length = 3)
	public String getProductCurrency() {
		return this.productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
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

	@Column(name = "product_intro")
	public Integer getProductIntro() {
		return this.productIntro;
	}

	public void setProductIntro(Integer productIntro) {
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

	@Column(name = "product_picture_medium")
	public String getProductPictureMedium() {
		return this.productPictureMedium;
	}

	public void setProductPictureMedium(String productPictureMedium) {
		this.productPictureMedium = productPictureMedium;
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

	@Column(name = "vendor", length = 100)
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

	@Column(name = "product_technology_id", length = 100)
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

	@Column(name = "product_width", precision = 10)
	public BigDecimal getProductWidth() {
		return this.productWidth;
	}

	public void setProductWidth(BigDecimal productWidth) {
		this.productWidth = productWidth;
	}

	@Column(name = "product_length", length = 100)
	public String getProductLength() {
		return this.productLength;
	}

	public void setProductLength(String productLength) {
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

	@Column(name = "product_model_id", length = 100)
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

	@Column(name = "company", length = 32)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "so_category", length = 32)
	public String getSoCategory() {
		return this.soCategory;
	}

	public void setSoCategory(String soCategory) {
		this.soCategory = soCategory;
	}

	@Column(name = "product_picture_small_horizontal")
	public String getProductPictureSmallHorizontal() {
		return this.productPictureSmallHorizontal;
	}

	public void setProductPictureSmallHorizontal(String productPictureSmallHorizontal) {
		this.productPictureSmallHorizontal = productPictureSmallHorizontal;
	}

	@Column(name = "product_picture_small_vertical")
	public String getProductPictureSmallVertical() {
		return this.productPictureSmallVertical;
	}

	public void setProductPictureSmallVertical(String productPictureSmallVertical) {
		this.productPictureSmallVertical = productPictureSmallVertical;
	}

	@Column(name = "user_create", length = 32)
	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	@Column(name = "user_update", length = 32)
	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_create", length = 19)
	public Date getTimeCreate() {
		return this.timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_update", length = 19)
	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	@Column(name = "status_flag", length = 1)
	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	@Column(name = "excel_sheet", length = 32)
	public String getExcelSheet() {
		return excelSheet;
	}

	public void setExcelSheet(String excelSheet) {
		this.excelSheet = excelSheet;
	}

	
}
