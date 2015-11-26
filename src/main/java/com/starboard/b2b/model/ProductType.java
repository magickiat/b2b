package com.starboard.b2b.model;
// Generated Oct 12, 2015 10:55:07 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductType generated by hbm2java
 */
@Entity
@Table(name = "product_type")
@NamedQueries({
    @NamedQuery(
            name = "ProductType.findByCustomerAndBrand", 
            query = "SELECT p FROM ProductType p LEFT JOIN CustBrandGroup c ON p.productTypeId = c.id.brandGroupId LEFT JOIN ProductBrandGroup b ON c.id.brandGroupId = b.id.productTypeId WHERE c.id.custId = :cid AND b.id.brandGroupId = :bid"
    )
})
public class ProductType implements java.io.Serializable {

	private long productTypeId;
	private String productTypeName;
	private Long productTypeParentId;
	private String productTypeDescription;
	private String userCreate;
	private String userUpdate;
	private Date timeCreate;
	private Date timeUpdate;

	public ProductType() {
	}

	public ProductType(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public ProductType(long productTypeId, String productTypeName, Long productTypeParentId,
			String productTypeDescription, String userCreate, String userUpdate, Date timeCreate, Date timeUpdate) {
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
		this.productTypeParentId = productTypeParentId;
		this.productTypeDescription = productTypeDescription;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	@Id

	@Column(name = "product_type_id", unique = true, nullable = false)
	public long getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Column(name = "product_type_name", length = 100)
	public String getProductTypeName() {
		return this.productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	@Column(name = "product_type_parent_id")
	public Long getProductTypeParentId() {
		return this.productTypeParentId;
	}

	public void setProductTypeParentId(Long productTypeParentId) {
		this.productTypeParentId = productTypeParentId;
	}

	@Column(name = "product_type_description", length = 1024)
	public String getProductTypeDescription() {
		return this.productTypeDescription;
	}

	public void setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
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
