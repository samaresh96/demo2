/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;


public class ApplicationSummaryResp {

	private String statusAbbreviation;
	private String statusName;
	private Long applicationCount;

	public ApplicationSummaryResp() {

	}

	public ApplicationSummaryResp(String statusAbbreviation, String statusName, Long applicationCount) {

		this.statusAbbreviation = statusAbbreviation;
		this.statusName = statusName;
		this.applicationCount = applicationCount;
	}

	public String getStatusAbbreviation() {
		return statusAbbreviation;
	}

	public void setStatusAbbreviation(String statusAbbreviation) {
		this.statusAbbreviation = statusAbbreviation;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Long getApplicationCount() {
		return applicationCount;
	}

	public void setApplicationCount(Long applicationCount) {
		this.applicationCount = applicationCount;
	}

	@Override
	public String toString() {
		return "ApplicationSummaryResp [statusAbbreviation=" + statusAbbreviation + ", statusName=" + statusName
				+ ", applicationCount=" + applicationCount + "]";
	}

}
