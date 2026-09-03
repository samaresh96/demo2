/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form3RhiltResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form3RhiltDataResp form3RhiltDataResp;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;

	public Form3RhiltResponseDTO() {
	}

	public Form3RhiltResponseDTO(boolean success, String message, String accessedOn,
			Form3RhiltDataResp form3RhiltDataResp, Map<?, ?> configList, List<LookupDetails> lookupList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form3RhiltDataResp = form3RhiltDataResp;
		this.configList = configList;
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

	public Form3RhiltDataResp getForm3RhiltDataResp() {
		return form3RhiltDataResp;
	}

	public void setForm3RhiltDataResp(Form3RhiltDataResp form3RhiltDataResp) {
		this.form3RhiltDataResp = form3RhiltDataResp;
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

	@Override
	public String toString() {
		return "Form3RhiltResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form3RhiltDataResp=" + form3RhiltDataResp + ", configList=" + configList + ", lookupList="
				+ lookupList + "]";
	}

}
