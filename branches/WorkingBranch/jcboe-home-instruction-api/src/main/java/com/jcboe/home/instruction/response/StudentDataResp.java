/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class StudentDataResp {
	private long studentId;
	private String studentName;
	private String dob;
	private String gender;
	private String age;
	private String grade;
	private int gradeId;
	private String school;
	private String schoolCode;
	private String specialEd;
	private String parentsName;
	private String emailId;
	private boolean isforgotPassword;
	private boolean isEmailVerified;

	public StudentDataResp() {
	}

	public StudentDataResp(long studentId, String studentName, String dob, String gender, String age, String grade,
			int gradeId, String school, String schoolCode, String specialEd, String parentsName, String emailId,
			boolean isforgotPassword, boolean isEmailVerified) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.dob = dob;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
		this.gradeId = gradeId;
		this.school = school;
		this.schoolCode = schoolCode;
		this.specialEd = specialEd;
		this.parentsName = parentsName;
		this.emailId = emailId;
		this.isforgotPassword = isforgotPassword;
		this.isEmailVerified = isEmailVerified;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSpecialEd() {
		return specialEd;
	}

	public void setSpecialEd(String specialEd) {
		this.specialEd = specialEd;
	}

	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isIsforgotPassword() {
		return isforgotPassword;
	}

	public void setIsforgotPassword(boolean isforgotPassword) {
		this.isforgotPassword = isforgotPassword;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	@Override
	public String toString() {
		return "StudentDataResp [studentId=" + studentId + ", studentName=" + studentName + ", dob=" + dob + ", gender="
				+ gender + ", age=" + age + ", grade=" + grade + ", gradeId=" + gradeId + ", school=" + school
				+ ", schoolCode=" + schoolCode + ", specialEd=" + specialEd + ", parentsName=" + parentsName
				+ ", emailId=" + emailId + ", isforgotPassword=" + isforgotPassword + ", isEmailVerified="
				+ isEmailVerified + "]";
	}

}
