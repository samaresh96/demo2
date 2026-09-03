package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JCBOEApplicationDTOTest {

	@Test
	void testDefaultConstructor() {

		JCBOEApplicationDTO dto = new JCBOEApplicationDTO();

		assertNotNull(dto);
		assertEquals(0, dto.getApplicationId());
		assertNull(dto.getApplicationName());
		assertNull(dto.getApplicationUrl());
		assertNull(dto.getApplicationAbbvr());
		assertNull(dto.getApplicationLocalUrl());
	}

	@Test
	void testParameterizedConstructor() {

		JCBOEApplicationDTO dto = new JCBOEApplicationDTO(1, "Home Instruction", "http://application.com", "HI",
				"http://local.application.com");

		assertEquals(1, dto.getApplicationId());
		assertEquals("Home Instruction", dto.getApplicationName());
		assertEquals("http://application.com", dto.getApplicationUrl());
		assertEquals("HI", dto.getApplicationAbbvr());
		assertEquals("http://local.application.com", dto.getApplicationLocalUrl());

		assertNotNull(dto.toString());
	}

	@Test
	void testSettersAndGetters() {

		JCBOEApplicationDTO dto = new JCBOEApplicationDTO();

		dto.setApplicationId(10);
		dto.setApplicationName("Test Application");
		dto.setApplicationUrl("http://test.com");
		dto.setApplicationAbbvr("TEST");
		dto.setApplicationLocalUrl("http://localhost/test");

		assertEquals(10, dto.getApplicationId());
		assertEquals("Test Application", dto.getApplicationName());
		assertEquals("http://test.com", dto.getApplicationUrl());
		assertEquals("TEST", dto.getApplicationAbbvr());
		assertEquals("http://localhost/test", dto.getApplicationLocalUrl());
	}

	@Test
	void testToString() {

		JCBOEApplicationDTO dto = new JCBOEApplicationDTO(1, "Application", "url", "APP", "localUrl");

		String result = dto.toString();

		assertNotNull(result);
		assertTrue(result.contains("applicationId=1"));
		assertTrue(result.contains("applicationName=Application"));
		assertTrue(result.contains("applicationUrl=url"));
		assertTrue(result.contains("applicationAbbvr=APP"));
		assertTrue(result.contains("applicationLocalUrl=localUrl"));
	}
}