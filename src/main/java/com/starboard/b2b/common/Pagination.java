package com.starboard.b2b.common;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Pagination {
	private int current;
	private int size;
	private int total;
	private List<?> result;

	public Pagination() {
	}

	public Pagination(int current, int size, int total) {
		this.current = current;
		this.size = size;
		this.total = total;
	}

	public int getFirstResult() {
		int begin = getCurrent() < 1 ? 1 : getCurrent();
		return (begin - 1) * getSize();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

}
