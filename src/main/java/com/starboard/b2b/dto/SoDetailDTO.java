package com.starboard.b2b.dto;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * SoDetailDTO DTO
 */
public class SoDetailDTO implements java.io.Serializable {

	private long soProductId;
	private Long orderProductId;
	private Long soId;
	private Long productId;
	private Long amount;
	private String productBuyerGroupId;
	private BigDecimal price;
	private String productCurrency;
	private String productUnitId;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public SoDetailDTO() {
	}

	public SoDetailDTO(long soProductId) {
		this.soProductId = soProductId;
	}

	public SoDetailDTO(long soProductId, Long orderProductId, Long soId, Long productId, Long amount,
					   String productBuyerGroupId, BigDecimal price, String productCurrency, String productUnitId,
					   String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.soProductId = soProductId;
		this.orderProductId = orderProductId;
		this.soId = soId;
		this.productId = productId;
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

	public long getSoProductId() {
		return this.soProductId;
	}

	public void setSoProductId(long soProductId) {
		this.soProductId = soProductId;
	}

	public Long getOrderProductId() {
		return this.orderProductId;
	}

	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Long getSoId() {
		return this.soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getProductBuyerGroupId() {
		return this.productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductCurrency() {
		return this.productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public String getProductUnitId() {
		return this.productUnitId;
	}

	public void setProductUnitId(String productUnitId) {
		this.productUnitId = productUnitId;
	}

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	public Date getTimeCreate() {
		return this.timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

}
