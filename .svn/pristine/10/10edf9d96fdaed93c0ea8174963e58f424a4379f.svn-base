/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStudentParentInfoResp {

	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private List<StudentDataResp> studentInfoList;
	private Map<?, ?> configList;

	public GetStudentParentInfoResp() {
	}

	public GetStudentParentInfoResp(boolean success, String message, String accessedOn,
			List<StudentDataResp> studentInfoList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.studentInfoList = studentInfoList;
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

	public List<StudentDataResp> getStudentInfoList() {
		return studentInfoList;
	}

	public void setStudentInfoList(List<StudentDataResp> studentInfoList) {
		this.studentInfoList = studentInfoList;
	}

	public Map<?, ?> getConfigList() {
		return configList;
	}

	public void setConfigList(Map<?, ?> configList) {
		this.configList = configList;
	}

	@Override
	public String toString() {
		return "GetStudentParentInfoResp [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", studentInfoList=" + studentInfoList + ", configList=" + configList + "]";
	}

}
