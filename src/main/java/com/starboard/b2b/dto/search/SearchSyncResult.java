package com.starboard.b2b.dto.search;

import java.util.List;

public class SearchSyncResult {
	private long total;
	private List<SyncAxDto> result;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<SyncAxDto> getResult() {
		return result;
	}

	public void setResult(List<SyncAxDto> result) {
		this.result = result;
	}

}
