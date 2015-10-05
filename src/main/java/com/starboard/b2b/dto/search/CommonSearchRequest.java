package com.starboard.b2b.dto.search;

public class CommonSearchRequest<T> {
	private int page;
	private int size;
	private T condition;

	public CommonSearchRequest(Integer page, int size) {
		setPage(page);
		setPageSize(size);
	}

	public int getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if (page == null || page < 0) {
			page = 0;
		}
		this.page = page;
	}

	public int getPageSize() {
		return size;
	}

	public void setPageSize(int size) {
		if (size < 0) {
			size = 0;
		}
		this.size = size;
	}

	public int getFirstResult() {
		int begin = page < 1 ? 1 : page;
		return (begin - 1) * getPageSize();
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}

}
