package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ParentLoginRespTest {

	@Test
	void testDefaultConstructorAndSetters() {

		ParentLoginResp response = new ParentLoginResp();

		response.setValid(true);
		response.setStatusCode(200);
		response.setLoggedInUserId(1001L);
		response.setLoggedInUserName("parentUser");
		response.setCurrentYear("2025");
		response.setPreviousYear("2024");
		response.setCurrentYearAbbr("25");
		response.setPreviousYearAbbr("24");
		response.setEmailId("parent@test.com");
		response.setSamePassword(true);

		assertTrue(response.isValid());
		assertEquals(200, response.getStatusCode());
		assertEquals(1001L, response.getLoggedInUserId());
		assertEquals("parentUser", response.getLoggedInUserName());
		assertEquals("2025", response.getCurrentYear());
		assertEquals("2024", response.getPreviousYear());
		assertEquals("25", response.getCurrentYearAbbr());
		assertEquals("24", response.getPreviousYearAbbr());
		assertEquals("parent@test.com", response.getEmailId());
		assertTrue(response.isSamePassword());
	}

	@Test
	void testParameterizedConstructor() {

		ParentLoginResp response = new ParentLoginResp(true, 200, 1001L, "parentUser", "parent@test.com", true);

		assertTrue(response.isValid());
		assertEquals(200, response.getStatusCode());
		assertEquals(1001L, response.getLoggedInUserId());
		assertEquals("parentUser", response.getLoggedInUserName());
		assertEquals("parent@test.com", response.getEmailId());
		assertTrue(response.isSamePassword());
	}

	@Test
	void testBooleanSetters() {

		ParentLoginResp response = new ParentLoginResp();

		response.setValid(false);
		response.setSamePassword(false);

		assertFalse(response.isValid());
		assertFalse(response.isSamePassword());
	}

	@Test
	void testToString() {

		ParentLoginResp response = new ParentLoginResp();

		response.setLoggedInUserId(1001L);
		response.setLoggedInUserName("parentUser");
		response.setEmailId("parent@test.com");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("loggedInUserId=1001"));
		assertTrue(result.contains("loggedInUserName=parentUser"));
		assertTrue(result.contains("emailId=parent@test.com"));
	}
}