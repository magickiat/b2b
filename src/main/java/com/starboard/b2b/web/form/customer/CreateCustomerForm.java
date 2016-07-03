package com.starboard.b2b.web.form.customer;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateCustomerForm {
	@NotEmpty(message = "Name is required.")
	private String name;
	@NotEmpty(message = "Code is required.")
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
