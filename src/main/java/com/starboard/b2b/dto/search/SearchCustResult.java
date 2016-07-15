package com.starboard.b2b.dto.search;

import java.util.List;

import com.starboard.b2b.model.search.SearchUserResponse;

public class SearchCustResult {
	private long total;
	private List<SearchUserResponse> result;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<SearchUserResponse> getResult() {
		return result;
	}

	public void setResult(List<SearchUserResponse> result) {
		this.result = result;
	}


}
