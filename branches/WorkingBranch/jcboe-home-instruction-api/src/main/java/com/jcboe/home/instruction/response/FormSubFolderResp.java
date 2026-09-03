/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class FormSubFolderResp {

	private long id;
	private String subFolder;
	private String description;

	public FormSubFolderResp() {

	}

	public FormSubFolderResp(long id, String subFolder, String description) {

		this.id = id;
		this.subFolder = subFolder;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubFolder() {
		return subFolder;
	}

	public void setSubFolder(String subFolder) {
		this.subFolder = subFolder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FormSubFolderResp [id=" + id + ", subFolder=" + subFolder + ", description=" + description + "]";
	}
}
