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
 * TmpProductBuyerGroup generated by hbm2java
 */
@Entity
@Table(name = "tmp_product_buyer_group")
public class TmpProductBuyerGroup implements java.io.Serializable {

	private String productBuyerGroupId;
	private String productBuyerGroupName;
	private String description;
	private String dtsSystem;
	private Date dtsUpdate;

	public TmpProductBuyerGroup() {
	}

	public TmpProductBuyerGroup(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	public TmpProductBuyerGroup(String productBuyerGroupId, String productBuyerGroupName, String description,
			String dtsSystem, Date dtsUpdate) {
		this.productBuyerGroupId = productBuyerGroupId;
		this.productBuyerGroupName = productBuyerGroupName;
		this.description = description;
		this.dtsSystem = dtsSystem;
		this.dtsUpdate = dtsUpdate;
	}

	@Id

	@Column(name = "product_buyer_group_id", unique = true, nullable = false, length = 32)
	public String getProductBuyerGroupId() {
		return this.productBuyerGroupId;
	}

	public void setProductBuyerGroupId(String productBuyerGroupId) {
		this.productBuyerGroupId = productBuyerGroupId;
	}

	@Column(name = "product_buyer_group_name", length = 100)
	public String getProductBuyerGroupName() {
		return this.productBuyerGroupName;
	}

	public void setProductBuyerGroupName(String productBuyerGroupName) {
		this.productBuyerGroupName = productBuyerGroupName;
	}

	@Column(name = "description")
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
