/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignTeacherResponse {

	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;

	public AssignTeacherResponse() {
	}

	public AssignTeacherResponse(boolean success, String message, String accessedOn) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
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

	@Override
	public String toString() {
		return "AssignTeacherResponse [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ "]";
	}

}
