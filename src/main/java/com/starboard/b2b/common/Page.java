package com.starboard.b2b.common;

import java.util.List;

public class Page<T> {
	private int current;
	private long total;
	private int pageSize;
	private List<T> result;

	public Page() {
	}

	public Page(int current, long total, List<T> result) {
		this.current = current;
		this.total = total;
		this.result = result;
	}

	public int getBeginPage() {
		return Math.max(1, getCurrent() - 5);
	}

	public int getEndPage() {
		return Math.min(getBeginPage() + 10, getTotalPage());
	}

	public int getTotalPage() {
		if (pageSize == 0) {
			return 0;
		} else {
			return (int) Math.ceil(total / pageSize);
		}
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

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
