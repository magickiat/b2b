package com.starboard.b2b.dto;

public class PaymentTermDTO {
	private String paymentTermId;
	private String paymentTermName;
	private String description;

	public PaymentTermDTO() {
	}

	public PaymentTermDTO(String paymentTermId, String paymentTermName, String description) {
		this.paymentTermId = paymentTermId;
		this.paymentTermName = paymentTermName;
		this.description = description;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentTermName() {
		return paymentTermName;
	}

	public void setPaymentTermName(String paymentTermName) {
		this.paymentTermName = paymentTermName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
