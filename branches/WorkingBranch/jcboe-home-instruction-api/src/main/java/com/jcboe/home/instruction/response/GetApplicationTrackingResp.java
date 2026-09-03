/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class GetApplicationTrackingResp {
	private Long applicationId;
	private String applicationNo;
	private String schoolYear;
	private String school;
	private String grade;
	private String studentName;
	private Long applicationTrackingId;
	private String verificationDate;
	private String noticeDate30Day;
	private String noticeDate60Day;
	private String cstAction;
	private String returnDate;

	public GetApplicationTrackingResp() {
	}

	public GetApplicationTrackingResp(Long applicationId, String applicationNo, String schoolYear, String school,
			String grade, String studentName, Long applicationTrackingId, String verificationDate,
			String noticeDate30Day, String noticeDate60Day, String cstAction, String returnDate) {
		this.applicationId = applicationId;
		this.applicationNo = applicationNo;
		this.schoolYear = schoolYear;
		this.school = school;
		this.grade = grade;
		this.studentName = studentName;
		this.applicationTrackingId = applicationTrackingId;
		this.verificationDate = verificationDate;
		this.noticeDate30Day = noticeDate30Day;
		this.noticeDate60Day = noticeDate60Day;
		this.cstAction = cstAction;
		this.returnDate = returnDate;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	@Override
	public String toString() {
		return "GetApplicationTrackingResp [applicationId=" + applicationId + ", applicationNo=" + applicationNo
				+ ", schoolYear=" + schoolYear + ", school=" + school + ", grade=" + grade + ", studentName="
				+ studentName + ", applicationTrackingId=" + applicationTrackingId + ", verificationDate="
				+ verificationDate + ", noticeDate30Day=" + noticeDate30Day + ", noticeDate60Day=" + noticeDate60Day
				+ ", cstAction=" + cstAction + ", returnDate=" + returnDate + "]";
	}

}
