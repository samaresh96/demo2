/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class Form1AphirScheduleResp {
	private Long id;
	private Long form1APHIRDataId;
	private String subject;
	private String mp1;
	private String mp2;
	private String mp3;
	private String mp4;
	private String scheduleType;

	public Form1AphirScheduleResp() {
	}

	public Form1AphirScheduleResp(Long id, Long form1APHIRDataId, String subject, String mp1, String mp2, String mp3,
			String mp4, String scheduleType) {
		this.id = id;
		this.form1APHIRDataId = form1APHIRDataId;
		this.subject = subject;
		this.mp1 = mp1;
		this.mp2 = mp2;
		this.mp3 = mp3;
		this.mp4 = mp4;
		this.scheduleType = scheduleType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getForm1APHIRDataId() {
		return form1APHIRDataId;
	}

	public void setForm1APHIRDataId(Long form1aphirDataId) {
		form1APHIRDataId = form1aphirDataId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMp1() {
		return mp1;
	}

	public void setMp1(String mp1) {
		this.mp1 = mp1;
	}

	public String getMp2() {
		return mp2;
	}

	public void setMp2(String mp2) {
		this.mp2 = mp2;
	}

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}

	public String getMp4() {
		return mp4;
	}

	public void setMp4(String mp4) {
		this.mp4 = mp4;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	@Override
	public String toString() {
		return "Form1AphirScheduleResp [id=" + id + ", form1APHIRDataId=" + form1APHIRDataId + ", subject=" + subject
				+ ", mp1=" + mp1 + ", mp2=" + mp2 + ", mp3=" + mp3 + ", mp4=" + mp4 + ", scheduleType=" + scheduleType
				+ "]";
	}

}
