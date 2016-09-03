package com.starboard.b2b.web.form;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchImageForm extends CommonSearchForm {
	private String folder;
	private String subFolder;
	private String folderName;

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getSubFolder() {
		return subFolder;
	}

	public void setSubFolder(String subFolder) {
		this.subFolder = subFolder;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
