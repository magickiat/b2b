package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_id_running")
public class OrdersIdRunning {
	@Id
	@Column(length = 4)
	private int year;
	@Column(name = "running_no")
	private long runningNo;

	public OrdersIdRunning() {
	}

	public OrdersIdRunning(int year, long runningNo) {
		this.year = year;
		this.runningNo = runningNo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getRunningNo() {
		return runningNo;
	}

	public void setRunningNo(long runningNo) {
		this.runningNo = runningNo;
	}

}
