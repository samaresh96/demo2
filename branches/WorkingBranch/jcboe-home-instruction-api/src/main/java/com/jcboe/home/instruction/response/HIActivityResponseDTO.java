/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HIActivityResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private List<NotificationList> notificationList;
	private ApplicationInfoResp applicationInfo;

	public HIActivityResponseDTO() {
	}

	public HIActivityResponseDTO(boolean success, String message, String accessedOn,
			List<NotificationList> notificationList, ApplicationInfoResp applicationInfo) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.notificationList = notificationList;
		this.applicationInfo = applicationInfo;
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

	public List<NotificationList> getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(List<NotificationList> notificationList) {
		this.notificationList = notificationList;
	}

	public ApplicationInfoResp getApplicationInfo() {
		return applicationInfo;
	}

	public void setApplicationInfo(ApplicationInfoResp applicationInfo) {
		this.applicationInfo = applicationInfo;
	}

	@Override
	public String toString() {
		return "HIActivityResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", notificationList=" + notificationList + ", applicationInfo=" + applicationInfo + "]";
	}

}
