
package com.starboard.b2b.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ProductBrandGroupDTO {

	private long brandGroupId;
	private long productTypeId;

	public long getBrandGroupId() {
		return brandGroupId;
	}

	public void setBrandGroupId(long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
