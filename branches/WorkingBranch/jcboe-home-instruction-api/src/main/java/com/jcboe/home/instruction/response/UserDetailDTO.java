/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 
 * Date: 26-May-2023 Class: UserDetailDTO.java Purpose:UserDetailDTO model
 *
 */
public class UserDetailDTO {

	private int registeredUserID;
	@JsonProperty("loggedInUserId")
	private int userID;
	@JsonProperty("loggedInUserType")
	private String userType;
	private int oneTimeCode;
	private String registeredEmail;
	private String userPassword;
	private String otpSentOn;
	private String registeredOn;
	private boolean passwordReset;
	private boolean isActive;
	private int status;

	private int employeeId;
	private String locationId;
	private String firstName;
	private String lastName;
	private String guide;
	private String emailId;
	private String middleName;
	private int updatedBy;
	private String updatedOn;
	private String userName;

	private String appRoleAbbreviation;
	private String appRoleName;

	private long validTsCount;
	private String employeeName;
	private String workDate;
	@JsonIgnore
	private String userInfoType;
	private String phoneNumber1;
	private String phoneNumber2;

	private String currentYear;
	private String previousYear;
	private String currentYearAbbr;
	private String previousYearAbbr;

	public UserDetailDTO() {
	}

	public UserDetailDTO(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public UserDetailDTO(int registeredUserID, int userID, String userType, int oneTimeCode, String registeredEmail,
			String userPassword, String otpSentOn, String registeredOn, boolean passwordReset, boolean isActive,
			int status, int employeeId, String locationId, String firstName, String lastName, String guide,
			String emailId, String middleName, int updatedBy, String updatedOn, String appRoleAbbreviation,
			String appRoleName, String userInfoType, String phoneNumber1, String phoneNumber2) {
		this.registeredUserID = registeredUserID;
		this.userID = userID;
		this.userType = userType;
		this.oneTimeCode = oneTimeCode;
		this.registeredEmail = registeredEmail;
		this.userPassword = userPassword;
		this.otpSentOn = otpSentOn;
		this.registeredOn = registeredOn;
		this.passwordReset = passwordReset;
		this.isActive = isActive;
		this.status = status;
		this.employeeId = employeeId;
		this.locationId = locationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.guide = guide;
		this.emailId = emailId;
		this.middleName = middleName;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.appRoleAbbreviation = appRoleAbbreviation;
		this.appRoleName = appRoleName;
		this.userInfoType = userInfoType;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;

	}

	public int getRegisteredUserID() {
		return registeredUserID;
	}

	public void setRegisteredUserID(int registeredUserID) {
		this.registeredUserID = registeredUserID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getOneTimeCode() {
		return oneTimeCode;
	}

	public void setOneTimeCode(int oneTimeCode) {
		this.oneTimeCode = oneTimeCode;
	}

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getOtpSentOn() {
		return otpSentOn;
	}

	public void setOtpSentOn(String otpSentOn) {
		this.otpSentOn = otpSentOn;
	}

	public String getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(String registeredOn) {
		this.registeredOn = registeredOn;
	}

	public boolean isPasswordReset() {
		return passwordReset;
	}

	public void setPasswordReset(boolean passwordReset) {
		this.passwordReset = passwordReset;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAppRoleAbbreviation() {
		return appRoleAbbreviation;
	}

	public void setAppRoleAbbreviation(String appRoleAbbreviation) {
		this.appRoleAbbreviation = appRoleAbbreviation;
	}

	public String getAppRoleName() {
		return appRoleName;
	}

	public void setAppRoleName(String appRoleName) {
		this.appRoleName = appRoleName;
	}

	public long getValidTsCount() {
		return validTsCount;
	}

	public void setValidTsCount(long validTsCount) {
		this.validTsCount = validTsCount;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getUserInfoType() {
		return userInfoType;
	}

	public void setUserInfoType(String userInfoType) {
		this.userInfoType = userInfoType;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
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

	@Override
	public String toString() {
		return "UserDetailDTO [registeredUserID=" + registeredUserID + ", userID=" + userID + ", userType=" + userType
				+ ", oneTimeCode=" + oneTimeCode + ", registeredEmail=" + registeredEmail + ", userPassword="
				+ userPassword + ", otpSentOn=" + otpSentOn + ", registeredOn=" + registeredOn + ", passwordReset="
				+ passwordReset + ", isActive=" + isActive + ", status=" + status + ", employeeId=" + employeeId
				+ ", locationId=" + locationId + ", firstName=" + firstName + ", lastName=" + lastName + ", guide="
				+ guide + ", emailId=" + emailId + ", middleName=" + middleName + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + ", userName=" + userName + ", appRoleAbbreviation=" + appRoleAbbreviation
				+ ", appRoleName=" + appRoleName + ", validTsCount=" + validTsCount + ", employeeName=" + employeeName
				+ ", workDate=" + workDate + ", userInfoType=" + userInfoType + ", phoneNumber1=" + phoneNumber1
				+ ", phoneNumber2=" + phoneNumber2 + ", currentYear=" + currentYear + ", previousYear=" + previousYear
				+ ", currentYearAbbr=" + currentYearAbbr + ", previousYearAbbr=" + previousYearAbbr + "]";
	}

}
