
package com.starboard.b2b.model;

public class ProductStockSnapshot extends BaseModel {

	private long productStockSnapshotId;
	private String productCode;
	private String custCode;
	private java.math.BigDecimal amount;
	private java.util.Date asOf;
	private java.math.BigDecimal ontransit;
	private java.math.BigDecimal onorder;

	public long getProductStockSnapshotId() {
		return productStockSnapshotId;
	}

	public void setProductStockSnapshotId(long productStockSnapshotId) {
		this.productStockSnapshotId = productStockSnapshotId;
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

	public java.math.BigDecimal getOntransit() {
		return ontransit;
	}

	public void setOntransit(java.math.BigDecimal ontransit) {
		this.ontransit = ontransit;
	}

	public java.math.BigDecimal getOnorder() {
		return onorder;
	}

	public void setOnorder(java.math.BigDecimal onorder) {
		this.onorder = onorder;
	}

}
