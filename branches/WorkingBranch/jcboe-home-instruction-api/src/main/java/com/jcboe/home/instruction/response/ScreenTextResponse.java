/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { "isSuccess", "message", "accessedOn", "screenTexts" })
public class ScreenTextResponse {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Map<String, String> screenTexts;

	public ScreenTextResponse() {
	}

	public ScreenTextResponse(boolean success, String message, String accessedOn, Map<String, String> screenTexts) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.screenTexts = screenTexts;
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

	public Map<String, String> getScreenTexts() {
		return screenTexts;
	}

	public void setScreenTexts(Map<String, String> screenTexts) {
		this.screenTexts = screenTexts;
	}

	@Override
	public String toString() {
		return "ScreenTextResponse [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", screenTexts=" + screenTexts + "]";
	}
}
