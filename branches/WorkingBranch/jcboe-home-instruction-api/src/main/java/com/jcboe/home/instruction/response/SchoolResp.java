/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class SchoolResp {

	private long schoolId;
	private String schoolCode;
	private String schoolName;

	public SchoolResp() {

	}

	public SchoolResp(long schoolId, String schoolCode, String schoolName) {

		this.schoolId = schoolId;
		this.schoolCode = schoolCode;
		this.schoolName = schoolName;
	}

	public long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return "SchoolResp [schoolId=" + schoolId + ", schoolCode=" + schoolCode + ", schoolName=" + schoolName + "]";
	}

}
