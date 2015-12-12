package com.starboard.b2b.dto;

import com.starboard.b2b.model.So;

import java.util.Date;

/**
 * SoDTO DTO
 */
public class SoDTO implements java.io.Serializable {

	private long soId;
	private long orderId;
	private String shippingId;
	private String paymentTermId;
	private String paymentMethodId;
	private Date expectShipmentDate;
	private String soNo;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public SoDTO() {
	}

	public SoDTO(long soId, long orderId, String soNo) {
		this.soId = soId;
		this.orderId = orderId;
		this.soNo = soNo;
	}

	public SoDTO(long soId, long orderId, String shippingId, String paymentTermId, String paymentMethodId,
				 Date expectShipmentDate, String soNo, String userCreate, String userUpdate, Date timeCreate,
				 Date timeUpdate) {
		this.soId = soId;
		this.orderId = orderId;
		this.shippingId = shippingId;
		this.paymentTermId = paymentTermId;
		this.paymentMethodId = paymentMethodId;
		this.expectShipmentDate = expectShipmentDate;
		this.soNo = soNo;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	public SoDTO(So so) {
		this.soId = so.getSoId();
		this.orderId = so.getOrderId();
		this.shippingId = so.getShippingId();
		this.paymentTermId = so.getPaymentTermId();
		this.paymentMethodId = so.getPaymentMethodId();
		this.expectShipmentDate = so.getExpectShipmentDate();
		this.soNo = so.getSoNo();
		this.userCreate = so.getUserCreate();
		this.userUpdate = so.getUserUpdate();
		this.timeCreate = so.getTimeCreate();
		this.timeUpdate = so.getTimeUpdate();
	}

	public long getSoId() {
		return this.soId;
	}

	public void setSoId(long soId) {
		this.soId = soId;
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public Date getExpectShipmentDate() {
		return this.expectShipmentDate;
	}

	public void setExpectShipmentDate(Date expectShipmentDate) {
		this.expectShipmentDate = expectShipmentDate;
	}

	public String getSoNo() {
		return this.soNo;
	}

	public void setSoNo(String soNo) {
		this.soNo = soNo;
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
