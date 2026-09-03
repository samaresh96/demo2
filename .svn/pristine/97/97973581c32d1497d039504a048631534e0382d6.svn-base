/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationListResponseDTO {
	@JsonProperty("isSuccess")
	private boolean success;
	private String message;
	private String accessedOn;
	private Map<?, ?> configList;
	private List<LookupDetails> lookupList;
	private List<ApplicationList> applicationList;
	private long count;
	private List<AppStatusListResp> statusList;
	private List<ApplicationSummaryResp> applicationSummaryList;
	private List<SchoolResp> schoolList;
	private List<GradeListResp> gradeList;

	public ApplicationListResponseDTO() {
	}

	public ApplicationListResponseDTO(boolean success, String message, String accessedOn, Map<?, ?> configList,
			List<LookupDetails> lookupList, List<ApplicationList> applicationList, long count,
			List<AppStatusListResp> statusList, List<ApplicationSummaryResp> applicationSummaryList,
			List<SchoolResp> schoolList, List<GradeListResp> gradeList) {
		this.success = success;
		this.message = message;
		this.accessedOn = accessedOn;
		this.configList = configList;
		this.lookupList = lookupList;
		this.applicationList = applicationList;
		this.count = count;
		this.statusList = statusList;
		this.applicationSummaryList = applicationSummaryList;
		this.schoolList = schoolList;
		this.gradeList = gradeList;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccessedOn() {
		return accessedOn;
	}

	public void setAccessedOn(String accessedOn) {
		this.accessedOn = accessedOn;
	}

	public Map<?, ?> getConfigList() {
		return configList;
	}

	public void setConfigList(Map<?, ?> configList) {
		this.configList = configList;
	}

	public List<LookupDetails> getLookupList() {
		return lookupList;
	}

	public void setLookupList(List<LookupDetails> lookupList) {
		this.lookupList = lookupList;
	}

	public List<ApplicationList> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<ApplicationList> applicationList) {
		this.applicationList = applicationList;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<AppStatusListResp> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<AppStatusListResp> statusList) {
		this.statusList = statusList;
	}

	public List<ApplicationSummaryResp> getApplicationSummaryList() {
		return applicationSummaryList;
	}

	public void setApplicationSummaryList(List<ApplicationSummaryResp> applicationSummaryList) {
		this.applicationSummaryList = applicationSummaryList;
	}

	public List<SchoolResp> getSchoolList() {
		return schoolList;
	}

	public void setSchoolList(List<SchoolResp> schoolList) {
		this.schoolList = schoolList;
	}

	public List<GradeListResp> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<GradeListResp> gradeList) {
		this.gradeList = gradeList;
	}

	@Override
	public String toString() {
		return "ApplicationListResponseDTO [success=" + success + ", message=" + message + ", accessedOn=" + accessedOn
				+ ", configList=" + configList + ", lookupList=" + lookupList + ", applicationList=" + applicationList
				+ ", count=" + count + ", statusList=" + statusList + ", applicationSummaryList="
				+ applicationSummaryList + ", schoolList=" + schoolList + ", gradeList=" + gradeList + "]";
	}

}
