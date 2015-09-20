
package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_stock_snapshot")
public class ProductStockSnapshot extends BaseModel {
	@Id
	@Column(name = "product_stock_snapshot_id")
	private long productStockSnapshotId;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "cust_code")
	private String custCode;
	@Column(name = "amount")
	private java.math.BigDecimal amount;
	@Column(name = "as_of")
	private java.util.Date asOf;
	@Column(name = "ontransit")
	private java.math.BigDecimal onTransit;
	@Column(name = "onorder")
	private java.math.BigDecimal onOrder;

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

	public java.math.BigDecimal getOnTransit() {
		return onTransit;
	}

	public void setOnTransit(java.math.BigDecimal onTransit) {
		this.onTransit = onTransit;
	}

	public java.math.BigDecimal getOnOrder() {
		return onOrder;
	}

	public void setOnOrder(java.math.BigDecimal onOrder) {
		this.onOrder = onOrder;
	}

}
