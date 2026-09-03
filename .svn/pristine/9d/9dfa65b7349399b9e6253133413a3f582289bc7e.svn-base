/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form630DhiResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form630DhiDataResp form630DhiDataResp;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;
	private List<HIFormTransactionResp> attachmentList;

	public Form630DhiResponseDTO() {
	}

	public Form630DhiResponseDTO(boolean success, String message, String accessedOn,
			Form630DhiDataResp form630DhiDataResp, Map<?, ?> configList, List<LookupDetails> lookupList,
			List<HIFormTransactionResp> attachmentList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form630DhiDataResp = form630DhiDataResp;
		this.configList = configList;
		this.lookupList = lookupList;
		this.attachmentList = attachmentList;
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

	public Form630DhiDataResp getForm630DhiDataResp() {
		return form630DhiDataResp;
	}

	public void setForm630DhiDataResp(Form630DhiDataResp form630DhiDataResp) {
		this.form630DhiDataResp = form630DhiDataResp;
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

	@Override
	public String toString() {
		return "Form630DhiResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form630DhiDataResp=" + form630DhiDataResp + ", configList=" + configList + ", lookupList="
				+ lookupList + ", attachmentList=" + attachmentList + "]";
	}

}
