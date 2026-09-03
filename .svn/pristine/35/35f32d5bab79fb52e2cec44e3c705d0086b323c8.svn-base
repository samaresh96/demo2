/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form1APHIRResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form1AphirDataResp form1AphirDataResp;
	private List<Form1AphirScheduleResp> form1AphirScheduleResp;
	private List<HIFormTransactionResp> attachmentList;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;
	private List<StudentDataResp> studentList;
	private GetPhysicianInfoResp physicianData;

	public Form1APHIRResponseDTO() {
	}

	public Form1APHIRResponseDTO(boolean success, String message, String accessedOn,
			Form1AphirDataResp form1AphirDataResp, List<Form1AphirScheduleResp> form1AphirScheduleResp,
			List<HIFormTransactionResp> attachmentList, Map<?, ?> configList, List<LookupDetails> lookupList,
			List<StudentDataResp> studentList, GetPhysicianInfoResp physicianData) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form1AphirDataResp = form1AphirDataResp;
		this.form1AphirScheduleResp = form1AphirScheduleResp;
		this.attachmentList = attachmentList;
		this.configList = configList;
		this.lookupList = lookupList;
		this.studentList = studentList;
		this.physicianData = physicianData;
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

	public Form1AphirDataResp getForm1AphirDataResp() {
		return form1AphirDataResp;
	}

	public void setForm1AphirDataResp(Form1AphirDataResp form1AphirDataResp) {
		this.form1AphirDataResp = form1AphirDataResp;
	}

	public List<Form1AphirScheduleResp> getForm1AphirScheduleResp() {
		return form1AphirScheduleResp;
	}

	public void setForm1AphirScheduleResp(List<Form1AphirScheduleResp> form1AphirScheduleResp) {
		this.form1AphirScheduleResp = form1AphirScheduleResp;
	}

	public List<HIFormTransactionResp> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<HIFormTransactionResp> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<StudentDataResp> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentDataResp> studentList) {
		this.studentList = studentList;
	}

	public GetPhysicianInfoResp getPhysicianData() {
		return physicianData;
	}

	public void setPhysicianData(GetPhysicianInfoResp physicianData) {
		this.physicianData = physicianData;
	}

	@Override
	public String toString() {
		return "Form1APHIRResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form1AphirDataResp=" + form1AphirDataResp + ", form1AphirScheduleResp=" + form1AphirScheduleResp
				+ ", attachmentList=" + attachmentList + ", configList=" + configList + ", lookupList=" + lookupList
				+ ", studentList=" + studentList + ", physicianData=" + physicianData + "]";
	}

}
