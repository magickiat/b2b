package com.starboard.b2b.model.search;

import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.Cust;

public class SearchUserResponse {
	private Cust cust;
	private Addr address;

	public SearchUserResponse() {
	}

	public SearchUserResponse(Cust cust, Addr address) {
		super();
		this.cust = cust;
		this.address = address;
	}

	public Cust getCust() {
		return cust;
	}

	public void setCust(Cust cust) {
		this.cust = cust;
	}

	public Addr getAddress() {
		return address;
	}

	public void setAddress(Addr address) {
		this.address = address;
	}

}
