package com.jcboe.home.instruction.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ExceptionResponseTest {

	@Test
	public void testDefaultConstructor() {
		ExceptionResponse response = new ExceptionResponse();
		assertNotNull(response);
	}

	@Test
	public void testParameterizedConstructor() {
		String timeStamp = "2026-08-08T12:30:00";
		String error = "Bad Request";
		String message = "Invalid request";
		String status = "400";
		ExceptionResponse response = new ExceptionResponse(timeStamp, error, message, status);
		assertEquals(timeStamp, response.getTimeStamp());
		assertEquals(error, response.getError());
		assertEquals(message, response.getMessage());
		assertEquals(status, response.getStatus());
	}

	@Test
	public void testSettersAndGetters() {
		ExceptionResponse response = new ExceptionResponse();
		response.setTimeStamp("2026-08-08T13:00:00");
		response.setError("Internal Server Error");
		response.setMessage("Something went wrong");
		response.setStatus("500");
		assertEquals("2026-08-08T13:00:00", response.getTimeStamp());
		assertEquals("Internal Server Error", response.getError());
		assertEquals("Something went wrong", response.getMessage());
		assertEquals("500", response.getStatus());
	}

	@Test
	void testToString() {
		ExceptionResponse response = new ExceptionResponse();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, response.toString());
	}

}
