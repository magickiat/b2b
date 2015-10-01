package com.starboard.b2b.common;

import java.util.List;

public class Page<T> {
	private int current;
	private long total;
	private List<T> result;

	public Page() {
	}

	public Page(int current, long total, List<T> result) {
		this.current = current;
		this.total = total;
		this.result = result;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
