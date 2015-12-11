package com.starboard.b2b.dto;

public class B2BFile {
	private String name;
	private String nameWithPath;
	private String fullPath;
	private boolean folder;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public boolean isFolder() {
		return folder;
	}

	public void setFolder(boolean folder) {
		this.folder = folder;
	}

	public String getNameWithPath() {
		return nameWithPath;
	}

	public void setNameWithPath(String nameWithPath) {
		this.nameWithPath = nameWithPath;
	}

}
