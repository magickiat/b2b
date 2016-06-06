package com.starboard.b2b.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_email")
public class ProductEmail extends BaseModel {
	private Long id;
	private Long brandGroupId;
	private String email;
	private String emailType;

	public ProductEmail() {
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email_type", nullable = false)
	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	@Column(name = "brand_group_id", nullable = false)
	public Long getBrandGroupId() {
		return brandGroupId;
	}

	public void setBrandGroupId(Long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

}
