/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentLoginResp {
	private boolean valid;
	private int statusCode;
	@JsonProperty("loggedInUserId")
	private long loggedInUserId;
	@JsonProperty("loggedInUserName")
	private String loggedInUserName;
	private String currentYear;
	private String previousYear;
	private String currentYearAbbr;
	private String previousYearAbbr;
	private String emailId;
	@JsonProperty("isSamePassword")
	private boolean samePassword;

	public ParentLoginResp() {
	}

	public ParentLoginResp(boolean valid, int statusCode, long loggedInUserId, String loggedInUserName, String emailId,
			boolean samePassword) {
		this.valid = valid;
		this.statusCode = statusCode;
		this.loggedInUserId = loggedInUserId;
		this.loggedInUserName = loggedInUserName;
		this.emailId = emailId;
		this.samePassword = samePassword;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int resultCode) {
		this.statusCode = resultCode;
	}

	public long getLoggedInUserId() {
		return loggedInUserId;
	}

	public void setLoggedInUserId(long loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	public String getLoggedInUserName() {
		return loggedInUserName;
	}

	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getPreviousYear() {
		return previousYear;
	}

	public void setPreviousYear(String previousYear) {
		this.previousYear = previousYear;
	}

	public String getCurrentYearAbbr() {
		return currentYearAbbr;
	}

	public void setCurrentYearAbbr(String currentYearAbbr) {
		this.currentYearAbbr = currentYearAbbr;
	}

	public String getPreviousYearAbbr() {
		return previousYearAbbr;
	}

	public void setPreviousYearAbbr(String previousYearAbbr) {
		this.previousYearAbbr = previousYearAbbr;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isSamePassword() {
		return samePassword;
	}

	public void setSamePassword(boolean samePassword) {
		this.samePassword = samePassword;
	}

	@Override
	public String toString() {
		return "ParentLoginResp [valid=" + valid + ", statusCode=" + statusCode + ", loggedInUserId=" + loggedInUserId
				+ ", loggedInUserName=" + loggedInUserName + ", currentYear=" + currentYear + ", previousYear="
				+ previousYear + ", currentYearAbbr=" + currentYearAbbr + ", previousYearAbbr=" + previousYearAbbr
				+ ", emailId=" + emailId + ", samePassword=" + samePassword + "]";
	}

}
