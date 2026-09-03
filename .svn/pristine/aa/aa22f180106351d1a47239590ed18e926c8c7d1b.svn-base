package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ParentRegReqTest {

	@Test
	void testParameterizedConstructorAndGetters() {

		ParentRegReq request = new ParentRegReq("STU001", "01-01-2010", "John Parent", "parent@test.com", "password",
				"REG123", "REGISTER");

		assertEquals("STU001", request.getStudentId());
		assertEquals("01-01-2010", request.getStudentDob());
		assertEquals("John Parent", request.getParentName());
		assertEquals("parent@test.com", request.getEmailId());
		assertEquals("password", request.getParentPw());
		assertEquals("REG123", request.getRegCode());
		assertEquals("REGISTER", request.getIndicator());
	}

	@Test
	void testSetters() {

		ParentRegReq request = new ParentRegReq();

		request.setStudentId("STU002");
		request.setStudentDob("02-02-2011");
		request.setParentName("Jane Parent");
		request.setEmailId("jane@test.com");
		request.setParentPw("pwd123");
		request.setRegCode("CODE456");
		request.setIndicator("UPDATE");
		request.setSamePassword(true);

		assertEquals("STU002", request.getStudentId());
		assertEquals("02-02-2011", request.getStudentDob());
		assertEquals("Jane Parent", request.getParentName());
		assertEquals("jane@test.com", request.getEmailId());
		assertEquals("pwd123", request.getParentPw());
		assertEquals("CODE456", request.getRegCode());
		assertEquals("UPDATE", request.getIndicator());
		assertTrue(request.isSamePassword());
	}

	@Test
	void testDefaultConstructor() {

		ParentRegReq request = new ParentRegReq();

		assertNull(request.getStudentId());
		assertNull(request.getStudentDob());
		assertNull(request.getParentName());
		assertNull(request.getEmailId());
		assertNull(request.getParentPw());
		assertNull(request.getRegCode());
		assertNull(request.getIndicator());
		assertFalse(request.isSamePassword());
	}

	@Test
	void testToString() {

		ParentRegReq request = new ParentRegReq("STU001", "01-01-2010", "John Parent", "parent@test.com", "password",
				"REG123", "REGISTER");

		request.setSamePassword(true);

		String result = request.toString();

		assertNotNull(result);
		assertTrue(result.contains("STU001"));
		assertTrue(result.contains("John Parent"));
		assertTrue(result.contains("parent@test.com"));
		assertTrue(result.contains("REG123"));
		assertTrue(result.contains("samePassword=true"));
	}
}