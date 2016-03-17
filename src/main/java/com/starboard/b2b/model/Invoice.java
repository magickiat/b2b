package com.starboard.b2b.model;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Invoice generated by hbm2java
 */
@Entity
@Table(name = "invoice")
public class Invoice implements java.io.Serializable {

	private long invoiceId;
	private long soId;
	private String invoiceNo;
	private Date invoiceDate;
	private Date invoiceEtd;
	private Date invoiceEta;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public Invoice() {
	}

	public Invoice(long invoiceId, long soId, String invoiceNo) {
		this.invoiceId = invoiceId;
		this.soId = soId;
		this.invoiceNo = invoiceNo;
	}

	public Invoice(long invoiceId, long soId, String invoiceNo, Date invoiceDate, Date invoiceEtd, Date invoiceEta,
			String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.invoiceId = invoiceId;
		this.soId = soId;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.invoiceEtd = invoiceEtd;
		this.invoiceEta = invoiceEta;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Id

	@Column(name = "invoice_id", unique = true, nullable = false)
	public long getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "so_id", nullable = false)
	public long getSoId() {
		return this.soId;
	}

	public void setSoId(long soId) {
		this.soId = soId;
	}

	@Column(name = "invoice_no", nullable = false, length = 32)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invoice_date", length = 19)
	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invoice_etd", length = 19)
	public Date getInvoiceEtd() {
		return this.invoiceEtd;
	}

	public void setInvoiceEtd(Date invoiceEtd) {
		this.invoiceEtd = invoiceEtd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invoice_eta", length = 19)
	public Date getInvoiceEta() {
		return this.invoiceEta;
	}

	public void setInvoiceEta(Date invoiceEta) {
		this.invoiceEta = invoiceEta;
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

}
