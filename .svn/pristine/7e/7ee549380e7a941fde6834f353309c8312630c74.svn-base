package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VerifyOtpResponseTest {

	@Test
	void testDefaultConstructor() {
		VerifyOtpResponse response = new VerifyOtpResponse();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		VerifyOtpResponse response = new VerifyOtpResponse(true, "OTP Verified Successfully", "2026-01-01");

		assertTrue(response.isSuccess());
		assertEquals("OTP Verified Successfully", response.getMessage());
		assertEquals("2026-01-01", response.getAccessedOn());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		VerifyOtpResponse response = new VerifyOtpResponse();

		response.setSuccess(true);
		response.setMessage("Success");
		response.setAccessedOn("2026-01-01");

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2026-01-01", response.getAccessedOn());
	}

	@Test
	void testToString() {

		VerifyOtpResponse response = new VerifyOtpResponse(false, "Failed", "2026-02-01");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("VerifyOtpResponse"));
		assertTrue(result.contains("Failed"));
	}
}