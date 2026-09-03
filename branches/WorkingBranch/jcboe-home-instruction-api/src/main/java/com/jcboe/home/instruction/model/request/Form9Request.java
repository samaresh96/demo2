/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

import java.util.List;

public class Form9Request {
	private String indicator;
	private String schoolYear;
	private Long id;
	private String studentId;
	private String activity;
	private String status;
	private String comment;
	private Long applicationId;
	private Long formMasterId;
	private String formAbbreviation;
	private String teacherName;
	private String teacherEmail;
	private String teacherSignature;
	private String teacherSignDate;
	private List<Form9EAppPlanData> form9EappPlanData;
	private String loggedInUserId;
	private String loggedInUserPersonType;

	public Form9Request() {
	}

	public Form9Request(String indicator, String schoolYear, Long id, String studentId, String activity, String status,
			String comment, Long applicationId, Long formMasterId, String formAbbreviation, String teacherName,
			String teacherEmail, String teacherSignature, String teacherSignDate,
			List<Form9EAppPlanData> form9EappPlanData, String loggedInUserId, String loggedInUserPersonType) {
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
		this.teacherName = teacherName;
		this.teacherEmail = teacherEmail;
		this.teacherSignature = teacherSignature;
		this.teacherSignDate = teacherSignDate;
		this.form9EappPlanData = form9EappPlanData;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getFormMasterId() {
		return formMasterId;
	}

	public void setFormMasterId(Long formMasterId) {
		this.formMasterId = formMasterId;
	}

	public String getFormAbbreviation() {
		return formAbbreviation;
	}

	public void setFormAbbreviation(String formAbbreviation) {
		this.formAbbreviation = formAbbreviation;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherSignature() {
		return teacherSignature;
	}

	public void setTeacherSignature(String teacherSignature) {
		this.teacherSignature = teacherSignature;
	}

	public String getTeacherSignDate() {
		return teacherSignDate;
	}

	public void setTeacherSignDate(String teacherSignDate) {
		this.teacherSignDate = teacherSignDate;
	}

	public List<Form9EAppPlanData> getForm9EappPlanData() {
		return form9EappPlanData;
	}

	public void setForm9EappPlanData(List<Form9EAppPlanData> form9EappPlanData) {
		this.form9EappPlanData = form9EappPlanData;
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

	@Override
	public String toString() {
		return "Form9Request [indicator=" + indicator + ", schoolYear=" + schoolYear + ", id=" + id + ", studentId="
				+ studentId + ", activity=" + activity + ", status=" + status + ", comment=" + comment
				+ ", applicationId=" + applicationId + ", formMasterId=" + formMasterId + ", formAbbreviation="
				+ formAbbreviation + ", teacherName=" + teacherName + ", teacherEmail=" + teacherEmail
				+ ", teacherSignature=" + teacherSignature + ", teacherSignDate=" + teacherSignDate
				+ ", form9EappPlanData=" + form9EappPlanData + ", loggedInUserId=" + loggedInUserId
				+ ", loggedInUserPersonType=" + loggedInUserPersonType + "]";
	}

}
