/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateHIActivityReq {
	private Long applicationId;
	private String activity;
	private String status;
	private String comment;
	private String actionTakenBy;
	private String actionTakenByPersonType;
	@JsonProperty("isApplicationInfo")
	private boolean applicationInfo;

	public UpdateHIActivityReq() {
	}

	public UpdateHIActivityReq(Long applicationId, String activity, String status, String comment, String actionTakenBy,
			String actionTakenByPersonType, boolean applicationInfo) {
		this.applicationId = applicationId;
		this.activity = activity;
		this.status = status;
		this.comment = comment;
		this.actionTakenBy = actionTakenBy;
		this.actionTakenByPersonType = actionTakenByPersonType;
		this.applicationInfo = applicationInfo;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getActionTakenBy() {
		return actionTakenBy;
	}

	public void setActionTakenBy(String actionTakenBy) {
		this.actionTakenBy = actionTakenBy;
	}

	public String getActionTakenByPersonType() {
		return actionTakenByPersonType;
	}

	public void setActionTakenByPersonType(String actionTakenByPersonType) {
		this.actionTakenByPersonType = actionTakenByPersonType;
	}

	public boolean isApplicationInfo() {
		return applicationInfo;
	}

	public void setApplicationInfo(boolean applicationInfo) {
		this.applicationInfo = applicationInfo;
	}

	@Override
	public String toString() {
		return "UpdateHIActivityReq [applicationId=" + applicationId + ", activity=" + activity + ", status=" + status
				+ ", comment=" + comment + ", actionTakenBy=" + actionTakenBy + ", actionTakenByPersonType="
				+ actionTakenByPersonType + ", applicationInfo=" + applicationInfo + "]";
	}

}
