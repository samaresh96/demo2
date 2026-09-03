/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileUploadResp {
	@JsonProperty("isSuccess")
	private boolean isSuccess;
	private String message;
	private Long transactionId;
	private String updatedOn;
	private Long applicationId;
	private String applicationNo;
	private String applicationStatus;
	private String applicationStatusAbbrev;
	private List<HIFormTransactionResp> attachmentList;

	public FileUploadResp() {
	}

	public FileUploadResp(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getApplicationStatusAbbrev() {
		return applicationStatusAbbrev;
	}

	public void setApplicationStatusAbbrev(String applicationStatusAbbrev) {
		this.applicationStatusAbbrev = applicationStatusAbbrev;
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

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<HIFormTransactionResp> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<HIFormTransactionResp> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "FileUploadResp [isSuccess=" + isSuccess + ", message=" + message + ", transactionId=" + transactionId
				+ ", updatedOn=" + updatedOn + ", applicationId=" + applicationId + ", applicationNo=" + applicationNo
				+ ", applicationStatus=" + applicationStatus + ", applicationStatusAbbrev=" + applicationStatusAbbrev
				+ ", attachmentList=" + attachmentList + "]";
	}

}
