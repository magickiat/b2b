
package com.starboard.b2b.dto;

import java.math.BigDecimal;

public class ProductPriceDTO {

	private String productCode;
	private String productPriceGroupId;
	private String productCurrency;
	private java.math.BigDecimal amount;
	private String productUnitId;
	private float msrePrice;
	
	public ProductPriceDTO() {
	}

	public ProductPriceDTO(String productCode, String productPriceGroupId, String productCurrency, BigDecimal amount,
			String productUnitId, float msrePrice) {
		this.productCode = productCode;
		this.productPriceGroupId = productPriceGroupId;
		this.productCurrency = productCurrency;
		this.amount = amount;
		this.productUnitId = productUnitId;
		this.msrePrice = msrePrice;
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

	public float getMsrePrice() {
		return msrePrice;
	}

	public void setMsrePrice(float msrePrice) {
		this.msrePrice = msrePrice;
	}

}
