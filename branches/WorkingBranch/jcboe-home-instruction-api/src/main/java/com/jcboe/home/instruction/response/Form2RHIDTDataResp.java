/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class Form2RHIDTDataResp {
	private Long id;
	private Long applicationId;
	private Long formTransactionId;
	private Long studentId;
	private String studentName;
	private String schoolYear;
	private String applicationNo;
	private String studentDob;
	private String studentGender;
	private String studentGrade;
	private Integer studentGradeId;
	private String studentSchool;
	private String studentSchoolCode;
	private String physicianReview;
	private String hiEndDate;
	private String nurseSignature;
	private String nurseSignDate;
	private Boolean isAgree;
	private String physicianSignature;
	private String physicianSignDate;

	public Form2RHIDTDataResp() {
	}

	public Form2RHIDTDataResp(Long id, Long applicationId, Long formTransactionId, Long studentId, String studentName,
			String schoolYear, String applicationNo, String studentDob, String studentGender, String studentGrade,
			Integer studentGradeId, String studentSchool, String studentSchoolCode, String physicianReview,
			String hiEndDate, String nurseSignature, String nurseSignDate, Boolean isAgree, String physicianSignature,
			String physicianSignDate) {
		this.id = id;
		this.applicationId = applicationId;
		this.formTransactionId = formTransactionId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.schoolYear = schoolYear;
		this.applicationNo = applicationNo;
		this.studentDob = studentDob;
		this.studentGender = studentGender;
		this.studentGrade = studentGrade;
		this.studentGradeId = studentGradeId;
		this.studentSchool = studentSchool;
		this.studentSchoolCode = studentSchoolCode;
		this.physicianReview = physicianReview;
		this.hiEndDate = hiEndDate;
		this.nurseSignature = nurseSignature;
		this.nurseSignDate = nurseSignDate;
		this.isAgree = isAgree;
		this.physicianSignature = physicianSignature;
		this.physicianSignDate = physicianSignDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getFormTransactionId() {
		return formTransactionId;
	}

	public void setFormTransactionId(Long formTransactionId) {
		this.formTransactionId = formTransactionId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public Integer getStudentGradeId() {
		return studentGradeId;
	}

	public void setStudentGradeId(Integer studentGradeId) {
		this.studentGradeId = studentGradeId;
	}

	public String getStudentSchool() {
		return studentSchool;
	}

	public void setStudentSchool(String studentSchool) {
		this.studentSchool = studentSchool;
	}

	public String getStudentSchoolCode() {
		return studentSchoolCode;
	}

	public void setStudentSchoolCode(String studentSchoolCode) {
		this.studentSchoolCode = studentSchoolCode;
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

	@Override
	public String toString() {
		return "Form2RHIDTDataResp [id=" + id + ", applicationId=" + applicationId + ", formTransactionId="
				+ formTransactionId + ", studentId=" + studentId + ", studentName=" + studentName + ", schoolYear="
				+ schoolYear + ", applicationNo=" + applicationNo + ", studentDob=" + studentDob + ", studentGender="
				+ studentGender + ", studentGrade=" + studentGrade + ", studentGradeId=" + studentGradeId
				+ ", studentSchool=" + studentSchool + ", studentSchoolCode=" + studentSchoolCode + ", physicianReview="
				+ physicianReview + ", hiEndDate=" + hiEndDate + ", nurseSignature=" + nurseSignature
				+ ", nurseSignDate=" + nurseSignDate + ", isAgree=" + isAgree + ", physicianSignature="
				+ physicianSignature + ", physicianSignDate=" + physicianSignDate + "]";
	}

}
