package com.starboard.b2b.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "brand")
public class Brand extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 255, nullable = false)
	private String name;

	@Column(length = 255)
	private String logo;
	
	@Column(name = "common_brand", nullable = false)
	private boolean commonBrand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public boolean isCommonBrand() {
		return commonBrand;
	}

	public void setCommonBrand(boolean commonBrand) {
		this.commonBrand = commonBrand;
	}
}
