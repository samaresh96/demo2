package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ScreenTextApiResponseTest {

	@Test
	void testDefaultConstructor() {

		ScreenTextApiResponse response = new ScreenTextApiResponse();

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertNull(response.getMessage());
		assertNull(response.getAccessedOn());
		assertNull(response.getScreenTexts());
	}

	@Test
	void testParameterizedConstructor() {

		Map<String, String> screenTexts = new HashMap<>();
		screenTexts.put("WELCOME", "Welcome User");

		ScreenTextApiResponse response = new ScreenTextApiResponse(true, "Success", "2025-01-01", screenTexts);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2025-01-01", response.getAccessedOn());
		assertEquals(screenTexts, response.getScreenTexts());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		ScreenTextApiResponse response = new ScreenTextApiResponse();

		Map<String, String> screenTexts = new HashMap<>();
		screenTexts.put("ERROR", "Error Message");

		response.setSuccess(true);
		response.setMessage("Updated Message");
		response.setAccessedOn("2025-02-01");
		response.setScreenTexts(screenTexts);

		assertTrue(response.isSuccess());
		assertEquals("Updated Message", response.getMessage());
		assertEquals("2025-02-01", response.getAccessedOn());
		assertEquals(screenTexts, response.getScreenTexts());
	}

	@Test
	void testToString() {

		Map<String, String> screenTexts = new HashMap<>();
		screenTexts.put("KEY", "VALUE");

		ScreenTextApiResponse response = new ScreenTextApiResponse(true, "Success", "2025-01-01", screenTexts);

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("isSuccess=true"));
		assertTrue(result.contains("Success"));
		assertTrue(result.contains("2025-01-01"));
		assertTrue(result.contains("KEY"));
		assertTrue(result.contains("VALUE"));
	}
}