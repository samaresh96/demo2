/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

public class Form2Request {
	private String indicator;
	private String schoolYear;
	private Integer id;
	private String studentId;
	private String activity;
	private String status;
	private String comment;
	private long applicationId;
	private long formMasterId;
	private String otherDocumentName;
	private String formAbbreviation;
	private String physicianReview;
	private String hiEndDate;
	private String nurseSignature;
	private String nurseSignDate;
	private Boolean isAgree;
	private String physicianSignature;
	private String physicianSignDate;
	private String loggedInUserId;
	private String loggedInUserPersonType;

	public Form2Request() {
	}

	public Form2Request(String indicator, String schoolYear, Integer id, String studentId, String activity,
			String status, String comment, long applicationId, long formMasterId, String formAbbreviation,
			String physicianReview, String hiEndDate, String nurseSignature, String nurseSignDate, Boolean isAgree,
			String physicianSignature, String physicianSignDate, String loggedInUserId, String loggedInUserPersonType) {
		this.indicator = indicator;
		this.schoolYear = schoolYear;
		this.id = id;
		this.studentId = studentId;
		this.activity = activity;
		this.status = status;
		this.comment = comment;
		this.applicationId = applicationId;
		this.formMasterId = formMasterId;
		this.formAbbreviation = formAbbreviation;
		this.physicianReview = physicianReview;
		this.hiEndDate = hiEndDate;
		this.nurseSignature = nurseSignature;
		this.nurseSignDate = nurseSignDate;
		this.isAgree = isAgree;
		this.physicianSignature = physicianSignature;
		this.physicianSignDate = physicianSignDate;
		this.loggedInUserId = loggedInUserId;
		this.loggedInUserPersonType = loggedInUserPersonType;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public long getFormMasterId() {
		return formMasterId;
	}

	public void setFormMasterId(long formMasterId) {
		this.formMasterId = formMasterId;
	}

	public String getFormAbbreviation() {
		return formAbbreviation;
	}

	public void setFormAbbreviation(String formAbbreviation) {
		this.formAbbreviation = formAbbreviation;
	}

	public String getPhysicianReview() {
		return physicianReview;
	}

	public void setPhysicianReview(String physicianReview) {
		this.physicianReview = physicianReview;
	}

	public String getHiEndDate() {
		return hiEndDate;
	}

	public void setHiEndDate(String hiEndDate) {
		this.hiEndDate = hiEndDate;
	}

	public String getNurseSignature() {
		return nurseSignature;
	}

	public void setNurseSignature(String nurseSignature) {
		this.nurseSignature = nurseSignature;
	}

	public String getNurseSignDate() {
		return nurseSignDate;
	}

	public void setNurseSignDate(String nurseSignDate) {
		this.nurseSignDate = nurseSignDate;
	}

	public Boolean getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(Boolean isAgree) {
		this.isAgree = isAgree;
	}

	public String getPhysicianSignature() {
		return physicianSignature;
	}

	public void setPhysicianSignature(String physicianSignature) {
		this.physicianSignature = physicianSignature;
	}

	public String getPhysicianSignDate() {
		return physicianSignDate;
	}

	public void setPhysicianSignDate(String physicianSignDate) {
		this.physicianSignDate = physicianSignDate;
	}

	public String getLoggedInUserId() {
		return loggedInUserId;
	}

	public void setLoggedInUserId(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	public String getLoggedInUserPersonType() {
		return loggedInUserPersonType;
	}

	public void setLoggedInUserPersonType(String loggedInUserPersonType) {
		this.loggedInUserPersonType = loggedInUserPersonType;
	}

	public String getOtherDocumentName() {
		return otherDocumentName;
	}

	public void setOtherDocumentName(String otherDocumentName) {
		this.otherDocumentName = otherDocumentName;
	}

	@Override
	public String toString() {
		return "Form2Request [indicator=" + indicator + ", schoolYear=" + schoolYear + ", id=" + id + ", studentId="
				+ studentId + ", activity=" + activity + ", status=" + status + ", comment=" + comment
				+ ", applicationId=" + applicationId + ", formMasterId=" + formMasterId + ", otherDocumentName="
				+ otherDocumentName + ", formAbbreviation=" + formAbbreviation + ", physicianReview=" + physicianReview
				+ ", hiEndDate=" + hiEndDate + ", nurseSignature=" + nurseSignature + ", nurseSignDate=" + nurseSignDate
				+ ", isAgree=" + isAgree + ", physicianSignature=" + physicianSignature + ", physicianSignDate="
				+ physicianSignDate + ", loggedInUserId=" + loggedInUserId + ", loggedInUserPersonType="
				+ loggedInUserPersonType + "]";
	}

	
}
