/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

public class ApplicationTrackingDataList {
	private Long applicationTrackingId;
	private String verificationDate;
	private String studentName;
	private String noticeDate30Day;
	private String noticeDate60Day;
	private String cstAction;
	private String returnDate;
	private Long applicationId;
	private String schoolYear;
	private String school;
	private String grade;
	private String indicator;

	public ApplicationTrackingDataList() {
	}

	public ApplicationTrackingDataList(Long applicationTrackingId, String verificationDate, String studentName,
			String noticeDate30Day, String noticeDate60Day, String cstAction, String returnDate, Long applicationId,
			String schoolYear, String school, String grade, String indicator) {
		this.applicationTrackingId = applicationTrackingId;
		this.verificationDate = verificationDate;
		this.studentName = studentName;
		this.noticeDate30Day = noticeDate30Day;
		this.noticeDate60Day = noticeDate60Day;
		this.cstAction = cstAction;
		this.returnDate = returnDate;
		this.applicationId = applicationId;
		this.schoolYear = schoolYear;
		this.school = school;
		this.grade = grade;
		this.indicator = indicator;
	}

	public Long getApplicationTrackingId() {
		return applicationTrackingId;
	}

	public void setApplicationTrackingId(Long applicationTrackingId) {
		this.applicationTrackingId = applicationTrackingId;
	}

	public String getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getNoticeDate30Day() {
		return noticeDate30Day;
	}

	public void setNoticeDate30Day(String noticeDate30Day) {
		this.noticeDate30Day = noticeDate30Day;
	}

	public String getNoticeDate60Day() {
		return noticeDate60Day;
	}

	public void setNoticeDate60Day(String noticeDate60Day) {
		this.noticeDate60Day = noticeDate60Day;
	}

	public String getCstAction() {
		return cstAction;
	}

	public void setCstAction(String cstAction) {
		this.cstAction = cstAction;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	@Override
	public String toString() {
		return "ApplicationTrackingDataList [applicationTrackingId=" + applicationTrackingId + ", verificationDate="
				+ verificationDate + ", studentName=" + studentName + ", noticeDate30Day=" + noticeDate30Day
				+ ", noticeDate60Day=" + noticeDate60Day + ", cstAction=" + cstAction + ", returnDate=" + returnDate
				+ ", applicationId=" + applicationId + ", schoolYear=" + schoolYear + ", school=" + school + ", grade="
				+ grade + ", indicator=" + indicator + "]";
	}

}
