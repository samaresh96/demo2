/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "isSuccess", "message", "userName", "password", "firstName", "middleName", "lastName",
		"locationId", "location", "applicationRoleId", "appRoleAbbreviation", "appRoleName", "isRegistered" })
public class UsrNameResponse {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String userName;
	private String password;

	private String firstName;
	private String middleName;
	private String lastName;
	@JsonProperty("locationID")
	private String locationId;
	private String location;
	@JsonProperty("applicationRoleID")
	private String applicationRoleId;
	private String appRoleAbbreviation;
	private String appRoleName;
	@JsonProperty("isRegistered")
	private boolean registered;

	private long userId;
	private String programNames;
	private Map<?, ?> configList;

	public UsrNameResponse() {
	}

	public UsrNameResponse(boolean success, String userName, String password) {
		this.success = success;
		this.userName = userName;
		this.password = password;
	}

	public UsrNameResponse(String userName, String password, String firstName, String middleName, String lastName,
			String locationId, String location, String applicationRoleId, String appRoleAbbreviation,
			String appRoleName, boolean registered, long userId) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.locationId = locationId;
		this.location = location;
		this.applicationRoleId = applicationRoleId;
		this.appRoleAbbreviation = appRoleAbbreviation;
		this.appRoleName = appRoleName;
		this.registered = registered;
		this.userId = userId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAppRoleName() {
		return appRoleName;
	}

	public String getApplicationRoleId() {
		return applicationRoleId;
	}

	public void setApplicationRoleId(String applicationRoleId) {
		this.applicationRoleId = applicationRoleId;
	}

	public void setAppRoleName(String appRoleName) {
		this.appRoleName = appRoleName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAppRoleAbbreviation() {
		return appRoleAbbreviation;
	}

	public void setAppRoleAbbreviation(String appRoleAbbreviation) {
		this.appRoleAbbreviation = appRoleAbbreviation;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public String getProgramNames() {
		return programNames;
	}

	public void setProgramNames(String programNames) {
		this.programNames = programNames;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Map<?, ?> getConfigList() {
		return configList;
	}

	public void setConfigList(Map<?, ?> configList) {
		this.configList = configList;
	}

	@Override
	public String toString() {
		return "UsrNameResponse [success=" + success + ", message=" + message + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", locationId=" + locationId + ", location=" + location + ", applicationRoleId=" + applicationRoleId
				+ ", appRoleAbbreviation=" + appRoleAbbreviation + ", appRoleName=" + appRoleName + ", registered="
				+ registered + ", userId=" + userId + ", programNames=" + programNames + ", configList=" + configList
				+ "]";
	}

}
