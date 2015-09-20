
package com.starboard.b2b.dto.original;

public class AuthorizedObjectGroup {

	private long authorizedObjectGroupId;
	private String name;
	private String description;
	private String userCreate;
	private String userUpdate;
	private java.util.Date timeCreate;
	private java.util.Date timeUpdate;

	public long getAuthorizedObjectGroupId() {
		return authorizedObjectGroupId;
	}

	public void setAuthorizedObjectGroupId(long authorizedObjectGroupId) {
		this.authorizedObjectGroupId = authorizedObjectGroupId;
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

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
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

}
