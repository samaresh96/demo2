/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class NotificationDetailsResp {
	private String requestedOn;
	private String comment;
	private Long requestedBy;
	private String requestedByName;
	private String activity;

	public NotificationDetailsResp() {
	}

	public NotificationDetailsResp(String requestedOn, String comment, Long requestedBy, String requestedByName,
			String activity) {
		this.requestedOn = requestedOn;
		this.comment = comment;
		this.requestedBy = requestedBy;
		this.requestedByName = requestedByName;
		this.activity = activity;
	}

	public String getRequestedOn() {
		return requestedOn;
	}

	public void setRequestedOn(String requestedOn) {
		this.requestedOn = requestedOn;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(Long requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getRequestedByName() {
		return requestedByName;
	}

	public void setRequestedByName(String requestedByName) {
		this.requestedByName = requestedByName;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "NotificationDetailsResp [requestedOn=" + requestedOn + ", comment=" + comment + ", requestedBy="
				+ requestedBy + ", requestedByName=" + requestedByName + ", activity=" + activity + "]";
	}

}
