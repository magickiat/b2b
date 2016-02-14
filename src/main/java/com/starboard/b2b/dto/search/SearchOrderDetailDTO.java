package com.starboard.b2b.dto.search;

import java.math.BigDecimal;

public class SearchOrderDetailDTO {

    private long orderDetailId;
    private long productId;
    private String productCode;
    private String productName;
    private long amount;
    private long shiped;
    private long pending;
    private String productUnit;
    private String productCurrency;
    private BigDecimal unitPrice;
    private String productBuyerGroupId;

    public SearchOrderDetailDTO() {
    }

    public SearchOrderDetailDTO(long orderDetailId, long productId, String productCode, String productName, long amount, long shiped, long pending, String productUnit, String productCurrency, BigDecimal unitPrice, String productBuyerGroupId) {
        this.orderDetailId = orderDetailId;
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.amount = amount;
        this.shiped = shiped;
        this.pending = pending;
        this.productUnit = productUnit;
        this.productCurrency = productCurrency;
        this.unitPrice = unitPrice;
        this.productBuyerGroupId = productBuyerGroupId;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public String getProductCurrency() {
        return productCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductBuyerGroupId() {
        return productBuyerGroupId;
    }

    public void setProductBuyerGroupId(String productBuyerGroupId) {
        this.productBuyerGroupId = productBuyerGroupId;
    }
}
