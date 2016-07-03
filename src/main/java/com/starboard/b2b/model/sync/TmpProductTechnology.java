package com.starboard.b2b.model.sync;
// Generated Oct 25, 2015 1:54:35 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TmpProductTechnology generated by hbm2java
 */
@Entity
@Table(name = "tmp_product_technology")
public class TmpProductTechnology implements java.io.Serializable {

	private String productTechnologyId;
	private String productTechnologyName;
	private String description;
	private String dtsSystem;
	private Date dtsUpdate;

	public TmpProductTechnology() {
	}

	public TmpProductTechnology(String productTechnologyId) {
		this.productTechnologyId = productTechnologyId;
	}

	public TmpProductTechnology(String productTechnologyId, String productTechnologyName, String description,
			String dtsSystem, Date dtsUpdate) {
		this.productTechnologyId = productTechnologyId;
		this.productTechnologyName = productTechnologyName;
		this.description = description;
		this.dtsSystem = dtsSystem;
		this.dtsUpdate = dtsUpdate;
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

	@Column(name = "dts_system", length = 32)
	public String getDtsSystem() {
		return this.dtsSystem;
	}

	public void setDtsSystem(String dtsSystem) {
		this.dtsSystem = dtsSystem;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dts_update", length = 19)
	public Date getDtsUpdate() {
		return this.dtsUpdate;
	}

	public void setDtsUpdate(Date dtsUpdate) {
		this.dtsUpdate = dtsUpdate;
	}

}
