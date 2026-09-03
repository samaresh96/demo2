/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

public class GetLogDataReq {
	String functionName;
	String error;
	String dateTime;
	String errorFrom;

	public GetLogDataReq() {

	}

	public GetLogDataReq(String functionName, String error, String dateTime, String errorFrom) {

		this.functionName = functionName;
		this.error = error;
		this.dateTime = dateTime;
		this.errorFrom = errorFrom;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getErrorFrom() {
		return errorFrom;
	}

	public void setErrorFrom(String errorFrom) {
		this.errorFrom = errorFrom;
	}

	@Override
	public String toString() {
		return "GetLogDataReq [functionName=" + functionName + ", error=" + error + ", dateTime=" + dateTime
				+ ", errorFrom=" + errorFrom + "]";
	}

}
