/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form9EAPPResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form9EAPPDataResp form9EAPPDataResp;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;

	public Form9EAPPResponseDTO() {
	}

	public Form9EAPPResponseDTO(boolean success, String message, String accessedOn, Form9EAPPDataResp form9eappDataResp,
			Map<?, ?> configList, List<LookupDetails> lookupList) {

		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form9EAPPDataResp = form9eappDataResp;
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

	public Form9EAPPDataResp getForm9EAPPDataResp() {
		return form9EAPPDataResp;
	}

	public void setForm9EAPPDataResp(Form9EAPPDataResp form9eappDataResp) {
		form9EAPPDataResp = form9eappDataResp;
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
		return "Form9EAPPResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form9EAPPDataResp=" + form9EAPPDataResp + ", configList=" + configList + ", lookupList="
				+ lookupList + "]";
	}

}
