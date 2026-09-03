/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationTrackingResponseDTO {

	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private List<GetApplicationTrackingResp> applicationTrackingRespList;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;

	public ApplicationTrackingResponseDTO() {
	}

	public ApplicationTrackingResponseDTO(boolean success, String message, String accessedOn,
			List<GetApplicationTrackingResp> applicationTrackingRespList, Map<?, ?> configList,
			List<LookupDetails> lookupList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.applicationTrackingRespList = applicationTrackingRespList;
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

	public List<GetApplicationTrackingResp> getApplicationTrackingRespList() {
		return applicationTrackingRespList;
	}

	public void setApplicationTrackingRespList(List<GetApplicationTrackingResp> applicationTrackingRespList) {
		this.applicationTrackingRespList = applicationTrackingRespList;
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
		return "ApplicationTrackingResponseDTO [success=" + success + ", message=" + message + ", accessedOn="
				+ accessedOn + ", applicationTrackingRespList=" + applicationTrackingRespList + ", configList="
				+ configList + ", lookupList=" + lookupList + "]";
	}

}
