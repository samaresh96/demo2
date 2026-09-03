/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form1AphirResp {

	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private long form1AphirDataId;
	private Long applicationId;
	private String applicationNumber;
	private String applicationStatus;
	private String applicationStatusAbbrev;
	private Long formTransactionId;

	public Form1AphirResp() {
	}

	public Form1AphirResp(boolean success, String message, String accessedOn, long form1AphirDataId) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form1AphirDataId = form1AphirDataId;
	}

	public Form1AphirResp(boolean success, String message, String accessedOn, long form1AphirDataId, Long applicationId,
			String applicationNumber, String applicationStatus, String applicationStatusAbbrev,
			Long formTransactionId) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.form1AphirDataId = form1AphirDataId;
		this.applicationId = applicationId;
		this.applicationNumber = applicationNumber;
		this.applicationStatus = applicationStatus;
		this.applicationStatusAbbrev = applicationStatusAbbrev;
		this.formTransactionId = formTransactionId;
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

	public long getForm1AphirDataId() {
		return form1AphirDataId;
	}

	public void setForm1AphirDataId(long form1AphirDataId) {
		this.form1AphirDataId = form1AphirDataId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
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

	public Long getFormTransactionId() {
		return formTransactionId;
	}

	public void setFormTransactionId(Long formTransactionId) {
		this.formTransactionId = formTransactionId;
	}

	@Override
	public String toString() {
		return "Form1AphirResp [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", form1AphirDataId=" + form1AphirDataId + ", applicationId=" + applicationId + ", applicationNumber="
				+ applicationNumber + ", applicationStatus=" + applicationStatus + ", applicationStatusAbbrev="
				+ applicationStatusAbbrev + ", formTransactionId=" + formTransactionId + "]";
	}

}
