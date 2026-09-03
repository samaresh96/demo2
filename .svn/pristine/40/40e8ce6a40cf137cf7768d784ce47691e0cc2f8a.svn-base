package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DocumentUpdateRespTest {

	@Test
	void testDefaultConstructor() {
		DocumentUpdateResp response = new DocumentUpdateResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		DocumentUpdateResp response = new DocumentUpdateResp(100L, "2026-01-01", "123", "status", "abbr");

		assertEquals(100L, response.getId());
		assertEquals("2026-01-01", response.getUpdatedOn());
		assertEquals("123", response.getApplicationNo());
		assertEquals("status", response.getApplicationStatus());
		assertEquals("abbr", response.getApplicationStatusAbbrev());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		DocumentUpdateResp response = new DocumentUpdateResp();

		response.setId(200L);
		response.setUpdatedOn("2026-02-01");
		response.setApplicationNo("123");
		response.setApplicationStatus("status");
		response.setApplicationStatusAbbrev("abbr");

		assertEquals(200L, response.getId());
		assertEquals("2026-02-01", response.getUpdatedOn());
		assertEquals("123", response.getApplicationNo());
		assertEquals("status", response.getApplicationStatus());
		assertEquals("abbr", response.getApplicationStatusAbbrev());
	}

	@Test
	void testToString() {

		DocumentUpdateResp response = new DocumentUpdateResp(300L, "2026-03-01", "123", "status", "abbr");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("DocumentUpdateResp"));
		assertTrue(result.contains("300"));
		assertTrue(result.contains("2026-03-01"));
		assertTrue(result.contains("123"));
		assertTrue(result.contains("status"));
		assertTrue(result.contains("abbr"));
	}
}