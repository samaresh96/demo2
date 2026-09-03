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
 * Date: 01-July-2023 Class: EmpNameNEmailResp.java Purpose: use as a model
 * 
 * 
 */

@JsonPropertyOrder({ "isSuccess", "message", "emil", "name" })
public class EmpNameNEmailResp {

	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	@JsonProperty("email")
	private String emil;
	private String name;

	public EmpNameNEmailResp(boolean success, String message, String emil, String name) {
		this.success = success;
		this.message = message;
		this.emil = emil;
		this.name = name;
	}

	public EmpNameNEmailResp(String emil, String name) {
		this.emil = emil;
		this.name = name;
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

	public String getEmil() {
		return emil;
	}

	public void setEmil(String emil) {
		this.emil = emil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmpNameNEmailResp [success=" + success + ", message=" + message + ", emil=" + emil + ", name=" + name
				+ "]";
	}

}
