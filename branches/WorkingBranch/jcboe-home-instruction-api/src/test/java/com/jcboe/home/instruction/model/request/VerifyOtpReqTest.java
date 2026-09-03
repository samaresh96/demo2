package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VerifyOtpReqTest {

	@Test
	void testVerifyOtpReqConstructorAndMethods() {

		VerifyOtpReq request = new VerifyOtpReq("STU123", "987654");

		assertEquals("STU123", request.getStudentId());
		assertEquals("987654", request.getOtp());

		request.setStudentId("STU456");
		request.setOtp("123456");

		assertEquals("STU456", request.getStudentId());
		assertEquals("123456", request.getOtp());

		assertNotNull(request.toString());
		assertTrue(request.toString().contains("studentId=STU456"));
		assertTrue(request.toString().contains("otp=123456"));
	}

	@Test
	void testDefaultConstructor() {

		VerifyOtpReq request = new VerifyOtpReq();

		assertNotNull(request);

		assertNull(request.getStudentId());
		assertNull(request.getOtp());
	}
}