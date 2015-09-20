package com.starboard.b2b.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "product_id")
	private long productId;

	@OneToOne(optional = false)
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	@OneToOne(optional = false)
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;

	@OneToOne(optional = false)
	@JoinColumn(name = "product_group_id")
	private ProductGroup productGroup;

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

	private String productPictureMedium;
	private String productPictureBig;
	private String productPictureSmallHorizontal;
	private String productPictureSmallVertical;

}
