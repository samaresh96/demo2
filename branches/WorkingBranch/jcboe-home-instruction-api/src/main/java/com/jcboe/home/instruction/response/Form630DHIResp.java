/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form630DHIResp {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private List<HIFormTransactionResp> attachmentList;

	public Form630DHIResp() {
	}

	public Form630DHIResp(boolean success, String message, String accessedOn,
			List<HIFormTransactionResp> attachmentList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
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

	public List<HIFormTransactionResp> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<HIFormTransactionResp> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "Form630DHIResp [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", attachmentList=" + attachmentList + "]";
	}

}
