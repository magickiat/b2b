package com.starboard.b2b.dto.search;

import java.util.List;

import com.starboard.b2b.model.Content;

public class SearchContentResult {
	private long total;
	private List<Content> result;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<Content> getResult() {
		return result;
	}

	public void setResult(List<Content> result) {
		this.result = result;
	}

}
