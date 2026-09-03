/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

public class GetYearAbbrevResp {
	private String lookupValue;
	private String lookupAbbreviation;

	public GetYearAbbrevResp() {
	}

	public GetYearAbbrevResp(String lookupValue, String lookupAbbreviation) {

		this.lookupValue = lookupValue;
		this.lookupAbbreviation = lookupAbbreviation;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	public String getLookupAbbreviation() {
		return lookupAbbreviation;
	}

	public void setLookupAbbreviation(String lookupAbbreviation) {
		this.lookupAbbreviation = lookupAbbreviation;
	}

	@Override
	public String toString() {
		return "GetYearAbbrevResp [lookupValue=" + lookupValue + ", lookupAbbreviation=" + lookupAbbreviation + "]";
	}

}
