/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 
 * Date: 26-May-2023 Class: UserLoginRequest.java Purpose:UserLoginRequest model
 *
 */

public class UserLoginRequest implements Serializable {

	private static final long serialVersionUID = 4316654602858680585L;

	@JsonProperty("userID")
	private String userId;
	private String userType;
	@JsonProperty("applicationID")
	private String applicationId;
	private String userPassword;
	private String applicationIndicator;
	@JsonProperty("isGetPassword")
	private boolean getPassword;

	private String type;
	private String loginName;
	private String loginPassword;

	private String calledFrom;
	private String configKeys;

	public UserLoginRequest() {
	}

	public UserLoginRequest(String userId, String userType, String applicationId, String userPassword,
			String applicationIndicator, boolean getPassword) {
		this.userId = userId;
		this.userType = userType;
		this.applicationId = applicationId;
		this.userPassword = userPassword;
		this.applicationIndicator = applicationIndicator;
		this.getPassword = getPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getApplicationIndicator() {
		return applicationIndicator;
	}

	public void setApplicationIndicator(String applicationIndicator) {
		this.applicationIndicator = applicationIndicator;
	}

	public boolean isGetPassword() {
		return getPassword;
	}

	public void setGetPassword(boolean getPassword) {
		this.getPassword = getPassword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getCalledFrom() {
		return calledFrom;
	}

	public void setCalledFrom(String calledFrom) {
		this.calledFrom = calledFrom;
	}

	public String getConfigKeys() {
		return configKeys;
	}

	public void setConfigKeys(String configKeys) {
		this.configKeys = configKeys;
	}

	@Override
	public String toString() {
		return "UserLoginRequest [userId=" + userId + ", userType=" + userType + ", applicationId=" + applicationId
				+ ", userPassword=" + userPassword + ", applicationIndicator=" + applicationIndicator + ", getPassword="
				+ getPassword + ", type=" + type + ", loginName=" + loginName + ", loginPassword=" + loginPassword
				+ ", calledFrom=" + calledFrom + ", configKeys=" + configKeys + "]";
	}

}
