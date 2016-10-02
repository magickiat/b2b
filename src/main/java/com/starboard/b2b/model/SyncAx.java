package com.starboard.b2b.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sync_ax")
public class SyncAx implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long syncId;
	private Date syncDate;
	private String status;
	private String remark;

	@Id
	@Column(name = "sync_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSyncId() {
		return syncId;
	}

	public void setSyncId(long syncId) {
		this.syncId = syncId;
	}

	@Column(name = "sync_date")
	public Date getSyncDate() {
		return syncDate;
	}

	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
