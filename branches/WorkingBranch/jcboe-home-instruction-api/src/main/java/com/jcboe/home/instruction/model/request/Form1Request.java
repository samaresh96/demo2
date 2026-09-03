/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form1Request {

	private String indicator;
	private Long form1AphirDataId;
	private String studentId;
	private String schoolYear;
	private String applicationType;
	private String schoolCode;
	private int gradeId;
	private String requestDate;
	private String activity;
	private String status;
	private String comment;
	private Long applicationId;
	private Long formMasterId;
	private String otherDocumentName;
	private String formAbbreviation;
	private String classification;
	private String parentName;
	private String homePhone;
	private String workPhone;
	private String emergencyPhone;
	private String homeAddress;
	private String emailAddress;
	private String counselorName;
	private String counselorPhone;
	private String nurseName;
	private String nursePhone;
	private String attendanceLastDate;
	private String reason;
	private String caseNotification;
	private String notificationDate;
	private String parentSignature;
	private String parentSignDate;
	private String principalSignature;
	private String principalSignDate;
	private String dirSpecialEdSignature;
	private String dirSpecialEdSignDate;
	private String dirSupSignature;
	private String dirSupSignDate;
	private String dirStudentLifeService;
	private String dirStudentLifeDate;
	@JsonProperty("isApproved")
	private Boolean approved;
	private String approvedUptoDate;
	private String physicianSignature;
	private String physicianSignDate;
	private List<Form1AphirSchedule> form1AphirScheduleData;
	private String loggedInUserId;
	private String loggedInUserPersonType;

	public Form1Request() {
	}

	public Form1Request(String indicator, Long form1AphirDataId, String studentId, String schoolYear,
			String applicationType, String schoolCode, int gradeId, String requestDate, String activity, String status,
			String comment, Long applicationId, Long formMasterId, String otherDocumentName, String formAbbreviation,
			String classification, String parentName, String homePhone, String workPhone, String emergencyPhone,
			String homeAddress, String emailAddress, String counselorName, String counselorPhone, String nurseName,
			String nursePhone, String attendanceLastDate, String reason, String caseNotification,
			String notificationDate, String parentSignature, String parentSignDate, String principalSignature,
			String principalSignDate, String dirSpecialEdSignature, String dirSpecialEdSignDate, String dirSupSignature,
			String dirSupSignDate, String dirStudentLifeService, String dirStudentLifeDate, Boolean approved,
			String approvedUptoDate, String physicianSignature, String physicianSignDate,
			List<Form1AphirSchedule> form1AphirScheduleData, String loggedInUserId, String loggedInUserPersonType) {
		this.indicator = indicator;
		this.form1AphirDataId = form1AphirDataId;
		this.studentId = studentId;
		this.schoolYear = schoolYear;
		this.applicationType = applicationType;
		this.schoolCode = schoolCode;
		this.gradeId = gradeId;
		this.requestDate = requestDate;
		this.activity = activity;
		this.status = status;
		this.comment = comment;
		this.applicationId = applicationId;
		this.formMasterId = formMasterId;
		this.otherDocumentName = otherDocumentName;
		this.formAbbreviation = formAbbreviation;
		this.classification = classification;
		this.parentName = parentName;
		this.homePhone = homePhone;
		this.workPhone = workPhone;
		this.emergencyPhone = emergencyPhone;
		this.homeAddress = homeAddress;
		this.emailAddress = emailAddress;
		this.counselorName = counselorName;
		this.counselorPhone = counselorPhone;
		this.nurseName = nurseName;
		this.nursePhone = nursePhone;
		this.attendanceLastDate = attendanceLastDate;
		this.reason = reason;
		this.caseNotification = caseNotification;
		this.notificationDate = notificationDate;
		this.parentSignature = parentSignature;
		this.parentSignDate = parentSignDate;
		this.principalSignature = principalSignature;
		this.principalSignDate = principalSignDate;
		this.dirSpecialEdSignature = dirSpecialEdSignature;
		this.dirSpecialEdSignDate = dirSpecialEdSignDate;
		this.dirSupSignature = dirSupSignature;
		this.dirSupSignDate = dirSupSignDate;
		this.dirStudentLifeService = dirStudentLifeService;
		this.dirStudentLifeDate = dirStudentLifeDate;
		this.approved = approved;
		this.approvedUptoDate = approvedUptoDate;
		this.physicianSignature = physicianSignature;
		this.physicianSignDate = physicianSignDate;
		this.form1AphirScheduleData = form1AphirScheduleData;
		this.loggedInUserId = loggedInUserId;
		this.loggedInUserPersonType = loggedInUserPersonType;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public Long getForm1AphirDataId() {
		return form1AphirDataId;
	}

	public void setForm1AphirDataId(Long form1AphirDataId) {
		this.form1AphirDataId = form1AphirDataId;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
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

	public String form1Request() {
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

	public String getOtherDocumentName() {
		return otherDocumentName;
	}

	public void setOtherDocumentName(String otherDocumentName) {
		this.otherDocumentName = otherDocumentName;
	}

	public String getFormAbbreviation() {
		return formAbbreviation;
	}

	public void setFormAbbreviation(String formAbbreviation) {
		this.formAbbreviation = formAbbreviation;
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

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCounselorName() {
		return counselorName;
	}

	public void setCounselorName(String counselorName) {
		this.counselorName = counselorName;
	}

	public String getCounselorPhone() {
		return counselorPhone;
	}

	public void setCounselorPhone(String counselorPhone) {
		this.counselorPhone = counselorPhone;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public String getNursePhone() {
		return nursePhone;
	}

	public void setNursePhone(String nursePhone) {
		this.nursePhone = nursePhone;
	}

	public String getAttendanceLastDate() {
		return attendanceLastDate;
	}

	public void setAttendanceLastDate(String attendanceLastDate) {
		this.attendanceLastDate = attendanceLastDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCaseNotification() {
		return caseNotification;
	}

	public void setCaseNotification(String caseNotification) {
		this.caseNotification = caseNotification;
	}

	public String getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(String notificationDate) {
		this.notificationDate = notificationDate;
	}

	public String getParentSignature() {
		return parentSignature;
	}

	public void setParentSignature(String parentSignature) {
		this.parentSignature = parentSignature;
	}

	public String getParentSignDate() {
		return parentSignDate;
	}

	public void setParentSignDate(String parentSignDate) {
		this.parentSignDate = parentSignDate;
	}

	public String getPrincipalSignature() {
		return principalSignature;
	}

	public void setPrincipalSignature(String principalSignature) {
		this.principalSignature = principalSignature;
	}

	public String getPrincipalSignDate() {
		return principalSignDate;
	}

	public void setPrincipalSignDate(String principalSignDate) {
		this.principalSignDate = principalSignDate;
	}

	public String getDirSpecialEdSignature() {
		return dirSpecialEdSignature;
	}

	public void setDirSpecialEdSignature(String dirSpecialEdSignature) {
		this.dirSpecialEdSignature = dirSpecialEdSignature;
	}

	public String getDirSpecialEdSignDate() {
		return dirSpecialEdSignDate;
	}

	public void setDirSpecialEdSignDate(String dirSpecialEdSignDate) {
		this.dirSpecialEdSignDate = dirSpecialEdSignDate;
	}

	public String getDirSupSignature() {
		return dirSupSignature;
	}

	public void setDirSupSignature(String dirSupSignature) {
		this.dirSupSignature = dirSupSignature;
	}

	public String getDirSupSignDate() {
		return dirSupSignDate;
	}

	public void setDirSupSignDate(String dirSupSignDate) {
		this.dirSupSignDate = dirSupSignDate;
	}

	public String getDirStudentLifeService() {
		return dirStudentLifeService;
	}

	public void setDirStudentLifeService(String dirStudentLifeService) {
		this.dirStudentLifeService = dirStudentLifeService;
	}

	public String getDirStudentLifeDate() {
		return dirStudentLifeDate;
	}

	public void setDirStudentLifeDate(String dirStudentLifeDate) {
		this.dirStudentLifeDate = dirStudentLifeDate;
	}

	public String getApprovedUptoDate() {
		return approvedUptoDate;
	}

	public void setApprovedUptoDate(String approvedUptoDate) {
		this.approvedUptoDate = approvedUptoDate;
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

	public List<Form1AphirSchedule> getForm1AphirScheduleData() {
		return form1AphirScheduleData;
	}

	public void setForm1AphirScheduleData(List<Form1AphirSchedule> form1AphirScheduleData) {
		this.form1AphirScheduleData = form1AphirScheduleData;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	@Override
	public String toString() {
		return "Form1Request [indicator=" + indicator + ", form1AphirDataId=" + form1AphirDataId + ", studentId="
				+ studentId + ", schoolYear=" + schoolYear + ", applicationType=" + applicationType + ", schoolCode="
				+ schoolCode + ", gradeId=" + gradeId + ", requestDate=" + requestDate + ", activity=" + activity
				+ ", status=" + status + ", comment=" + comment + ", applicationId=" + applicationId + ", formMasterId="
				+ formMasterId + ", otherDocumentName=" + otherDocumentName + ", formAbbreviation=" + formAbbreviation
				+ ", classification=" + classification + ", parentName=" + parentName + ", homePhone=" + homePhone
				+ ", workPhone=" + workPhone + ", emergencyPhone=" + emergencyPhone + ", homeAddress=" + homeAddress
				+ ", emailAddress=" + emailAddress + ", counselorName=" + counselorName + ", counselorPhone="
				+ counselorPhone + ", nurseName=" + nurseName + ", nursePhone=" + nursePhone + ", attendanceLastDate="
				+ attendanceLastDate + ", reason=" + reason + ", caseNotification=" + caseNotification
				+ ", notificationDate=" + notificationDate + ", parentSignature=" + parentSignature
				+ ", parentSignDate=" + parentSignDate + ", principalSignature=" + principalSignature
				+ ", principalSignDate=" + principalSignDate + ", dirSpecialEdSignature=" + dirSpecialEdSignature
				+ ", dirSpecialEdSignDate=" + dirSpecialEdSignDate + ", dirSupSignature=" + dirSupSignature
				+ ", dirSupSignDate=" + dirSupSignDate + ", dirStudentLifeService=" + dirStudentLifeService
				+ ", dirStudentLifeDate=" + dirStudentLifeDate + ", approved=" + approved + ", approvedUptoDate="
				+ approvedUptoDate + ", physicianSignature=" + physicianSignature + ", physicianSignDate="
				+ physicianSignDate + ", form1AphirScheduleData=" + form1AphirScheduleData + ", loggedInUserId="
				+ loggedInUserId + ", loggedInUserPersonType=" + loggedInUserPersonType + "]";
	}

}
