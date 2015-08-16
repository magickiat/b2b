package com.starboard.b2b.common;

public class Page {
	private int current;
	private int size;

	public Page() {
	}

	public Page(int current, int size) {
		this.current = current;
		this.size = size;
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

	public int getFirstResult() {
		int begin = getCurrent() < 1 ? 1 : getCurrent();
		return (begin - 1) * getSize();
	}
}
