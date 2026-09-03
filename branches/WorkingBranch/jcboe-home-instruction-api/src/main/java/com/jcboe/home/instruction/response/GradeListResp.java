/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GradeListResp {
	@JsonProperty("gradeID")
	private int gradeId;
	private String grade;

	public GradeListResp() {

	}

	public GradeListResp(int gradeId, String grade) {

		this.gradeId = gradeId;
		this.grade = grade;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "GradeListResp [gradeId=" + gradeId + ", grade=" + grade + "]";
	}

}
