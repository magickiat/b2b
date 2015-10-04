package com.starboard.b2b.model;
// Generated Sep 26, 2015 11:05:02 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductTechnology generated by hbm2java
 */
@Entity
@Table(name = "product_technology")
public class ProductTechnology implements java.io.Serializable {

	private String productTechnologyId;
	private String productTechnologyName;
	private String description;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public ProductTechnology() {
	}

	public ProductTechnology(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	public ProductTechnology(String productTechnologyId, String productTechnologyName, String description,
			String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.productTechnologyId = productTechnologyId;
		this.productTechnologyName = productTechnologyName;
		this.description = description;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Id

	@Column(name = "product_technology_id", unique = true, nullable = false, length = 16)
	public String getProductTechnologyId() {
		return this.productTechnologyId;
	}

	public void setProductTechnologyId(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	@Column(name = "product_technology_name", length = 100)
	public String getProductTechnologyName() {
		return this.productTechnologyName;
	}

	public void setProductTechnologyName(String productTechnologyName) {
		this.productTechnologyName = productTechnologyName;
	}

	@Column(name = "description", length = 1024)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "user_create", length = 32)
	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	@Column(name = "user_update", length = 32)
	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_create", length = 19)
	public Date getTimeCreate() {
		return this.timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_update", length = 19)
	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

}
