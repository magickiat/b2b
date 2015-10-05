package com.starboard.b2b.dto.search;

import java.util.List;

public class SearchResult<T> {
	private long total;
	private List<T> result;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
