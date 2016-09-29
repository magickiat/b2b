package com.starboard.b2b.dto;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * SoDetailDTO DTO
 */
public class InvoiceDetailDTO implements java.io.Serializable {

	private long invoiceProductId;
	private Long orderProductId;
	private Long invoiceId;
	private Long amount;
	private String productBuyerGroupId;
	private BigDecimal price;
	private String productCurrency;
	private String productUnitId;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public InvoiceDetailDTO() {
	}

	public InvoiceDetailDTO(long invoiceProductId) {
		this.invoiceProductId = invoiceProductId;
	}

	public InvoiceDetailDTO(long invoiceProductId, Long orderProductId, Long invoiceId,
							Long amount, String productBuyerGroupId, BigDecimal price, String productCurrency,
							String productUnitId, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.invoiceProductId = invoiceProductId;
		this.orderProductId = orderProductId;
		this.invoiceId = invoiceId;
		this.amount = amount;
		this.productBuyerGroupId = productBuyerGroupId;
		this.price = price;
		this.productCurrency = productCurrency;
		this.productUnitId = productUnitId;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	public long getInvoiceProductId() {
		return invoiceProductId;
	}

	public void setInvoiceProductId(long invoiceProductId) {
		this.invoiceProductId = invoiceProductId;
	}

	public Long getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getProductBuyerGroupId() {
		return productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public String getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

}
