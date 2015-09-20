
package com.starboard.b2b.model;

public class ProductPrice extends BaseModel {

	private String productCode;
	private String productPriceGroupId;
	private String productCurrency;
	private java.math.BigDecimal amount;
	private String productUnitId;
	private double msrePrice;

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

	public double getMsrePrice() {
		return msrePrice;
	}

	public void setMsrePrice(double msrePrice) {
		this.msrePrice = msrePrice;
	}

}
