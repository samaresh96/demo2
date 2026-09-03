package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ParentLogInReqTest {

	@Test
	void testParameterizedConstructorAndGetters() {

		ParentLogInReq request = new ParentLogInReq("STU001", "01-01-2010", "CONFIG_KEY", "123456", "password",
				"LOGIN");

		assertEquals("STU001", request.getStudentId());
		assertEquals("01-01-2010", request.getStudentDob());
		assertEquals("CONFIG_KEY", request.getConfigKeys());
		assertEquals("123456", request.getOtpCode());
		assertEquals("password", request.getStudentPw());
		assertEquals("LOGIN", request.getIndicator());
	}

	@Test
	void testSetters() {

		ParentLogInReq request = new ParentLogInReq();

		request.setStudentId("STU002");
		request.setStudentDob("02-02-2011");
		request.setConfigKeys("APP_CONFIG");
		request.setOtpCode("654321");
		request.setStudentPw("pwd123");
		request.setIndicator("VERIFY");

		assertEquals("STU002", request.getStudentId());
		assertEquals("02-02-2011", request.getStudentDob());
		assertEquals("APP_CONFIG", request.getConfigKeys());
		assertEquals("654321", request.getOtpCode());
		assertEquals("pwd123", request.getStudentPw());
		assertEquals("VERIFY", request.getIndicator());
	}

	@Test
	void testDefaultConstructor() {

		ParentLogInReq request = new ParentLogInReq();

		assertNull(request.getStudentId());
		assertNull(request.getStudentDob());
		assertNull(request.getConfigKeys());
		assertNull(request.getOtpCode());
		assertNull(request.getStudentPw());
		assertNull(request.getIndicator());
	}

	@Test
	void testToString() {

		ParentLogInReq request = new ParentLogInReq("STU001", "01-01-2010", "CONFIG_KEY", "123456", "password",
				"LOGIN");

		String result = request.toString();

		assertNotNull(result);
		assertTrue(result.contains("STU001"));
		assertTrue(result.contains("01-01-2010"));
		assertTrue(result.contains("CONFIG_KEY"));
		assertTrue(result.contains("123456"));
		assertTrue(result.contains("password"));
		assertTrue(result.contains("LOGIN"));
	}
}