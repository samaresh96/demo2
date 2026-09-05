/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationHistoryResp {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private List<ApplicationHistoryDTO> applicationHistorDTO;

	public ApplicationHistoryResp() {
	}

	public ApplicationHistoryResp(boolean success, String message, String accessedOn,
			List<ApplicationHistoryDTO> applicationHistorDTO) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.applicationHistorDTO = applicationHistorDTO;
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

	public List<ApplicationHistoryDTO> getApplicationHistorDTO() {
		return applicationHistorDTO;
	}

	public void setApplicationHistorDTO(List<ApplicationHistoryDTO> applicationHistorDTO) {
		this.applicationHistorDTO = applicationHistorDTO;
	}

	@Override
	public String toString() {
		return "ApplicationHistoryResp [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", applicationHistorDTO=" + applicationHistorDTO + "]";
	}

}
