package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ScreenTextResponseTest {

	@Test
	void testDefaultConstructor() {
		ScreenTextResponse response = new ScreenTextResponse();

		assertNotNull(response);
		assertFalse(response.isSuccess());
		assertNull(response.getMessage());
		assertNull(response.getAccessedOn());
		assertNull(response.getScreenTexts());
	}

	@Test
	void testParameterizedConstructor() {
		Map<String, String> screenTexts = new HashMap<>();
		screenTexts.put("HOME_TITLE", "Home Page");

		ScreenTextResponse response = new ScreenTextResponse(true, "Success", "2024-01-01", screenTexts);

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
		assertEquals("2024-01-01", response.getAccessedOn());
		assertEquals(screenTexts, response.getScreenTexts());
		assertEquals("Home Page", response.getScreenTexts().get("HOME_TITLE"));
	}

	@Test
	void testSettersAndGetters() {
		ScreenTextResponse response = new ScreenTextResponse();

		Map<String, String> screenTexts = new HashMap<>();
		screenTexts.put("KEY", "VALUE");

		response.setSuccess(true);
		response.setMessage("Test Message");
		response.setAccessedOn("2024-02-01");
		response.setScreenTexts(screenTexts);

		assertTrue(response.isSuccess());
		assertEquals("Test Message", response.getMessage());
		assertEquals("2024-02-01", response.getAccessedOn());
		assertEquals(screenTexts, response.getScreenTexts());
		assertEquals("VALUE", response.getScreenTexts().get("KEY"));
	}

	@Test
	void testToString() {
		ScreenTextResponse response = new ScreenTextResponse(true, "Success", "2024-01-01", new HashMap<>());

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("ScreenTextResponse"));
		assertTrue(result.contains("Success"));
	}
}