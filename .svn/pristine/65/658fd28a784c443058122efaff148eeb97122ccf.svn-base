/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form8HiscpResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form8HiscpDataResp form8HiscpDataResp;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;

	public Form8HiscpResponseDTO() {
	}

	public Form8HiscpResponseDTO(boolean success, String message, String accessedOn,
			Form8HiscpDataResp form8HiscpDataResp, Map<?, ?> configList, List<LookupDetails> lookupList) {
		super();
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form8HiscpDataResp = form8HiscpDataResp;
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

	public Form8HiscpDataResp getForm8HiscpDataResp() {
		return form8HiscpDataResp;
	}

	public void setForm8HiscpDataResp(Form8HiscpDataResp form8HiscpDataResp) {
		this.form8HiscpDataResp = form8HiscpDataResp;
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
		return "Form8HiscpResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form8HiscpDataResp=" + form8HiscpDataResp + ", configList=" + configList + ", lookupList="
				+ lookupList + "]";
	}

}
