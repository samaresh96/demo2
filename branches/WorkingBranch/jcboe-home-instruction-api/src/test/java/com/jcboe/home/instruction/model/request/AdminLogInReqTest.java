package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AdminLogInReqTest {

	@Test
	void testParameterizedConstructorAndGetters() {

		AdminLogInReq request = new AdminLogInReq("admin001", "password123", "CONFIG_KEY", "ADMIN");

		assertEquals("admin001", request.getUserId());
		assertEquals("password123", request.getPassword());
		assertEquals("CONFIG_KEY", request.getConfigKeys());
		assertEquals("ADMIN", request.getUserType());
	}

	@Test
	void testSetters() {

		AdminLogInReq request = new AdminLogInReq();

		request.setUserId("user001");
		request.setPassword("pwd123");
		request.setConfigKeys("APP_CONFIG");
		request.setUserType("USER");

		assertEquals("user001", request.getUserId());
		assertEquals("pwd123", request.getPassword());
		assertEquals("APP_CONFIG", request.getConfigKeys());
		assertEquals("USER", request.getUserType());
	}

	@Test
	void testDefaultConstructor() {

		AdminLogInReq request = new AdminLogInReq();

		assertNull(request.getUserId());
		assertNull(request.getPassword());
		assertNull(request.getConfigKeys());
		assertNull(request.getUserType());
	}

	@Test
	void testToString() {

		AdminLogInReq request = new AdminLogInReq("admin001", "password123", "CONFIG_KEY", "ADMIN");

		String result = request.toString();

		assertNotNull(result);
		assertTrue(result.contains("admin001"));
		assertTrue(result.contains("password123"));
		assertTrue(result.contains("CONFIG_KEY"));
		assertTrue(result.contains("ADMIN"));
	}
}