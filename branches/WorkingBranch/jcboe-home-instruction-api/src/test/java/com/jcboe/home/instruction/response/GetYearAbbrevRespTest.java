package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GetYearAbbrevRespTest {

	@Test
	void testDefaultConstructor() {
		GetYearAbbrevResp response = new GetYearAbbrevResp();

		assertNotNull(response);
		assertNull(response.getLookupValue());
		assertNull(response.getLookupAbbreviation());
	}

	@Test
	void testParameterizedConstructor() {
		GetYearAbbrevResp response = new GetYearAbbrevResp("2024-2025", "24-25");

		assertEquals("2024-2025", response.getLookupValue());
		assertEquals("24-25", response.getLookupAbbreviation());
	}

	@Test
	void testSettersAndGetters() {
		GetYearAbbrevResp response = new GetYearAbbrevResp();

		response.setLookupValue("2025-2026");
		response.setLookupAbbreviation("25-26");

		assertEquals("2025-2026", response.getLookupValue());
		assertEquals("25-26", response.getLookupAbbreviation());
	}

	@Test
	void testToString() {
		GetYearAbbrevResp response = new GetYearAbbrevResp("2024-2025", "24-25");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("GetYearAbbrevResp"));
		assertTrue(result.contains("2024-2025"));
		assertTrue(result.contains("24-25"));
	}
}