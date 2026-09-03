package com.jcboe.home.instruction.model.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GetAppDetailsReqTest {

	@Test
	void testParameterizedConstructorAndGetters() {

		GetAppDetailsReq request = new GetAppDetailsReq("CONFIG_KEY", "LOOKUP_TYPE", "2026", 10, 1);

		assertEquals("CONFIG_KEY", request.getConfigKeys());
		assertEquals("LOOKUP_TYPE", request.getLookupType());
		assertEquals("2026", request.getSchoolYear());
		assertEquals(10, request.getPagesize());
		assertEquals(1, request.getPagenumber());
	}

	@Test
	void testSetters() {

		GetAppDetailsReq request = new GetAppDetailsReq();

		request.setConfigKeys("NEW_CONFIG");
		request.setLookupType("NEW_LOOKUP");
		request.setSchoolYear("2027");
		request.setPagesize(25);
		request.setPagenumber(5);

		assertEquals("NEW_CONFIG", request.getConfigKeys());
		assertEquals("NEW_LOOKUP", request.getLookupType());
		assertEquals("2027", request.getSchoolYear());
		assertEquals(25, request.getPagesize());
		assertEquals(5, request.getPagenumber());
	}

	@Test
	void testDefaultConstructor() {

		GetAppDetailsReq request = new GetAppDetailsReq();

		assertNull(request.getConfigKeys());
		assertNull(request.getLookupType());
		assertNull(request.getSchoolYear());
		assertEquals(0, request.getPagesize());
		assertEquals(0, request.getPagenumber());
	}

	@Test
	void testToString() {

		GetAppDetailsReq request = new GetAppDetailsReq("CONFIG_KEY", "LOOKUP_TYPE", "2026", 10, 1);

		String result = request.toString();

		assertNotNull(result);
		assertTrue(result.contains("CONFIG_KEY"));
		assertTrue(result.contains("LOOKUP_TYPE"));
		assertTrue(result.contains("2026"));
	}
}