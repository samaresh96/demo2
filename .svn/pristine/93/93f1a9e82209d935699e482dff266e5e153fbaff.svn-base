/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form2RHIDTResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form2RHIDTDataResp form2RHIDTDataResp;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;
	private GetPhysicianInfoResp physicianData;

	public Form2RHIDTResponseDTO() {
	}

	public Form2RHIDTResponseDTO(boolean success, String message, String accessedOn,
			Form2RHIDTDataResp form2RHIDTDataResp, Map<?, ?> configList, List<LookupDetails> lookupList,
			GetPhysicianInfoResp physicianData) {

		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form2RHIDTDataResp = form2RHIDTDataResp;
		this.configList = configList;
		this.lookupList = lookupList;
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

	public Form2RHIDTDataResp getform2RHIDTDataResp() {
		return form2RHIDTDataResp;
	}

	public void setForm2RHIDTDataResp(Form2RHIDTDataResp form2RHIDTDataResp) {
		this.form2RHIDTDataResp = form2RHIDTDataResp;
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

	public GetPhysicianInfoResp getPhysicianData() {
		return physicianData;
	}

	public void setPhysicianData(GetPhysicianInfoResp physicianData) {
		this.physicianData = physicianData;
	}

	@Override
	public String toString() {
		return "Form2RHIDTResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form2RHIDTDataResp=" + form2RHIDTDataResp + ", configList=" + configList + ", lookupList="
				+ lookupList + ", physicianData=" + physicianData + "]";
	}

}
