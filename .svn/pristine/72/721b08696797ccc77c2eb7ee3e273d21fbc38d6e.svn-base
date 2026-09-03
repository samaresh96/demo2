package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AdminLoginRespTest {

	@Test
	void testDefaultConstructorAndSetters() {

		AdminLoginResp response = new AdminLoginResp();

		response.setValid(true);
		response.setStatusCode(200);
		response.setLoggedInUserId(1001L);
		response.setLoggedInUserName("admin");
		response.setLoggedInUserType("SYSTEM_ADMIN");
		response.setCurrentYear("2025");
		response.setPreviousYear("2024");
		response.setCurrentYearAbbr("25");
		response.setPreviousYearAbbr("24");
		response.setSystemAdmin(true);

		assertTrue(response.isValid());
		assertEquals(200, response.getStatusCode());
		assertEquals(1001L, response.getLoggedInUserId());
		assertEquals("admin", response.getLoggedInUserName());
		assertEquals("SYSTEM_ADMIN", response.getLoggedInUserType());
		assertEquals("2025", response.getCurrentYear());
		assertEquals("2024", response.getPreviousYear());
		assertEquals("25", response.getCurrentYearAbbr());
		assertEquals("24", response.getPreviousYearAbbr());
		assertTrue(response.isSystemAdmin());
	}

	@Test
	void testParameterizedConstructor() {

		AdminLoginResp response = new AdminLoginResp(true, 200, 1001L, "admin", "SYSTEM_ADMIN");

		assertTrue(response.isValid());
		assertEquals(200, response.getStatusCode());
		assertEquals(1001L, response.getLoggedInUserId());
		assertEquals("admin", response.getLoggedInUserName());
		assertEquals("SYSTEM_ADMIN", response.getLoggedInUserType());
	}

	@Test
	void testBooleanSetters() {

		AdminLoginResp response = new AdminLoginResp();

		response.setValid(false);
		response.setSystemAdmin(false);

		assertFalse(response.isValid());
		assertFalse(response.isSystemAdmin());
	}

	@Test
	void testToString() {

		AdminLoginResp response = new AdminLoginResp();

		response.setLoggedInUserId(1001L);
		response.setLoggedInUserName("admin");
		response.setStatusCode(200);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("loggedInUserId=1001"));
		assertTrue(result.contains("loggedInUserName=admin"));
		assertTrue(result.contains("statusCode=200"));
	}
}