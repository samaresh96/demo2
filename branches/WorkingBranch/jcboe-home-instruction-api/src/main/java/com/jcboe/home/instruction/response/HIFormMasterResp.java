/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class HIFormMasterResp {
	private Long id;
	private String formAbbreviation;
	private String formShortName;
	private String formName;
	private String pdfName;
	private String specialType;
	private boolean isActive;

	public HIFormMasterResp() {
	}

	public HIFormMasterResp(Long id, String formAbbreviation, String formShortName, String formName, String pdfName,
			String specialType, boolean isActive) {
		this.id = id;
		this.formAbbreviation = formAbbreviation;
		this.formShortName = formShortName;
		this.formName = formName;
		this.pdfName = pdfName;
		this.specialType = specialType;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormAbbreviation() {
		return formAbbreviation;
	}

	public void setFormAbbreviation(String formAbbreviation) {
		this.formAbbreviation = formAbbreviation;
	}

	public String getFormShortName() {
		return formShortName;
	}

	public void setFormShortName(String formShortName) {
		this.formShortName = formShortName;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

	public String getSpecialType() {
		return specialType;
	}

	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "HIFormMasterResp [id=" + id + ", formAbbreviation=" + formAbbreviation + ", formShortName="
				+ formShortName + ", formName=" + formName + ", pdfName=" + pdfName + ", specialType=" + specialType
				+ ", isActive=" + isActive + "]";
	}

}
