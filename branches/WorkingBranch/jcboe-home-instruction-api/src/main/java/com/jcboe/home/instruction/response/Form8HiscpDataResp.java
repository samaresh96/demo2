/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class Form8HiscpDataResp {
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
	private String reason;
	private String medicalCutoffDate;
	private Boolean isPhysicalLimitation;
	private String nurseComments;
	private String nurseSignature;
	private String nurseSignDate;
	private String program;
	private String primaryLanguage;
	private String lastPresentDate;
	private String numberOfDayMissing;
	private String hoursOfInstruction;
	private String academicLevel;
	private String studentHistory;
	private String counsellorSignature;
	private String counsellorSignDate;

	public Form8HiscpDataResp() {
	}

	public Form8HiscpDataResp(Long id, Long applicationId, Long formTransactionId, Long studentId, String studentName,
			String schoolYear, String applicationNo, String studentDob, String studentGender, String studentGrade,
			Integer studentGradeId, String studentSchool, String studentSchoolCode, String reason,
			String medicalCutoffDate, Boolean isPhysicalLimitation, String nurseComments, String nurseSignature,
			String nurseSignDate, String program, String primaryLanguage, String lastPresentDate,
			String numberOfDayMissing, String hoursOfInstruction, String academicLevel, String studentHistory,
			String counsellorSignature, String counsellorSignDate) {
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
		this.reason = reason;
		this.medicalCutoffDate = medicalCutoffDate;
		this.isPhysicalLimitation = isPhysicalLimitation;
		this.nurseComments = nurseComments;
		this.nurseSignature = nurseSignature;
		this.nurseSignDate = nurseSignDate;
		this.program = program;
		this.primaryLanguage = primaryLanguage;
		this.lastPresentDate = lastPresentDate;
		this.numberOfDayMissing = numberOfDayMissing;
		this.hoursOfInstruction = hoursOfInstruction;
		this.academicLevel = academicLevel;
		this.studentHistory = studentHistory;
		this.counsellorSignature = counsellorSignature;
		this.counsellorSignDate = counsellorSignDate;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMedicalCutoffDate() {
		return medicalCutoffDate;
	}

	public void setMedicalCutoffDate(String medicalCutoffDate) {
		this.medicalCutoffDate = medicalCutoffDate;
	}

	public Boolean getIsPhysicalLimitation() {
		return isPhysicalLimitation;
	}

	public void setIsPhysicalLimitation(Boolean isPhysicalLimitation) {
		this.isPhysicalLimitation = isPhysicalLimitation;
	}

	public String getNurseComments() {
		return nurseComments;
	}

	public void setNurseComments(String nurseComments) {
		this.nurseComments = nurseComments;
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

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getPrimaryLanguage() {
		return primaryLanguage;
	}

	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}

	public String getLastPresentDate() {
		return lastPresentDate;
	}

	public void setLastPresentDate(String lastPresentDate) {
		this.lastPresentDate = lastPresentDate;
	}

	public String getNumberOfDayMissing() {
		return numberOfDayMissing;
	}

	public void setNumberOfDayMissing(String numberOfDayMissing) {
		this.numberOfDayMissing = numberOfDayMissing;
	}

	public String getHoursOfInstruction() {
		return hoursOfInstruction;
	}

	public void setHoursOfInstruction(String hoursOfInstruction) {
		this.hoursOfInstruction = hoursOfInstruction;
	}

	public String getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}

	public String getStudentHistory() {
		return studentHistory;
	}

	public void setStudentHistory(String studentHistory) {
		this.studentHistory = studentHistory;
	}

	public String getCounsellorSignature() {
		return counsellorSignature;
	}

	public void setCounsellorSignature(String counsellorSignature) {
		this.counsellorSignature = counsellorSignature;
	}

	public String getCounsellorSignDate() {
		return counsellorSignDate;
	}

	public void setCounsellorSignDate(String counsellorSignDate) {
		this.counsellorSignDate = counsellorSignDate;
	}

	@Override
	public String toString() {
		return "Form8HiscpDataResp [id=" + id + ", applicationId=" + applicationId + ", formTransactionId="
				+ formTransactionId + ", studentId=" + studentId + ", studentName=" + studentName + ", schoolYear="
				+ schoolYear + ", applicationNo=" + applicationNo + ", studentDob=" + studentDob + ", studentGender="
				+ studentGender + ", studentGrade=" + studentGrade + ", studentGradeId=" + studentGradeId
				+ ", studentSchool=" + studentSchool + ", studentSchoolCode=" + studentSchoolCode + ", reason=" + reason
				+ ", medicalCutoffDate=" + medicalCutoffDate + ", isPhysicalLimitation=" + isPhysicalLimitation
				+ ", nurseComments=" + nurseComments + ", nurseSignature=" + nurseSignature + ", nurseSignDate="
				+ nurseSignDate + ", program=" + program + ", primaryLanguage=" + primaryLanguage + ", lastPresentDate="
				+ lastPresentDate + ", numberOfDayMissing=" + numberOfDayMissing + ", hoursOfInstruction="
				+ hoursOfInstruction + ", academicLevel=" + academicLevel + ", studentHistory=" + studentHistory
				+ ", counsellorSignature=" + counsellorSignature + ", counsellorSignDate=" + counsellorSignDate + "]";
	}

}
