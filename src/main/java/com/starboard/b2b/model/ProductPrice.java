
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_price")
public class ProductPrice extends BaseModel {
	@Id
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "product_price_group_id")
	private String productPriceGroupId;
	@Column(name = "product_currency")
	private String productCurrency;
	@Column(name = "amount")
	private java.math.BigDecimal amount;
	@Column(name = "product_unit_id")
	private String productUnitId;

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

}
