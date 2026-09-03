package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GetLogDataReqTest {

	@Test
	void testParameterizedConstructorAndGetters() {

		GetLogDataReq request = new GetLogDataReq("getStudentInfo", "Null pointer exception", "2026-08-03 10:30:00",
				"Controller");

		assertEquals("getStudentInfo", request.getFunctionName());
		assertEquals("Null pointer exception", request.getError());
		assertEquals("2026-08-03 10:30:00", request.getDateTime());
		assertEquals("Controller", request.getErrorFrom());
	}

	@Test
	void testSetters() {

		GetLogDataReq request = new GetLogDataReq();

		request.setFunctionName("login");
		request.setError("Invalid user");
		request.setDateTime("2026-08-03");
		request.setErrorFrom("Service");

		assertEquals("login", request.getFunctionName());
		assertEquals("Invalid user", request.getError());
		assertEquals("2026-08-03", request.getDateTime());
		assertEquals("Service", request.getErrorFrom());
	}

	@Test
	void testDefaultConstructor() {

		GetLogDataReq request = new GetLogDataReq();

		assertNull(request.getFunctionName());
		assertNull(request.getError());
		assertNull(request.getDateTime());
		assertNull(request.getErrorFrom());
	}

	@Test
	void testToString() {

		GetLogDataReq request = new GetLogDataReq("getStudentInfo", "Error", "2026-08-03", "Controller");

		String result = request.toString();

		assertNotNull(result);
		assertTrue(result.contains("getStudentInfo"));
		assertTrue(result.contains("Error"));
		assertTrue(result.contains("2026-08-03"));
		assertTrue(result.contains("Controller"));
	}
}