/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form3RhiltResp {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private long id;
	private List<HIFormTransactionResp> attachmentList;

	public Form3RhiltResp() {

	}

	public Form3RhiltResp(boolean success, String message, String accessedOn, long id,
			List<HIFormTransactionResp> attachmentList) {

		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<HIFormTransactionResp> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<HIFormTransactionResp> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "Form3RhiltResp [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn + ", id="
				+ id + ", attachmentList=" + attachmentList + "]";
	}

}
