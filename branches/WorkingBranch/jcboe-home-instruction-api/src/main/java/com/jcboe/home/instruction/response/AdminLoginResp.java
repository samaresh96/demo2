/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminLoginResp {
	private boolean valid;
	private int statusCode;
	@JsonProperty("loggedInUserId")
	private long loggedInUserId;
	@JsonProperty("loggedInUserName")
	private String loggedInUserName;
	@JsonProperty("loggedInUserType")
	private String loggedInUserType;
	private String currentYear;
	private String previousYear;
	private String currentYearAbbr;
	private String previousYearAbbr;
	@JsonProperty("isSystemAdmin")
	private boolean systemAdmin;

	public AdminLoginResp() {
	}

	public AdminLoginResp(boolean valid, int statusCode, long loggedInUserId, String loggedInUserName,
			String loggedInUserType) {
		this.valid = valid;
		this.statusCode = statusCode;
		this.loggedInUserId = loggedInUserId;
		this.loggedInUserName = loggedInUserName;
		this.loggedInUserType = loggedInUserType;
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

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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

	public String getLoggedInUserType() {
		return loggedInUserType;
	}

	public void setLoggedInUserType(String loggedInUserType) {
		this.loggedInUserType = loggedInUserType;
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

	public boolean isSystemAdmin() {
		return systemAdmin;
	}

	public void setSystemAdmin(boolean systemAdmin) {
		this.systemAdmin = systemAdmin;
	}

	@Override
	public String toString() {
		return "AdminLoginResp [valid=" + valid + ", statusCode=" + statusCode + ", loggedInUserId=" + loggedInUserId
				+ ", loggedInUserName=" + loggedInUserName + ", loggedInUserType=" + loggedInUserType + ", currentYear="
				+ currentYear + ", previousYear=" + previousYear + ", currentYearAbbr=" + currentYearAbbr
				+ ", previousYearAbbr=" + previousYearAbbr + ", systemAdmin=" + systemAdmin + "]";
	}

}
