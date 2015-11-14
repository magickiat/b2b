package com.starboard.b2b.model;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * OrdAddressId generated by hbm2java
 */
@Embeddable
public class OrdAddressId implements java.io.Serializable {

	private long orderAddressId;
	private long orderId;

	public OrdAddressId() {
	}

	public OrdAddressId(long orderAddressId, long orderId) {
		this.orderAddressId = orderAddressId;
		this.orderId = orderId;
	}

	@Column(name = "order_address_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getOrderAddressId() {
		return this.orderAddressId;
	}

	public void setOrderAddressId(long orderAddressId) {
		this.orderAddressId = orderAddressId;
	}

	@Column(name = "order_id", nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrdAddressId))
			return false;
		OrdAddressId castOther = (OrdAddressId) other;

		return (this.getOrderAddressId() == castOther.getOrderAddressId())
				&& (this.getOrderId() == castOther.getOrderId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getOrderAddressId();
		result = 37 * result + (int) this.getOrderId();
		return result;
	}

}
