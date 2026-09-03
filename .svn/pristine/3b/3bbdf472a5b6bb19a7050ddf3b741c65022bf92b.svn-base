package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IdsKeyValueTest {

	@Test
	void testDefaultConstructor() {
		IdsKeyValue keyValue = new IdsKeyValue();

		assertNotNull(keyValue);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		IdsKeyValue keyValue = new IdsKeyValue("TEST_KEY", "TEST_VALUE");

		assertEquals("TEST_KEY", keyValue.getKey());
		assertEquals("TEST_VALUE", keyValue.getValue());

		assertNotNull(keyValue.toString());
	}

	@Test
	void testSettersAndGetters() {

		IdsKeyValue keyValue = new IdsKeyValue();

		keyValue.setKey("KEY");
		keyValue.setValue("VALUE");

		assertEquals("KEY", keyValue.getKey());
		assertEquals("VALUE", keyValue.getValue());
	}

	@Test
	void testSerialVersionUID() {

		long serialVersionUid = IdsKeyValue.getSerialversionuid();

		assertEquals(7195734931586784896L, serialVersionUid);
	}

	@Test
	void testToString() {

		IdsKeyValue keyValue = new IdsKeyValue("ABC", "123");

		String result = keyValue.toString();

		assertNotNull(result);
		assertTrue(result.contains("IdsKeyValue"));
		assertTrue(result.contains("ABC"));
		assertTrue(result.contains("123"));
	}
}