package com.starboard.b2b.web.form;

import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CreateContactUsForm {
	@NotEmpty(message = "Title is required")
	@Size(max = 100, message = "Title size must be between 1 and 100")
	private String title;
	
	@NotEmpty(message = "Name is required")
	@Size(max = 100, message = "Name size must be between 1 and 100")
	private String name;
	
	@Email(message = "Invalid email")
	private String email;
	
	private String detail;
	private String tel;

	public CreateContactUsForm() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
