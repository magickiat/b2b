package com.starboard.b2b.model;
// Generated Oct 12, 2015 10:55:07 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductModel generated by hbm2java
 */
@Entity
@Table(name = "product_model")
public class ProductModel implements java.io.Serializable {

	private String productModelId;
	private String productModelName;
	private String description;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;
	private String image;
	private String headerText1;
	private String headerText2;

	public ProductModel() {
	}

	public ProductModel(String productModelId, String image, String headerText1, String headerText2) {
		this.productModelId = productModelId;
		this.image = image;
		this.headerText1 = headerText1;
		this.headerText2 = headerText2;
	}

	public ProductModel(String productModelId, String productModelName, String description, String userCreate,
			String userUpdate, Date timeCreate, Date timeUpdate, String image, String headerText1, String headerText2) {
		this.productModelId = productModelId;
		this.productModelName = productModelName;
		this.description = description;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
		this.image = image;
		this.headerText1 = headerText1;
		this.headerText2 = headerText2;
	}

	@Id

	@Column(name = "product_model_id", unique = true, nullable = false, length = 16)
	public String getProductModelId() {
		return this.productModelId;
	}

	public void setProductModelId(String productModelId) {
		this.productModelId = productModelId;
	}

	@Column(name = "product_model_name", length = 100)
	public String getProductModelName() {
		return this.productModelName;
	}

	public void setProductModelName(String productModelName) {
		this.productModelName = productModelName;
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

	@Column(name = "image", nullable = false)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "header_text1", nullable = false, length = 100)
	public String getHeaderText1() {
		return this.headerText1;
	}

	public void setHeaderText1(String headerText1) {
		this.headerText1 = headerText1;
	}

	@Column(name = "header_text2", nullable = false, length = 100)
	public String getHeaderText2() {
		return this.headerText2;
	}

	public void setHeaderText2(String headerText2) {
		this.headerText2 = headerText2;
	}

}
