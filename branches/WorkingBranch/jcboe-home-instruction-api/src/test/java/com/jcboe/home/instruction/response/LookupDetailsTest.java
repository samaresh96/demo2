package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LookupDetailsTest {

	@Test
	void testDefaultConstructor() {
		LookupDetails details = new LookupDetails();

		assertNotNull(details);
	}

	@Test
	void testParameterizedConstructorAndGetters() {
		LookupDetails details = new LookupDetails("TYPE", 1, "VALUE", "ABBR", true);

		assertEquals("TYPE", details.getLookuptype());
		assertEquals(1, details.getLookupvalueid());
		assertEquals("VALUE", details.getLookupvalue());
		assertEquals("ABBR", details.getLookupabbreviation());
		assertTrue(details.isActive());

		assertNotNull(details.toString());
	}

	@Test
	void testSetters() {
		LookupDetails details = new LookupDetails();

		details.setLookuptype("TYPE");
		details.setLookupvalueid(10);
		details.setLookupvalue("VALUE");
		details.setLookupabbreviation("ABBR");
		details.setActive(true);

		assertEquals("TYPE", details.getLookuptype());
		assertEquals(10, details.getLookupvalueid());
		assertEquals("VALUE", details.getLookupvalue());
		assertEquals("ABBR", details.getLookupabbreviation());
		assertTrue(details.isActive());
	}
}