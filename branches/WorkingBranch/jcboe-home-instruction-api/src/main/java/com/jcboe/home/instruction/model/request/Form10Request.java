/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

public class Form10Request {

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
	private String subject;
	private String gradeInProgress;
	private String teacherName;
	private String teacherEmail;
	private Boolean isAdditionalTimeNeeded;
	private String unitOfStudy;
	private String assignments;
	private String independentWork;
	private String assessments;
	private String standardsCovered;
	private String otherResources;
	private String teacherSignature;
	private String teacherSignDate;
	private String loggedInUserId;
	private String loggedInUserPersonType;

	public Form10Request() {
	}

	public Form10Request(String indicator, String schoolYear, Long id, String studentId, String activity, String status,
			String comment, Long applicationId, Long formMasterId, String formAbbreviation,
			String subject, String gradeInProgress, String teacherName, String teacherEmail,
			Boolean isAdditionalTimeNeeded, String unitOfStudy, String assignments, String independentWork,
			String assessments, String standardsCovered, String otherResources, String teacherSignature,
			String teacherSignDate, String loggedInUserId, String loggedInUserPersonType) {
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
		this.subject = subject;
		this.gradeInProgress = gradeInProgress;
		this.teacherName = teacherName;
		this.teacherEmail = teacherEmail;
		this.isAdditionalTimeNeeded = isAdditionalTimeNeeded;
		this.unitOfStudy = unitOfStudy;
		this.assignments = assignments;
		this.independentWork = independentWork;
		this.assessments = assessments;
		this.standardsCovered = standardsCovered;
		this.otherResources = otherResources;
		this.teacherSignature = teacherSignature;
		this.teacherSignDate = teacherSignDate;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGradeInProgress() {
		return gradeInProgress;
	}

	public void setGradeInProgress(String gradeInProgress) {
		this.gradeInProgress = gradeInProgress;
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

	public Boolean getIsAdditionalTimeNeeded() {
		return isAdditionalTimeNeeded;
	}

	public void setIsAdditionalTimeNeeded(Boolean isAdditionalTimeNeeded) {
		this.isAdditionalTimeNeeded = isAdditionalTimeNeeded;
	}

	public String getUnitOfStudy() {
		return unitOfStudy;
	}

	public void setUnitOfStudy(String unitOfStudy) {
		this.unitOfStudy = unitOfStudy;
	}

	public String getAssignments() {
		return assignments;
	}

	public void setAssignments(String assignments) {
		this.assignments = assignments;
	}

	public String getIndependentWork() {
		return independentWork;
	}

	public void setIndependentWork(String independentWork) {
		this.independentWork = independentWork;
	}

	public String getAssessments() {
		return assessments;
	}

	public void setAssessments(String assessments) {
		this.assessments = assessments;
	}

	public String getStandardsCovered() {
		return standardsCovered;
	}

	public void setStandardsCovered(String standardsCovered) {
		this.standardsCovered = standardsCovered;
	}

	public String getOtherResources() {
		return otherResources;
	}

	public void setOtherResources(String otherResources) {
		this.otherResources = otherResources;
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
		return "Form10Request [indicator=" + indicator + ", schoolYear=" + schoolYear + ", id=" + id + ", studentId="
				+ studentId + ", activity=" + activity + ", status=" + status + ", comment=" + comment
				+ ", applicationId=" + applicationId + ", formMasterId=" + formMasterId + ", formAbbreviation="
				+ formAbbreviation + ", subject=" + subject + ", gradeInProgress=" + gradeInProgress + ", teacherName="
				+ teacherName + ", teacherEmail=" + teacherEmail + ", isAdditionalTimeNeeded=" + isAdditionalTimeNeeded
				+ ", unitOfStudy=" + unitOfStudy + ", assignments=" + assignments + ", independentWork="
				+ independentWork + ", assessments=" + assessments + ", standardsCovered=" + standardsCovered
				+ ", otherResources=" + otherResources + ", teacherSignature=" + teacherSignature + ", teacherSignDate="
				+ teacherSignDate + ", loggedInUserId=" + loggedInUserId + ", loggedInUserPersonType="
				+ loggedInUserPersonType + "]";
	}

}
