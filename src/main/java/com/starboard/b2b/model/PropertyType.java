
package com.starboard.b2b.model;

public class PropertyType extends BaseModel {

	private long propertyTypeId;
	private String propertyForId;
	private String propertyTypeName;
	private long propertyTypeParentId;
	private String propertyTypeDescription;
	private String status;

	public long getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(long propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public String getPropertyForId() {
		return propertyForId;
	}

	public void setPropertyForId(String propertyForId) {
		this.propertyForId = propertyForId;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

	public long getPropertyTypeParentId() {
		return propertyTypeParentId;
	}

	public void setPropertyTypeParentId(long propertyTypeParentId) {
		this.propertyTypeParentId = propertyTypeParentId;
	}

	public String getPropertyTypeDescription() {
		return propertyTypeDescription;
	}

	public void setPropertyTypeDescription(String propertyTypeDescription) {
		this.propertyTypeDescription = propertyTypeDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
