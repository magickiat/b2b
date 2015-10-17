package com.starboard.b2b.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.ProductType;
import com.starboard.b2b.util.StringUtil;

public class ProductSearchResult {

	private Product product;
	private ProductType productType;

	private ProductPriceDTO price;
	private java.math.BigDecimal amount;
	private double msrePrice;
	private Integer seq;

	public ProductSearchResult() {
	}

	public ProductSearchResult(long productId, Long productTypeId, Long productCatalogId, Long productGroupId,
			String productCode, String productNameTh, String productNameEn, BigDecimal productPrice,
			BigDecimal productDiscount, BigDecimal productTotalPrice, String productBand, Long productQuantity,
			BigDecimal productWeight, String productPreintro, Integer productIntro, String productDetail,
			String productSummarize, String productLink, String productPictureMedium, String productPictureBig,
			Long productStatus, Long productStock, String productItemGroupId, String vendor, String productItemTypeId,
			String productSubcategoryId, String searchName, String productTechnologyId, String productDesign,
			String supCatG, BigDecimal productWidth, String productLength, String supGroup, String productBuyerGroupId,
			String productCategoryId, String productModelId, String productYearId, String productUnitId,
			BigDecimal sortBy, String isActive, String company, String soCategory, String productPictureSmallHorizontal,
			String productPictureSmallVertical, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate,
			String productTypeName) {

		product = new Product();
		productType = new ProductType();

		product.setProductId(productId);
		product.setProductTypeId(productTypeId);
		product.setProductCatalogId(productCatalogId);
		product.setProductGroupId(productGroupId);
		product.setProductCode(productCode);
		product.setProductNameTh(productNameTh);
		product.setProductNameEn(productNameEn);
		product.setProductPrice(productPrice);
		product.setProductDiscount(productDiscount);
		product.setProductTotalPrice(productTotalPrice);
		product.setProductBand(productBand);
		product.setProductQuantity(productQuantity);
		product.setProductWeight(productWeight);
		product.setProductPreintro(productPreintro);
		product.setProductIntro(productIntro);
		product.setProductDetail(productDetail);
		product.setProductSummarize(productSummarize);
		product.setProductLink(productLink);
		product.setProductPictureMedium(productPictureMedium);
		product.setProductPictureBig(productPictureBig);
		product.setProductStatus(productStatus);
		product.setProductStock(productStock);
		product.setProductItemGroupId(productItemGroupId);
		product.setVendor(vendor);
		product.setProductItemTypeId(productItemTypeId);
		product.setProductSubcategoryId(productSubcategoryId);
		product.setSearchName(searchName);
		product.setProductTechnologyId(productTechnologyId);
		product.setProductDesign(productDesign);
		product.setSupCatG(supCatG);
		product.setProductWidth(productWidth);
		product.setProductLength(productLength);
		product.setSupGroup(supGroup);
		product.setProductBuyerGroupId(productBuyerGroupId);
		product.setProductCategoryId(productCategoryId);
		product.setProductModelId(productModelId);
		product.setProductYearId(productYearId);
		product.setProductUnitId(productUnitId);
		product.setSortBy(sortBy);
		product.setIsActive(isActive);
		product.setCompany(company);
		product.setSoCategory(soCategory);
		product.setProductPictureSmallHorizontal(productPictureSmallHorizontal);
		product.setProductPictureSmallVertical(productPictureSmallVertical);
		product.setUserCreate(userCreate);
		product.setUserUpdate(userUpdate);
		product.setTimeCreate(timeCreate);
		product.setTimeUpdate(timeUpdate);

		productType.setProductTypeName(productTypeName);
	}

	public ProductPriceDTO getPrice() {
		return price;
	}

	public void setPrice(ProductPriceDTO price) {
		this.price = price;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public double getMsrePrice() {
		return msrePrice;
	}

	public void setMsrePrice(double msrePrice) {
		this.msrePrice = msrePrice;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getKeyName() {
		if (product == null) {
			return "";
		}

		return StringUtil.removeSpecialChar(product.getProductTechnologyId());
	}

}
