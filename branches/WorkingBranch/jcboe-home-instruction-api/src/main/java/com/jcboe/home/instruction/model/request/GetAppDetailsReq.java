/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

public class GetAppDetailsReq {

	private String configKeys;
	private String lookupType;
	private String schoolYear;
	private int pagesize;
	private int pagenumber;

	public GetAppDetailsReq() {
	}

	public GetAppDetailsReq(String configKeys, String lookupType, String schoolYear, int pagesize, int pagenumber) {
		this.configKeys = configKeys;
		this.lookupType = lookupType;
		this.schoolYear = schoolYear;
		this.pagesize = pagesize;
		this.pagenumber = pagenumber;
	}

	public String getConfigKeys() {
		return configKeys;
	}

	public void setConfigKeys(String configKeys) {
		this.configKeys = configKeys;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}

	@Override
	public String toString() {
		return "GetAppDetailsReq [configKeys=" + configKeys + ", lookupType=" + lookupType + ", schoolYear="
				+ schoolYear + ", pagesize=" + pagesize + ", pagenumber=" + pagenumber + "]";
	}

}
