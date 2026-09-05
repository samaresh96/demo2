/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class ApplicationHistoryDTO {
	private Long id;
	private String action;
	private String actionAbbreviation;
	private String status;
	private String statusAbbreviation;
	private String comment;
	private String actionTakenBy;
	private String actionTakenOn;
	private String actionTakenByPersonType;

	public ApplicationHistoryDTO() {
	}

	public ApplicationHistoryDTO(Long id, String action, String actionAbbreviation, String status,
			String statusAbbreviation, String comment, String actionTakenBy, String actionTakenOn,
			String actionTakenByPersonType) {
		this.id = id;
		this.action = action;
		this.actionAbbreviation = actionAbbreviation;
		this.status = status;
		this.statusAbbreviation = statusAbbreviation;
		this.comment = comment;
		this.actionTakenBy = actionTakenBy;
		this.actionTakenOn = actionTakenOn;
		this.actionTakenByPersonType = actionTakenByPersonType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionAbbreviation() {
		return actionAbbreviation;
	}

	public void setActionAbbreviation(String actionAbbreviation) {
		this.actionAbbreviation = actionAbbreviation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusAbbreviation() {
		return statusAbbreviation;
	}

	public void setStatusAbbreviation(String statusAbbreviation) {
		this.statusAbbreviation = statusAbbreviation;
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

	public String getActionTakenOn() {
		return actionTakenOn;
	}

	public void setActionTakenOn(String actionTakenOn) {
		this.actionTakenOn = actionTakenOn;
	}

	public String getActionTakenByPersonType() {
		return actionTakenByPersonType;
	}

	public void setActionTakenByPersonType(String actionTakenByPersonType) {
		this.actionTakenByPersonType = actionTakenByPersonType;
	}

	@Override
	public String toString() {
		return "ApplicationHistorDTO [id=" + id + ", action=" + action + ", actionAbbreviation=" + actionAbbreviation
				+ ", status=" + status + ", statusAbbreviation=" + statusAbbreviation + ", comment=" + comment
				+ ", actionTakenBy=" + actionTakenBy + ", actionTakenOn=" + actionTakenOn + ", actionTakenByPersonType="
				+ actionTakenByPersonType + "]";
	}

}
