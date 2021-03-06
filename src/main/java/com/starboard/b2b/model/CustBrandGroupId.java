package com.starboard.b2b.model;
// Generated Sep 26, 2015 11:05:02 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CustBrandGroupId generated by hbm2java
 */
@Embeddable
public class CustBrandGroupId implements java.io.Serializable {

	private long custId;
	private long brandGroupId;

	public CustBrandGroupId() {
	}

	public CustBrandGroupId(long custId, long brandGroupId) {
		this.custId = custId;
		this.brandGroupId = brandGroupId;
	}

	@Column(name = "cust_id", nullable = false)
	public long getCustId() {
		return this.custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	@Column(name = "brand_group_id", nullable = false)
	public long getBrandGroupId() {
		return this.brandGroupId;
	}

	public void setBrandGroupId(long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CustBrandGroupId))
			return false;
		CustBrandGroupId castOther = (CustBrandGroupId) other;

		return (this.getCustId() == castOther.getCustId()) && (this.getBrandGroupId() == castOther.getBrandGroupId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getCustId();
		result = 37 * result + (int) this.getBrandGroupId();
		return result;
	}

}
