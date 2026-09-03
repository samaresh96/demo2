/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form760DhiResp {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	List<Form760DhiDataResp> form7AphirDataResp;
	List<LookupDetails> lookupTypeList;
	private Map<?, ?> configList;

	public Form760DhiResp() {
	}

	public Form760DhiResp(boolean success, String message, String accessedOn,
			List<Form760DhiDataResp> form7AphirDataResp, List<LookupDetails> lookupTypeList, Map<?, ?> configList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form7AphirDataResp = form7AphirDataResp;
		this.lookupTypeList = lookupTypeList;
		this.configList = configList;
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

	public List<Form760DhiDataResp> getForm7AphirDataResp() {
		return form7AphirDataResp;
	}

	public void setForm7AphirDataResp(List<Form760DhiDataResp> form7AphirDataResp) {
		this.form7AphirDataResp = form7AphirDataResp;
	}

	public List<LookupDetails> getLookupTypeList() {
		return lookupTypeList;
	}

	public void setLookupTypeList(List<LookupDetails> lookupTypeList) {
		this.lookupTypeList = lookupTypeList;
	}

	public Map<?, ?> getConfigList() {
		return configList;
	}

	public void setConfigList(Map<?, ?> configList) {
		this.configList = configList;
	}

	@Override
	public String toString() {
		return "Form760DhiResp [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form7AphirDataResp=" + form7AphirDataResp + ", lookupTypeList=" + lookupTypeList + ", configList="
				+ configList + "]";
	}

}
