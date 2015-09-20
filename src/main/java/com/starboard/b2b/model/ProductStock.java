
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_stock")
public class ProductStock extends BaseModel {
	@Id
	@Column(name = "product_stock_id")
	private long productStockId;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "cust_code")
	private String custCode;
	@Column(name = "amount")
	private java.math.BigDecimal amount;
	@Column(name = "as_of")
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
