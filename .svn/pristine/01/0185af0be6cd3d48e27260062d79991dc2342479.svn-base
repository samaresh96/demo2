package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UserLoginRequestTest {

	@Test
	public void testDefaultConstructor() {
		UserLoginRequest request = new UserLoginRequest();
		assertNotNull(request);
	}

	@Test
	public void testParameterizedConstructor() {
		String userId = "USER001";
		String userType = "STUDENT";
		String applicationId = "APP001";
		String userPassword = "password123";
		String applicationIndicator = "LOGIN";
		boolean getPassword = true;
		UserLoginRequest request = new UserLoginRequest(userId, userType, applicationId, userPassword,
				applicationIndicator, getPassword);
		assertEquals(userId, request.getUserId());
		assertEquals(userType, request.getUserType());
		assertEquals(applicationId, request.getApplicationId());
		assertEquals(userPassword, request.getUserPassword());
		assertEquals(applicationIndicator, request.getApplicationIndicator());
		assertEquals(getPassword, request.isGetPassword());
	}

	@Test
	public void testSettersAndGetters() {
		UserLoginRequest request = new UserLoginRequest();
		request.setUserId("USER002");
		request.setUserType("TEACHER");
		request.setApplicationId("APP002");
		request.setUserPassword("testPassword");
		request.setApplicationIndicator("TEST");
		request.setGetPassword(false);
		request.setType("LOGIN");
		request.setLoginName("testUser");
		request.setLoginPassword("loginPassword");
		request.setCalledFrom("WEB");
		request.setConfigKeys("CONFIG001");
		assertEquals("USER002", request.getUserId());
		assertEquals("TEACHER", request.getUserType());
		assertEquals("APP002", request.getApplicationId());
		assertEquals("testPassword", request.getUserPassword());
		assertEquals("TEST", request.getApplicationIndicator());
		assertEquals(false, request.isGetPassword());
		assertEquals("LOGIN", request.getType());
		assertEquals("testUser", request.getLoginName());
		assertEquals("loginPassword", request.getLoginPassword());
		assertEquals("WEB", request.getCalledFrom());
		assertEquals("CONFIG001", request.getConfigKeys());
	}

	@Test
	void testToString() {
		UserLoginRequest request = new UserLoginRequest();
		String expectedString = "AssignInfoForm [Id= Id, userId= userId , userName= userName, formType= formType";
		assertEquals(expectedString, request.toString());
	}
}