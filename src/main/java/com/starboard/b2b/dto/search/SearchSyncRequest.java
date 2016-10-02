package com.starboard.b2b.dto.search;

import java.util.Date;

public class SearchSyncRequest {
	private int page;
	private long syncId;
	private Date syncDate;
	private String status;
	private String remark;

	public long getSyncId() {
		return syncId;
	}

	public void setSyncId(long syncId) {
		this.syncId = syncId;
	}

	public Date getSyncDate() {
		return syncDate;
	}

	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
