/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class GetPhysicianInfoResp {
	private String physicianName;
	private String physicianSignDate;

	public GetPhysicianInfoResp() {
	}

	public GetPhysicianInfoResp(String physicianName, String physicianSignDate) {
		this.physicianName = physicianName;
		this.physicianSignDate = physicianSignDate;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPhysicianSignDate() {
		return physicianSignDate;
	}

	public void setPhysicianSignDate(String physicianSignDate) {
		this.physicianSignDate = physicianSignDate;
	}

	@Override
	public String toString() {
		return "GetPhysicianInfoResp [physicianName=" + physicianName + ", physicianSignDate=" + physicianSignDate
				+ "]";
	}

}
