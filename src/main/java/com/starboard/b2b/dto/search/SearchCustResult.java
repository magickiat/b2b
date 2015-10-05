package com.starboard.b2b.dto.search;

import java.util.List;

import com.starboard.b2b.model.Cust;

public class SearchCustResult {
	private long total;
	private List<Cust> result;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<Cust> getResult() {
		return result;
	}

	public void setResult(List<Cust> result) {
		this.result = result;
	}

}
