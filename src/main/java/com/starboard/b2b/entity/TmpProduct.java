
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpProduct implements Serializable {
    
    /** Creates a new instance of TmpProduct */
    public TmpProduct() {
    }
    public TmpProduct(
            long productId	
            , long productTypeId	
            , long productCatalogId	
            , long productGroupId	
            , String productCode	
            , String productNameTh	
            , String productNameEn	
            , java.math.BigDecimal productPrice	
            , java.math.BigDecimal productDiscount	
            , java.math.BigDecimal productTotalPrice	
            , String productBand	
            , long productQuantity	
            , java.math.BigDecimal productWeight	
            , String productPreintro	
            , String productIntro	
            , String productDetail	
            , String productSummarize	
            , String productLink	
            , String productPictureMeduim	
            , String productPictureBig	
            , long productStatus	
            , long productStock	
            , String productItemGroupId	
            , String vendor	
            , String productItemTypeId	
            , String productSubcategoryId	
            , String searchName	
            , String productTechnologyId	
            , String productDesign	
            , String supCatG	
            , java.math.BigDecimal productWidth	
            , java.math.BigDecimal productLength	
            , String supGroup	
            , String productBuyerGroupId	
            , String productCategoryId	
            , String productModelId	
            , String productYearId	
            , String productUnitId	
            , java.math.BigDecimal sortBy	
            , String isActive	
            , String company	
            , String soCategory	
            , String productPictureSmallHorizontal	
            , String productPictureSmallVertical	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
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
        this.company = company;	
        this.soCategory = soCategory;	
        this.productPictureSmallHorizontal = productPictureSmallHorizontal;	
        this.productPictureSmallVertical = productPictureSmallVertical;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
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
    private String productBand;	
    private long productQuantity;	
    private java.math.BigDecimal productWeight;	
    private String productPreintro;	
    private String productIntro;	
    private String productDetail;	
    private String productSummarize;	
    private String productLink;	
    private String productPictureMeduim;	
    private String productPictureBig;	
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
    private java.math.BigDecimal productLength;	
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
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public long getProductTypeId() {
        return this.productTypeId;
    }		
    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }
    public long getProductCatalogId() {
        return this.productCatalogId;
    }		
    public void setProductCatalogId(long productCatalogId) {
        this.productCatalogId = productCatalogId;
    }
    public long getProductGroupId() {
        return this.productGroupId;
    }		
    public void setProductGroupId(long productGroupId) {
        this.productGroupId = productGroupId;
    }
    public String getProductCode() {
        return this.productCode;
    }		
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductNameTh() {
        return this.productNameTh;
    }		
    public void setProductNameTh(String productNameTh) {
        this.productNameTh = productNameTh;
    }
    public String getProductNameEn() {
        return this.productNameEn;
    }		
    public void setProductNameEn(String productNameEn) {
        this.productNameEn = productNameEn;
    }
    public java.math.BigDecimal getProductPrice() {
        return this.productPrice;
    }		
    public void setProductPrice(java.math.BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
    public java.math.BigDecimal getProductDiscount() {
        return this.productDiscount;
    }		
    public void setProductDiscount(java.math.BigDecimal productDiscount) {
        this.productDiscount = productDiscount;
    }
    public java.math.BigDecimal getProductTotalPrice() {
        return this.productTotalPrice;
    }		
    public void setProductTotalPrice(java.math.BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }
    public String getProductBand() {
        return this.productBand;
    }		
    public void setProductBand(String productBand) {
        this.productBand = productBand;
    }
    public long getProductQuantity() {
        return this.productQuantity;
    }		
    public void setProductQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }
    public java.math.BigDecimal getProductWeight() {
        return this.productWeight;
    }		
    public void setProductWeight(java.math.BigDecimal productWeight) {
        this.productWeight = productWeight;
    }
    public String getProductPreintro() {
        return this.productPreintro;
    }		
    public void setProductPreintro(String productPreintro) {
        this.productPreintro = productPreintro;
    }
    public String getProductIntro() {
        return this.productIntro;
    }		
    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro;
    }
    public String getProductDetail() {
        return this.productDetail;
    }		
    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }
    public String getProductSummarize() {
        return this.productSummarize;
    }		
    public void setProductSummarize(String productSummarize) {
        this.productSummarize = productSummarize;
    }
    public String getProductLink() {
        return this.productLink;
    }		
    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }
    public String getProductPictureMeduim() {
        return this.productPictureMeduim;
    }		
    public void setProductPictureMeduim(String productPictureMeduim) {
        this.productPictureMeduim = productPictureMeduim;
    }
    public String getProductPictureBig() {
        return this.productPictureBig;
    }		
    public void setProductPictureBig(String productPictureBig) {
        this.productPictureBig = productPictureBig;
    }
    public long getProductStatus() {
        return this.productStatus;
    }		
    public void setProductStatus(long productStatus) {
        this.productStatus = productStatus;
    }
    public long getProductStock() {
        return this.productStock;
    }		
    public void setProductStock(long productStock) {
        this.productStock = productStock;
    }
    public String getProductItemGroupId() {
        return this.productItemGroupId;
    }		
    public void setProductItemGroupId(String productItemGroupId) {
        this.productItemGroupId = productItemGroupId;
    }
    public String getVendor() {
        return this.vendor;
    }		
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getProductItemTypeId() {
        return this.productItemTypeId;
    }		
    public void setProductItemTypeId(String productItemTypeId) {
        this.productItemTypeId = productItemTypeId;
    }
    public String getProductSubcategoryId() {
        return this.productSubcategoryId;
    }		
    public void setProductSubcategoryId(String productSubcategoryId) {
        this.productSubcategoryId = productSubcategoryId;
    }
    public String getSearchName() {
        return this.searchName;
    }		
    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
    public String getProductTechnologyId() {
        return this.productTechnologyId;
    }		
    public void setProductTechnologyId(String productTechnologyId) {
        this.productTechnologyId = productTechnologyId;
    }
    public String getProductDesign() {
        return this.productDesign;
    }		
    public void setProductDesign(String productDesign) {
        this.productDesign = productDesign;
    }
    public String getSupCatG() {
        return this.supCatG;
    }		
    public void setSupCatG(String supCatG) {
        this.supCatG = supCatG;
    }
    public java.math.BigDecimal getProductWidth() {
        return this.productWidth;
    }		
    public void setProductWidth(java.math.BigDecimal productWidth) {
        this.productWidth = productWidth;
    }
    public java.math.BigDecimal getProductLength() {
        return this.productLength;
    }		
    public void setProductLength(java.math.BigDecimal productLength) {
        this.productLength = productLength;
    }
    public String getSupGroup() {
        return this.supGroup;
    }		
    public void setSupGroup(String supGroup) {
        this.supGroup = supGroup;
    }
    public String getProductBuyerGroupId() {
        return this.productBuyerGroupId;
    }		
    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }
    public String getProductCategoryId() {
        return this.productCategoryId;
    }		
    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
    public String getProductModelId() {
        return this.productModelId;
    }		
    public void setProductModelId(String productModelId) {
        this.productModelId = productModelId;
    }
    public String getProductYearId() {
        return this.productYearId;
    }		
    public void setProductYearId(String productYearId) {
        this.productYearId = productYearId;
    }
    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }
    public java.math.BigDecimal getSortBy() {
        return this.sortBy;
    }		
    public void setSortBy(java.math.BigDecimal sortBy) {
        this.sortBy = sortBy;
    }
    public String getIsActive() {
        return this.isActive;
    }		
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    public String getCompany() {
        return this.company;
    }		
    public void setCompany(String company) {
        this.company = company;
    }
    public String getSoCategory() {
        return this.soCategory;
    }		
    public void setSoCategory(String soCategory) {
        this.soCategory = soCategory;
    }
    public String getProductPictureSmallHorizontal() {
        return this.productPictureSmallHorizontal;
    }		
    public void setProductPictureSmallHorizontal(String productPictureSmallHorizontal) {
        this.productPictureSmallHorizontal = productPictureSmallHorizontal;
    }
    public String getProductPictureSmallVertical() {
        return this.productPictureSmallVertical;
    }		
    public void setProductPictureSmallVertical(String productPictureSmallVertical) {
        this.productPictureSmallVertical = productPictureSmallVertical;
    }
    public long getImportStatus() {
        return this.importStatus;
    }		
    public void setImportStatus(long importStatus) {
        this.importStatus = importStatus;
    }
    public String getDtsSystem() {
        return this.dtsSystem;
    }		
    public void setDtsSystem(String dtsSystem) {
        this.dtsSystem = dtsSystem;
    }
    public java.sql.Timestamp getDtsUpdate() {
        return this.dtsUpdate;
    }		
    public void setDtsUpdate(java.sql.Timestamp dtsUpdate) {
        this.dtsUpdate = dtsUpdate;
    }



    public String toString() {
        return "";//super.toString() + "productId=[" + productId + "]\n" + "productTypeId=[" + productTypeId + "]\n" + "productCatalogId=[" + productCatalogId + "]\n" + "productGroupId=[" + productGroupId + "]\n" + "productCode=[" + productCode + "]\n" + "productNameTh=[" + productNameTh + "]\n" + "productNameEn=[" + productNameEn + "]\n" + "productPrice=[" + productPrice + "]\n" + "productDiscount=[" + productDiscount + "]\n" + "productTotalPrice=[" + productTotalPrice + "]\n" + "productBand=[" + productBand + "]\n" + "productQuantity=[" + productQuantity + "]\n" + "productWeight=[" + productWeight + "]\n" + "productPreintro=[" + productPreintro + "]\n" + "productIntro=[" + productIntro + "]\n" + "productDetail=[" + productDetail + "]\n" + "productSummarize=[" + productSummarize + "]\n" + "productLink=[" + productLink + "]\n" + "productPictureMeduim=[" + productPictureMeduim + "]\n" + "productPictureBig=[" + productPictureBig + "]\n" + "productStatus=[" + productStatus + "]\n" + "productStock=[" + productStock + "]\n" + "productItemGroupId=[" + productItemGroupId + "]\n" + "vendor=[" + vendor + "]\n" + "productItemTypeId=[" + productItemTypeId + "]\n" + "productSubcategoryId=[" + productSubcategoryId + "]\n" + "searchName=[" + searchName + "]\n" + "productTechnologyId=[" + productTechnologyId + "]\n" + "productDesign=[" + productDesign + "]\n" + "supCatG=[" + supCatG + "]\n" + "productWidth=[" + productWidth + "]\n" + "productLength=[" + productLength + "]\n" + "supGroup=[" + supGroup + "]\n" + "productBuyerGroupId=[" + productBuyerGroupId + "]\n" + "productCategoryId=[" + productCategoryId + "]\n" + "productModelId=[" + productModelId + "]\n" + "productYearId=[" + productYearId + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "sortBy=[" + sortBy + "]\n" + "isActive=[" + isActive + "]\n" + "company=[" + company + "]\n" + "soCategory=[" + soCategory + "]\n" + "productPictureSmallHorizontal=[" + productPictureSmallHorizontal + "]\n" + "productPictureSmallVertical=[" + productPictureSmallVertical + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpProduct)) {
                return false;
        }
        TmpProduct that = (TmpProduct) obj;
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (that.getProductTypeId() != this.getProductTypeId()) {
                return false;
        }
        if (that.getProductCatalogId() != this.getProductCatalogId()) {
                return false;
        }
        if (that.getProductGroupId() != this.getProductGroupId()) {
                return false;
        }
        if (!(that.getProductCode() == null ? this.getProductCode() == null
                        : that.getProductCode().equals(this.getProductCode()))) {
                return false;
        }
        if (!(that.getProductNameTh() == null ? this.getProductNameTh() == null
                        : that.getProductNameTh().equals(this.getProductNameTh()))) {
                return false;
        }
        if (!(that.getProductNameEn() == null ? this.getProductNameEn() == null
                        : that.getProductNameEn().equals(this.getProductNameEn()))) {
                return false;
        }
        if (!(that.getProductPrice() == null ? this.getProductPrice() == null
                        : 0 == that.getProductPrice().compareTo(this.getProductPrice()))) {
                return false;
        }
        if (!(that.getProductDiscount() == null ? this.getProductDiscount() == null
                        : 0 == that.getProductDiscount().compareTo(this.getProductDiscount()))) {
                return false;
        }
        if (!(that.getProductTotalPrice() == null ? this.getProductTotalPrice() == null
                        : 0 == that.getProductTotalPrice().compareTo(this.getProductTotalPrice()))) {
                return false;
        }
        if (!(that.getProductBand() == null ? this.getProductBand() == null
                        : that.getProductBand().equals(this.getProductBand()))) {
                return false;
        }
        if (that.getProductQuantity() != this.getProductQuantity()) {
                return false;
        }
        if (!(that.getProductWeight() == null ? this.getProductWeight() == null
                        : 0 == that.getProductWeight().compareTo(this.getProductWeight()))) {
                return false;
        }
        if (!(that.getProductPreintro() == null ? this.getProductPreintro() == null
                        : that.getProductPreintro().equals(this.getProductPreintro()))) {
                return false;
        }
        if (!(that.getProductIntro() == null ? this.getProductIntro() == null
                        : that.getProductIntro().equals(this.getProductIntro()))) {
                return false;
        }
        if (!(that.getProductDetail() == null ? this.getProductDetail() == null
                        : that.getProductDetail().equals(this.getProductDetail()))) {
                return false;
        }
        if (!(that.getProductSummarize() == null ? this.getProductSummarize() == null
                        : that.getProductSummarize().equals(this.getProductSummarize()))) {
                return false;
        }
        if (!(that.getProductLink() == null ? this.getProductLink() == null
                        : that.getProductLink().equals(this.getProductLink()))) {
                return false;
        }
        if (!(that.getProductPictureMeduim() == null ? this.getProductPictureMeduim() == null
                        : that.getProductPictureMeduim().equals(this.getProductPictureMeduim()))) {
                return false;
        }
        if (!(that.getProductPictureBig() == null ? this.getProductPictureBig() == null
                        : that.getProductPictureBig().equals(this.getProductPictureBig()))) {
                return false;
        }
        if (that.getProductStatus() != this.getProductStatus()) {
                return false;
        }
        if (that.getProductStock() != this.getProductStock()) {
                return false;
        }
        if (!(that.getProductItemGroupId() == null ? this.getProductItemGroupId() == null
                        : that.getProductItemGroupId().equals(this.getProductItemGroupId()))) {
                return false;
        }
        if (!(that.getVendor() == null ? this.getVendor() == null
                        : that.getVendor().equals(this.getVendor()))) {
                return false;
        }
        if (!(that.getProductItemTypeId() == null ? this.getProductItemTypeId() == null
                        : that.getProductItemTypeId().equals(this.getProductItemTypeId()))) {
                return false;
        }
        if (!(that.getProductSubcategoryId() == null ? this.getProductSubcategoryId() == null
                        : that.getProductSubcategoryId().equals(this.getProductSubcategoryId()))) {
                return false;
        }
        if (!(that.getSearchName() == null ? this.getSearchName() == null
                        : that.getSearchName().equals(this.getSearchName()))) {
                return false;
        }
        if (!(that.getProductTechnologyId() == null ? this.getProductTechnologyId() == null
                        : that.getProductTechnologyId().equals(this.getProductTechnologyId()))) {
                return false;
        }
        if (!(that.getProductDesign() == null ? this.getProductDesign() == null
                        : that.getProductDesign().equals(this.getProductDesign()))) {
                return false;
        }
        if (!(that.getSupCatG() == null ? this.getSupCatG() == null
                        : that.getSupCatG().equals(this.getSupCatG()))) {
                return false;
        }
        if (!(that.getProductWidth() == null ? this.getProductWidth() == null
                        : 0 == that.getProductWidth().compareTo(this.getProductWidth()))) {
                return false;
        }
        if (!(that.getProductLength() == null ? this.getProductLength() == null
                        : 0 == that.getProductLength().compareTo(this.getProductLength()))) {
                return false;
        }
        if (!(that.getSupGroup() == null ? this.getSupGroup() == null
                        : that.getSupGroup().equals(this.getSupGroup()))) {
                return false;
        }
        if (!(that.getProductBuyerGroupId() == null ? this.getProductBuyerGroupId() == null
                        : that.getProductBuyerGroupId().equals(this.getProductBuyerGroupId()))) {
                return false;
        }
        if (!(that.getProductCategoryId() == null ? this.getProductCategoryId() == null
                        : that.getProductCategoryId().equals(this.getProductCategoryId()))) {
                return false;
        }
        if (!(that.getProductModelId() == null ? this.getProductModelId() == null
                        : that.getProductModelId().equals(this.getProductModelId()))) {
                return false;
        }
        if (!(that.getProductYearId() == null ? this.getProductYearId() == null
                        : that.getProductYearId().equals(this.getProductYearId()))) {
                return false;
        }
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
                return false;
        }
        if (!(that.getSortBy() == null ? this.getSortBy() == null
                        : 0 == that.getSortBy().compareTo(this.getSortBy()))) {
                return false;
        }
        if (!(that.getIsActive() == null ? this.getIsActive() == null
                        : that.getIsActive().equals(this.getIsActive()))) {
                return false;
        }
        if (!(that.getCompany() == null ? this.getCompany() == null
                        : that.getCompany().equals(this.getCompany()))) {
                return false;
        }
        if (!(that.getSoCategory() == null ? this.getSoCategory() == null
                        : that.getSoCategory().equals(this.getSoCategory()))) {
                return false;
        }
        if (!(that.getProductPictureSmallHorizontal() == null ? this.getProductPictureSmallHorizontal() == null
                        : that.getProductPictureSmallHorizontal().equals(this.getProductPictureSmallHorizontal()))) {
                return false;
        }
        if (!(that.getProductPictureSmallVertical() == null ? this.getProductPictureSmallVertical() == null
                        : that.getProductPictureSmallVertical().equals(this.getProductPictureSmallVertical()))) {
                return false;
        }
        if (that.getImportStatus() != this.getImportStatus()) {
                return false;
        }
        if (!(that.getDtsSystem() == null ? this.getDtsSystem() == null
                        : that.getDtsSystem().equals(this.getDtsSystem()))) {
                return false;
        }
        if (!(that.getDtsUpdate() == null ? this.getDtsUpdate() == null
                        : that.getDtsUpdate().equals(this.getDtsUpdate()))) {
                return false;
        }
    return true;
    }

}
