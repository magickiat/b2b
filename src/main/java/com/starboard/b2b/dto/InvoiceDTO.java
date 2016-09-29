package com.starboard.b2b.dto;

import com.starboard.b2b.model.Invoice;

import java.util.Date;

/**
 * SoDTO DTO
 */
public class InvoiceDTO implements java.io.Serializable {

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

	public InvoiceDTO() {
	}

	public InvoiceDTO(long invoiceId, long soId, String invoiceNo) {
		this.invoiceId = invoiceId;
		this.soId = soId;
		this.invoiceNo = invoiceNo;
	}

	public InvoiceDTO(long invoiceId, long soId, String invoiceNo, Date invoiceDate, Date invoiceEtd, Date invoiceEta,
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

	public InvoiceDTO(Invoice iv) {
		this.invoiceId = iv.getInvoiceId();
		this.soId = iv.getSoId();
		this.invoiceNo = iv.getInvoiceNo();
		this.invoiceDate = iv.getInvoiceDate();
		this.invoiceEtd = iv.getInvoiceEtd();
		this.invoiceEta = iv.getInvoiceEta();
		this.userCreate = iv.getUserCreate();
		this.userUpdate = iv.getUserUpdate();
		this.timeCreate = iv.getTimeCreate();
		this.timeUpdate = iv.getTimeUpdate();
	}

	public long getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getSoId() {
		return this.soId;
	}

	public void setSoId(long soId) {
		this.soId = soId;
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getInvoiceEtd() {
		return this.invoiceEtd;
	}

	public void setInvoiceEtd(Date invoiceEtd) {
		this.invoiceEtd = invoiceEtd;
	}

	public Date getInvoiceEta() {
		return this.invoiceEta;
	}

	public void setInvoiceEta(Date invoiceEta) {
		this.invoiceEta = invoiceEta;
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
