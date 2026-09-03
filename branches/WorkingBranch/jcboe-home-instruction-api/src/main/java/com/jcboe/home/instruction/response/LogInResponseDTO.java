/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogInResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Map<?, ?> configList;
	private List<?> records;
	@JsonProperty("isValidCode")
	private boolean validCode;
	private List<StudentDataResp> studentListResp;
	@JsonProperty("isSamePassword")
	private boolean samePassword;

	public LogInResponseDTO() {
	}

	public LogInResponseDTO(boolean success, String message, String accessedOn, Map<?, ?> configList, List<?> records,
			boolean validCode) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.configList = configList;
		this.records = records;
		this.validCode = validCode;
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

	public Map<?, ?> getConfigList() {
		return configList;
	}

	public void setConfigList(Map<?, ?> configList) {
		this.configList = configList;
	}

	public List<?> getRecords() {
		return records;
	}

	public void setRecords(List<?> records) {
		this.records = records;
	}

	public boolean isValidCode() {
		return validCode;
	}

	public void setValidCode(boolean validCode) {
		this.validCode = validCode;
	}

	public List<StudentDataResp> getStudentListResp() {
		return studentListResp;
	}

	public void setStudentListResp(List<StudentDataResp> studentListResp) {
		this.studentListResp = studentListResp;
	}

	public boolean isSamePassword() {
		return samePassword;
	}

	public void setSamePassword(boolean samePassword) {
		this.samePassword = samePassword;
	}

	@Override
	public String toString() {
		return "LogInResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", configList=" + configList + ", records=" + records + ", validCode=" + validCode
				+ ", studentListResp=" + studentListResp + ", samePassword=" + samePassword + "]";
	}

}
