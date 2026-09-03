/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form10HSAPPResponseDTO {

	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Form10HSAPPDataResp form10HSAPPDataResp;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;
	private List<HIFormTransactionResp> attachmentList;

	public Form10HSAPPResponseDTO() {
	}

	public Form10HSAPPResponseDTO(boolean success, String message, String accessedOn,
			Form10HSAPPDataResp form10hsappDataResp, Map<?, ?> configList, List<LookupDetails> lookupList,
			List<HIFormTransactionResp> attachmentList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		form10HSAPPDataResp = form10hsappDataResp;
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

	public Form10HSAPPDataResp getForm10HSAPPDataResp() {
		return form10HSAPPDataResp;
	}

	public void setForm10HSAPPDataResp(Form10HSAPPDataResp form10hsappDataResp) {
		form10HSAPPDataResp = form10hsappDataResp;
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
		return "Form10HSAPPResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form10HSAPPDataResp=" + form10HSAPPDataResp + ", configList=" + configList + ", lookupList="
				+ lookupList + ", attachmentList=" + attachmentList + "]";
	}

}
