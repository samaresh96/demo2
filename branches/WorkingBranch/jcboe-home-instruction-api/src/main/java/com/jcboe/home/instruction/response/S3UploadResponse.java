/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "isSuccess", "message", "guid", "uploadLocation" })
public class S3UploadResponse {

	@JsonProperty("isSuccess")
	private boolean isSuccess;
	private String message;
	@JsonAlias(value = { "uploadedFileName" })
	private String guid;
	private String uploadLocation;
	private int studentRegistrationDocumetId;

	@JsonProperty("isFileRestrictedMsg")
	private boolean fileRestrictedMsg;

	public S3UploadResponse() {

	}

	public S3UploadResponse(boolean isSuccess, String message, String guid, String uploadLocation,
			int studentRegistrationDocumetId, boolean fileRestrictedMsg) {

		this.isSuccess = isSuccess;
		this.message = message;
		this.guid = guid;
		this.uploadLocation = uploadLocation;
		this.studentRegistrationDocumetId = studentRegistrationDocumetId;
		this.fileRestrictedMsg = fileRestrictedMsg;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getUploadLocation() {
		return uploadLocation;
	}

	public void setUploadLocation(String uploadLocation) {
		this.uploadLocation = uploadLocation;
	}

	public int getStudentRegistrationDocumetId() {
		return studentRegistrationDocumetId;
	}

	public void setStudentRegistrationDocumetId(int studentRegistrationDocumetId) {
		this.studentRegistrationDocumetId = studentRegistrationDocumetId;
	}

	public boolean isFileRestrictedMsg() {
		return fileRestrictedMsg;
	}

	public void setFileRestrictedMsg(boolean fileRestrictedMsg) {
		this.fileRestrictedMsg = fileRestrictedMsg;
	}

	@Override
	public String toString() {
		return "S3UploadResponse [isSuccess=" + isSuccess + ", message=" + message + ", guid=" + guid
				+ ", uploadLocation=" + uploadLocation + ", studentRegistrationDocumetId="
				+ studentRegistrationDocumetId + ", fileRestrictedMsg=" + fileRestrictedMsg + "]";
	}

}
