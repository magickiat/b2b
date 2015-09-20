
package com.starboard.b2b.model;

public class ProductStock extends BaseModel {

	private long productStockId;
	private String productCode;
	private String custCode;
	private java.math.BigDecimal amount;
	private java.util.Date asOf;

	public long getProductStockId() {
		return productStockId;
	}

	public void setProductStockId(long productStockId) {
		this.productStockId = productStockId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public java.util.Date getAsOf() {
		return asOf;
	}

	public void setAsOf(java.util.Date asOf) {
		this.asOf = asOf;
	}

}
