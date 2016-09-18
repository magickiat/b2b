package com.starboard.b2b.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tmp_so")
public class TmpSo {

	private long soId;
	private long orderId;
	private String orderCode;
	private String shippingId;
	private String paymentTermId;
	private String paymentMethodId;
	private Date expectShipmentDate;
	private String soNo;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public TmpSo() {
	}

	public TmpSo(long soId, long orderId, String soNo) {
		this.soId = soId;
		this.orderId = orderId;
		this.soNo = soNo;
	}

	public TmpSo(long soId, long orderId, String shippingId, String paymentTermId, String paymentMethodId, Date expectShipmentDate, String soNo,
			String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "so_id", unique = true, nullable = false)
	public long getSoId() {
		return this.soId;
	}

	public void setSoId(long soId) {
		this.soId = soId;
	}

	@Column(name = "order_id", nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "shipping_id", length = 16)
	public String getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "payment_term_id", length = 16)
	public String getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	@Column(name = "payment_method_id", length = 16)
	public String getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expect_shipment_date", length = 19)
	public Date getExpectShipmentDate() {
		return this.expectShipmentDate;
	}

	public void setExpectShipmentDate(Date expectShipmentDate) {
		this.expectShipmentDate = expectShipmentDate;
	}

	@Column(name = "so_no", nullable = false, length = 32)
	public String getSoNo() {
		return this.soNo;
	}

	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}

	@Column(name = "user_create", length = 32)
	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	@Column(name = "user_update", length = 32)
	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_create", length = 19)
	public Date getTimeCreate() {
		return this.timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_update", length = 19)
	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	@Column(name = "order_code", length = 100)
	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
}
