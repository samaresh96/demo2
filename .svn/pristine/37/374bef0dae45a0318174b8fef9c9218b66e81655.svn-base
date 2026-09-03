package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GetLogDataRespTest {

	@Test
	void testDefaultConstructor() {
		GetLogDataResp response = new GetLogDataResp();

		assertNotNull(response);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		GetLogDataResp response = new GetLogDataResp(true, "Log data fetched successfully");

		assertTrue(response.isSuccess());
		assertEquals("Log data fetched successfully", response.getMessage());

		assertNotNull(response.toString());
	}

	@Test
	void testSettersAndGetters() {

		GetLogDataResp response = new GetLogDataResp();

		response.setSuccess(true);
		response.setMessage("Success");

		assertTrue(response.isSuccess());
		assertEquals("Success", response.getMessage());
	}

	@Test
	void testToString() {

		GetLogDataResp response = new GetLogDataResp(false, "Failed to fetch log data");

		String result = response.toString();

		assertNotNull(result);
		assertTrue(result.contains("GetLogDataResp"));
		assertTrue(result.contains("Failed to fetch log data"));
	}
}