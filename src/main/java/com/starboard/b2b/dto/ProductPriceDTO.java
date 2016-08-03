
package com.starboard.b2b.dto;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ProductPriceDTO {

	private String productCode;
	private String productPriceGroupId;
	private String productCurrency;
	private java.math.BigDecimal amount;
	private String productUnitId;
	private BigDecimal msrePrice;
	private String soCategory;
	
	public ProductPriceDTO() {
	}

	public ProductPriceDTO(String productCode, String productPriceGroupId, String productCurrency, BigDecimal amount,
			String productUnitId, BigDecimal msrePrice) {
		this.productCode = productCode;
		this.productPriceGroupId = productPriceGroupId;
		this.productCurrency = productCurrency;
		this.amount = amount;
		this.productUnitId = productUnitId;
		this.msrePrice = msrePrice;
	}
	
	public ProductPriceDTO(String productCode, String productPriceGroupId, String productCurrency, BigDecimal amount,
			String productUnitId, BigDecimal msrePrice, String soCategory) {
		this.productCode = productCode;
		this.productPriceGroupId = productPriceGroupId;
		this.productCurrency = productCurrency;
		this.amount = amount;
		this.productUnitId = productUnitId;
		this.msrePrice = msrePrice;
		this.soCategory = soCategory;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductPriceGroupId() {
		return productPriceGroupId;
	}

	public void setProductPriceGroupId(String productPriceGroupId) {
		this.productPriceGroupId = productPriceGroupId;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public BigDecimal getMsrePrice() {
		return msrePrice;
	}

	public void setMsrePrice(BigDecimal msrePrice) {
		this.msrePrice = msrePrice;
	}
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getSoCategory() {
		return soCategory;
	}

	public void setSoCategory(String soCategory) {
		this.soCategory = soCategory;
	}

}
