/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form4PrthiResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form4PrthiDataResp form4PrthiDataResp;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;

	public Form4PrthiResponseDTO() {
	}

	public Form4PrthiResponseDTO(boolean success, String message, String accessedOn,
			Form4PrthiDataResp form4PrthiDataResp, Map<?, ?> configList, List<LookupDetails> lookupList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form4PrthiDataResp = form4PrthiDataResp;
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

	public Form4PrthiDataResp getForm4PrthiDataResp() {
		return form4PrthiDataResp;
	}

	public void setForm4PrthiDataResp(Form4PrthiDataResp form4PrthiDataResp) {
		this.form4PrthiDataResp = form4PrthiDataResp;
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
		return "Form4PrthiResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form4PrthiDataResp=" + form4PrthiDataResp + ", configList=" + configList + ", lookupList="
				+ lookupList + "]";
	}

}
