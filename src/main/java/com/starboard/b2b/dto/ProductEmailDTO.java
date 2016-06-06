package com.starboard.b2b.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ProductEmailDTO {
	private Long id;
	private Long brandGroupId;
	private String email;
	private String emailType;

	public ProductEmailDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public Long getBrandGroupId() {
		return brandGroupId;
	}

	public void setBrandGroupId(Long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}
}
