package com.starboard.b2b.model.sync;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TmpPaymentTerm generated by hbm2java
 */
@Entity
@Table(name = "tmp_payment_term")
public class TmpPaymentTerm implements java.io.Serializable {

	private String paymentTermId;
	private String paymentTermName;
	private String description;
	private String dtsSystem;
	private Date dtsUpdate;

	public TmpPaymentTerm() {
	}

	public TmpPaymentTerm(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public TmpPaymentTerm(String paymentTermId, String paymentTermName, String description, String dtsSystem,
			Date dtsUpdate) {
		this.paymentTermId = paymentTermId;
		this.paymentTermName = paymentTermName;
		this.description = description;
		this.dtsSystem = dtsSystem;
		this.dtsUpdate = dtsUpdate;
	}

	@Id

	@Column(name = "payment_term_id", unique = true, nullable = false, length = 16)
	public String getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	@Column(name = "payment_term_name", length = 100)
	public String getPaymentTermName() {
		return this.paymentTermName;
	}

	public void setPaymentTermName(String paymentTermName) {
		this.paymentTermName = paymentTermName;
	}

	@Column(name = "description", length = 1024)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "dts_system", length = 32)
	public String getDtsSystem() {
		return this.dtsSystem;
	}

	public void setDtsSystem(String dtsSystem) {
		this.dtsSystem = dtsSystem;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dts_update", length = 19)
	public Date getDtsUpdate() {
		return this.dtsUpdate;
	}

	public void setDtsUpdate(Date dtsUpdate) {
		this.dtsUpdate = dtsUpdate;
	}

}
