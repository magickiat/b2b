package com.starboard.b2b.model;
// Generated Oct 12, 2015 10:55:07 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductBrandGroup generated by hbm2java
 */
@Entity
@Table(name = "product_brand_group")
public class ProductBrandGroup implements java.io.Serializable {

	private ProductBrandGroupId id;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public ProductBrandGroup() {
	}

	public ProductBrandGroup(ProductBrandGroupId id) {
		this.id = id;
	}

	public ProductBrandGroup(ProductBrandGroupId id, String userCreate, String userUpdate, Date timeCreate,
			Date timeUpdate) {
		this.id = id;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "productTypeId", column = @Column(name = "product_type_id", nullable = false) ),
			@AttributeOverride(name = "brandGroupId", column = @Column(name = "brand_group_id", nullable = false) ) })
	public ProductBrandGroupId getId() {
		return this.id;
	}

	public void setId(ProductBrandGroupId id) {
		this.id = id;
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
