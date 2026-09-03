/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * 
 * Date: 26-May-2023 Class: UsrLoginResponse.java Purpose:UsrLoginResponse model
 *
 */

@JsonPropertyOrder({ "isSuccess", "message", "generatedLink" })
public class UsrLoginResponse {

	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String generatedLink;
	private UserDetailDTO userDetail;

	public UsrLoginResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public UsrLoginResponse(boolean success, String message, String generatedLink) {
		this.success = success;
		this.message = message;
		this.generatedLink = generatedLink;
	}

	public UsrLoginResponse(boolean success, String message, String generatedLink, UserDetailDTO userDetail) {
		this.success = success;
		this.message = message;
		this.generatedLink = generatedLink;
		this.userDetail = userDetail;
	}

	public UsrLoginResponse() {
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getGeneratedLink() {
		return generatedLink;
	}

	public void setGeneratedLink(String generatedLink) {
		this.generatedLink = generatedLink;
	}

	public UserDetailDTO getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetailDTO userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "UsrLoginResponse [success=" + success + ", message=" + message + ", generatedLink=" + generatedLink
				+ ", userDetail=" + userDetail + "]";
	}

}
