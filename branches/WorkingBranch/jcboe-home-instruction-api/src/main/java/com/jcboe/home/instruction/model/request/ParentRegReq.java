/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ParentRegReq {
	private String studentId;
	private String studentDob;
	private String parentName;
	private String emailId;
	private String parentPw;
	private String regCode;
	private String indicator;
	@JsonIgnore
	private boolean samePassword;

	public ParentRegReq() {
	}

	public ParentRegReq(String studentId, String studentDob, String parentName, String emailId, String parentPw,
			String regCode, String indicator) {
		this.studentId = studentId;
		this.studentDob = studentDob;
		this.parentName = parentName;
		this.emailId = emailId;
		this.parentPw = parentPw;
		this.regCode = regCode;
		this.indicator = indicator;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getParentPw() {
		return parentPw;
	}

	public void setParentPw(String parentPw) {
		this.parentPw = parentPw;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public boolean isSamePassword() {
		return samePassword;
	}

	public void setSamePassword(boolean samePassword) {
		this.samePassword = samePassword;
	}

	@Override
	public String toString() {
		return "ParentRegReq [studentId=" + studentId + ", studentDob=" + studentDob + ", parentName=" + parentName
				+ ", emailId=" + emailId + ", parentPw=" + parentPw + ", regCode=" + regCode + ", indicator="
				+ indicator + ", samePassword=" + samePassword + "]";
	}

}
