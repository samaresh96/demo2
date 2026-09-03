package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UsrLoginResponseTest {

	@Test
	void testDefaultConstructorAndSetters() {

		UsrLoginResponse response = new UsrLoginResponse();

		UserDetailDTO userDetail = new UserDetailDTO();

		response.setSuccess(true);
		response.setMessage("Login successful");
		response.setGeneratedLink("http://test.com/link");
		response.setUserDetail(userDetail);

		assertTrue(response.isSuccess());
		assertEquals("Login successful", response.getMessage());
		assertEquals("http://test.com/link", response.getGeneratedLink());
		assertEquals(userDetail, response.getUserDetail());
	}

	@Test
	void testConstructorWithSuccessAndMessage() {

		UsrLoginResponse response = new UsrLoginResponse(true, "Login successful");

		assertTrue(response.isSuccess());
		assertEquals("Login successful", response.getMessage());
	}

	@Test
	void testConstructorWithGeneratedLink() {

		UsrLoginResponse response = new UsrLoginResponse(true, "Login successful", "http://test.com/link");

		assertTrue(response.isSuccess());
		assertEquals("Login successful", response.getMessage());
		assertEquals("http://test.com/link", response.getGeneratedLink());
	}

	@Test
	void testFullParameterizedConstructor() {

		UserDetailDTO userDetail = new UserDetailDTO();

		UsrLoginResponse response = new UsrLoginResponse(true, "Login successful", "http://test.com/link", userDetail);

		assertTrue(response.isSuccess());
		assertEquals("Login successful", response.getMessage());
		assertEquals("http://test.com/link", response.getGeneratedLink());
		assertEquals(userDetail, response.getUserDetail());
	}

	@Test
	void testBooleanSetter() {

		UsrLoginResponse response = new UsrLoginResponse();

		response.setSuccess(false);

		assertFalse(response.isSuccess());
	}

	@Test
	void testToString() {

		UsrLoginResponse response = new UsrLoginResponse();

		response.setSuccess(true);
		response.setMessage("Success");
		response.setGeneratedLink("link");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("success=true"));
		assertTrue(result.contains("message=Success"));
		assertTrue(result.contains("generatedLink=link"));
	}
}