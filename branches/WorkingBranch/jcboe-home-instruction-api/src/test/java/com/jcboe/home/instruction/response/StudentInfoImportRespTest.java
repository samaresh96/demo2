package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentInfoImportRespTest {

	@Test
	void testDefaultConstructor() {
		StudentInfoImportResp response = new StudentInfoImportResp();

		assertNotNull(response);
		assertEquals(0, response.getTagId());
		assertNull(response.getVerifiedOn());
	}

	@Test
	void testParameterizedConstructor() {
		StudentInfoImportResp response = new StudentInfoImportResp(1001L, "2024-01-15");

		assertEquals(1001L, response.getTagId());
		assertEquals("2024-01-15", response.getVerifiedOn());
	}

	@Test
	void testSettersAndGetters() {
		StudentInfoImportResp response = new StudentInfoImportResp();

		response.setTagId(2002L);
		response.setVerifiedOn("2024-02-20");

		assertEquals(2002L, response.getTagId());
		assertEquals("2024-02-20", response.getVerifiedOn());
	}

	@Test
	void testToString() {
		StudentInfoImportResp response = new StudentInfoImportResp(1001L, "2024-01-15");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("StudentInfoImportResp"));
		assertTrue(result.contains("1001"));
		assertTrue(result.contains("2024-01-15"));
	}
}