package com.starboard.b2b.dto.search;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.starboard.b2b.dto.BaseDTO;

public class SearchOrderDetailDTO extends BaseDTO {
	private long orderDetailId;
	private String productCode;
	private String productName;
	private long amount;
	private long shiped;
	private long pending;
	private String productUnit;
	private BigDecimal unitPrice;
	private String productBuyerGroupId;
	private Long orderId;

	private Long productId;
	private Long status;
	private BigDecimal price;
	private String productUnitId;
	private String productCurrency;

	public SearchOrderDetailDTO() {
	}

	public SearchOrderDetailDTO(long orderDetailId, String productCode, String productName, long amount, long shiped, long pending,
			String productUnit, BigDecimal unitPrice, String productBuyerGroupId, Long orderId, Long productId, Long status, BigDecimal price,
			String productUnitId, String productCurrency, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.orderDetailId = orderDetailId;
		this.productCode = productCode;
		this.productName = productName;
		this.amount = amount;
		this.shiped = shiped;
		this.pending = pending;
		this.productUnit = productUnit;
		this.unitPrice = unitPrice;
		this.productBuyerGroupId = productBuyerGroupId;
		this.orderId = orderId;

		this.productId = productId;
		this.status = status;
		this.price = price;
		this.productUnitId = productUnitId;
		this.productCurrency = productCurrency;
		
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getShiped() {
		return shiped;
	}

	public void setShiped(long shiped) {
		this.shiped = shiped;
	}

	public long getPending() {
		return pending;
	}

	public void setPending(long pending) {
		this.pending = pending;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getProductBuyerGroupId() {
		return productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}
}
