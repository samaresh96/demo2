/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateHIApplicationReq {

	private String indicator;
	private long id;
	private String studentId;
	@JsonProperty("schoolYear")
	private String schoolYear;
	private String applicationType;
	private String schoolCode;
	private int gradeId;
	private String requestDate;
	private String classification;
	private String activity;
	private String status;
	private String comment;
	private String submittedBy;
	private String submittedByPersonType;

	public UpdateHIApplicationReq() {
	}

	public UpdateHIApplicationReq(String indicator, long id, String studentId, String schoolYear,
			String applicationType, String schoolCode, int gradeId, String requestDate, String classification,
			String submittedBy, String submittedByPersonType) {
		this.indicator = indicator;
		this.id = id;
		this.studentId = studentId;
		this.schoolYear = schoolYear;
		this.applicationType = applicationType;
		this.schoolCode = schoolCode;
		this.gradeId = gradeId;
		this.requestDate = requestDate;
		this.classification = classification;
		this.submittedBy = submittedBy;
		this.submittedByPersonType = submittedByPersonType;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
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

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSubmittedByPersonType() {
		return submittedByPersonType;
	}

	public void setSubmittedByPersonType(String submittedByPersonType) {
		this.submittedByPersonType = submittedByPersonType;
	}

	@Override
	public String toString() {
		return "UpdateHIApplicationReq [indicator=" + indicator + ", id=" + id + ", studentId=" + studentId
				+ ", schoolYear=" + schoolYear + ", applicationType=" + applicationType + ", schoolCode=" + schoolCode
				+ ", gradeId=" + gradeId + ", requestDate=" + requestDate + ", classification=" + classification
				+ ", activity=" + activity + ", status=" + status + ", comment=" + comment + ", submittedBy="
				+ submittedBy + ", submittedByPersonType=" + submittedByPersonType + "]";
	}

}