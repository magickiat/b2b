package com.starboard.b2b.common;

public class Page {
	private int start;
	private int size;

	public Page() {
	}

	public Page(int start, int size) {
		this.start = start;
		this.size = size;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
