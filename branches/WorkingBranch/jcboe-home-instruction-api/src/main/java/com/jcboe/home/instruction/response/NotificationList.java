/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;

public class NotificationList {

	private Long id;
	private String title;
	private String respondActivity;
	private List<NotificationDetailsResp> notificationDetails;

	public NotificationList() {
	}

	public NotificationList(Long id, String title, String respondActivity,
			List<NotificationDetailsResp> notificationDetails) {
		this.id = id;
		this.title = title;
		this.respondActivity = respondActivity;
		this.notificationDetails = notificationDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRespondActivity() {
		return respondActivity;
	}

	public void setRespondActivity(String respondActivity) {
		this.respondActivity = respondActivity;
	}

	public List<NotificationDetailsResp> getNotificationDetails() {
		return notificationDetails;
	}

	public void setNotificationDetails(List<NotificationDetailsResp> notificationDetails) {
		this.notificationDetails = notificationDetails;
	}

	@Override
	public String toString() {
		return "NotificationList [id=" + id + ", title=" + title + ", respondActivity=" + respondActivity
				+ ", notificationDetails=" + notificationDetails + "]";
	}

}
