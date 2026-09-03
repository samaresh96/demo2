package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailResponseTest {

	@Test
	void testDefaultConstructor() {
		EmailResponse response = new EmailResponse();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		EmailResponse response = new EmailResponse("student@test.com", "01-01-2010", "2026-01-01");

		assertEquals("student@test.com", response.getStudentEmailId());
		assertEquals("01-01-2010", response.getStudentDob());
		assertEquals("2026-01-01", response.getOtpSendOn());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		EmailResponse response = new EmailResponse();

		response.setStudentEmailId("test@test.com");
		response.setStudentDob("02-02-2012");
		response.setOtpSendOn("2026-02-01");

		assertEquals("test@test.com", response.getStudentEmailId());
		assertEquals("02-02-2012", response.getStudentDob());
		assertEquals("2026-02-01", response.getOtpSendOn());
	}

	@Test
	void testToString() {

		EmailResponse response = new EmailResponse("email@test.com", "03-03-2013", "2026-03-01");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("EmailResponse"));
		assertTrue(result.contains("email@test.com"));
	}
}