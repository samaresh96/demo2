package com.jcboe.home.instruction.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class HomeInstructionExceptionTest {

	@Test
	void testConstructorWithoutCause() {

		String errorMessage = "Something went wrong";
		String errorCode = "ERR001";

		HomeInstructionException exception = new HomeInstructionException(errorMessage, errorCode);

		assertEquals(errorMessage, exception.getMessage());
		assertEquals(errorMessage, exception.getErrorMessage());
		assertEquals(errorCode, exception.getErrorCode());
	}

	@Test
	void testConstructorWithCause() {

		String errorMessage = "Database error";
		String errorCode = "ERR002";
		Throwable cause = new RuntimeException("Connection failed");

		HomeInstructionException exception = new HomeInstructionException(errorMessage, errorCode, cause);

		assertEquals(errorMessage, exception.getMessage());
		assertEquals(errorMessage, exception.getErrorMessage());
		assertEquals(errorCode, exception.getErrorCode());
		assertSame(cause, exception.getCause());
	}

	@Test
	void testToString() {

		String errorMessage = "Something went wrong";
		String errorCode = "ERR001";

		HomeInstructionException exception = new HomeInstructionException(errorMessage, errorCode);

		String result = exception.toString();

		assertNotNull(result);
		assertEquals("HomeInstructionException [errorCode=ERR001, errorMessage=Something went wrong]", result);
	}
}