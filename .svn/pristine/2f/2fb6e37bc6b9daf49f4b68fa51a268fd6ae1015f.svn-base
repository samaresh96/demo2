/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetApplicationInfoResp {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;
	private List<HIFormTransactionResp> attachmentList;
	private List<HIFormMasterResp> formMasterList;
	private ApplicationInfoResp applicationInfo;
	private ResponseEntity<String> pdfContent;
	private List<NotificationList> notificationList;
	private List<StudentDataResp> studentList;
	private List<TeacherListResp> teacherList;
	private GetPhysicianInfoResp physicianData;

	public GetApplicationInfoResp() {
	}

	public GetApplicationInfoResp(boolean success, String message, String accessedOn, Map<?, ?> configList,
			List<LookupDetails> lookupList, List<HIFormTransactionResp> attachmentList,
			List<HIFormMasterResp> formMasterList, ApplicationInfoResp applicationInfo,
			ResponseEntity<String> pdfContent, List<NotificationList> notificationList,
			List<StudentDataResp> studentList, List<TeacherListResp> teacherList, GetPhysicianInfoResp physicianData) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.configList = configList;
		this.lookupList = lookupList;
		this.attachmentList = attachmentList;
		this.formMasterList = formMasterList;
		this.applicationInfo = applicationInfo;
		this.pdfContent = pdfContent;
		this.notificationList = notificationList;
		this.studentList = studentList;
		this.teacherList = teacherList;
		this.physicianData = physicianData;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccessedOn() {
		return accessedOn;
	}

	public void setAccessedOn(String accessedOn) {
		this.accessedOn = accessedOn;
	}

	public Map<?, ?> getConfigList() {
		return configList;
	}

	public void setConfigList(Map<?, ?> configList) {
		this.configList = configList;
	}

	public List<LookupDetails> getLookupList() {
		return lookupList;
	}

	public void setLookupList(List<LookupDetails> lookupList) {
		this.lookupList = lookupList;
	}

	public List<HIFormTransactionResp> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<HIFormTransactionResp> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<HIFormMasterResp> getFormMasterList() {
		return formMasterList;
	}

	public void setFormMasterList(List<HIFormMasterResp> formMasterList) {
		this.formMasterList = formMasterList;
	}

	public ApplicationInfoResp getApplicationInfo() {
		return applicationInfo;
	}

	public void setApplicationInfo(ApplicationInfoResp applicationInfo) {
		this.applicationInfo = applicationInfo;
	}

	public ResponseEntity<String> getPdfContent() {
		return pdfContent;
	}

	public void setPdfContent(ResponseEntity<String> pdfContent) {
		this.pdfContent = pdfContent;
	}

	public List<NotificationList> getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(List<NotificationList> notificationList) {
		this.notificationList = notificationList;
	}

	public List<StudentDataResp> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentDataResp> studentList) {
		this.studentList = studentList;
	}

	public List<TeacherListResp> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TeacherListResp> teacherList) {
		this.teacherList = teacherList;
	}

	public GetPhysicianInfoResp getPhysicianData() {
		return physicianData;
	}

	public void setPhysicianData(GetPhysicianInfoResp physicianData) {
		this.physicianData = physicianData;
	}

	@Override
	public String toString() {
		return "GetApplicationInfoResp [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", configList=" + configList + ", lookupList=" + lookupList + ", attachmentList=" + attachmentList
				+ ", formMasterList=" + formMasterList + ", applicationInfo=" + applicationInfo + ", pdfContent="
				+ pdfContent + ", notificationList=" + notificationList + ", studentList=" + studentList
				+ ", teacherList=" + teacherList + ", physicianData=" + physicianData + "]";
	}

}
