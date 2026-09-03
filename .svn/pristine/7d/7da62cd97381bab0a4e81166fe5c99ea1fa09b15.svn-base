/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.exception;

/*
 * 
 * Date: 03-June-2025
 * Class: PreApprovalException.java
 * Purpose: Pre Approval Exception exception throws from all over the application.
 *
 */
public class HomeInstructionException extends RuntimeException {
	private static final long serialVersionUID = 98798237498231L;
	private final String errorCode;
	private final String errorMessage;

	public HomeInstructionException(final String errorMessage, final String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public HomeInstructionException(final String errorMessage, final String errorCode, final Throwable throwable) {
		super(errorMessage, throwable);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String toString() {
		return "HomeInstructionException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
