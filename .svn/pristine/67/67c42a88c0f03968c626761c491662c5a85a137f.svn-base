package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GetStudentInfoReqByIdTest {

	@Test
	void testGetStudentInfoReqByIdConstructorAndMethods() {

		GetStudentInfoReqById request = new GetStudentInfoReqById("12345", "WEB");

		assertEquals("12345", request.getStudentId());
		assertEquals("WEB", request.getCalledFrom());
		assertNull(request.getConfigKeys());

		request.setStudentId("67890");
		request.setCalledFrom("MOBILE");
		request.setConfigKeys("CONFIG_1");

		assertEquals("67890", request.getStudentId());
		assertEquals("MOBILE", request.getCalledFrom());
		assertEquals("CONFIG_1", request.getConfigKeys());

		assertNotNull(request.toString());
		assertTrue(request.toString().contains("studentId=67890"));
		assertTrue(request.toString().contains("calledFrom=MOBILE"));
		assertTrue(request.toString().contains("configKeys=CONFIG_1"));
	}

	@Test
	void testDefaultConstructor() {

		GetStudentInfoReqById request = new GetStudentInfoReqById();

		assertNotNull(request);

		assertNull(request.getStudentId());
		assertNull(request.getCalledFrom());
		assertNull(request.getConfigKeys());
	}
}