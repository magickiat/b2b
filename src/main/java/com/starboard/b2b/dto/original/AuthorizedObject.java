
package com.starboard.b2b.dto.original;

public class AuthorizedObject {

	private String authorizedObjectId;
	private String name;
	private String description;
	private java.util.Date timeCreate;
	private java.util.Date timeUpdate;
	private long authorizedObjectGroupId;

	public String getAuthorizedObjectId() {
		return authorizedObjectId;
	}

	public void setAuthorizedObjectId(String authorizedObjectId) {
		this.authorizedObjectId = authorizedObjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.util.Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(java.util.Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public java.util.Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(java.util.Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	public long getAuthorizedObjectGroupId() {
		return authorizedObjectGroupId;
	}

	public void setAuthorizedObjectGroupId(long authorizedObjectGroupId) {
		this.authorizedObjectGroupId = authorizedObjectGroupId;
	}

}
