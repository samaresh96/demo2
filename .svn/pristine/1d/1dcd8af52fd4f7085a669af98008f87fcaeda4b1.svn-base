package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HomeInstructionConfigTest {

	@Test
	void testDefaultConstructor() {
		HomeInstructionConfig config = new HomeInstructionConfig();

		assertNotNull(config);
	}

	@Test
	void testParameterizedConstructorAndGetters() {

		HomeInstructionConfig config = new HomeInstructionConfig(1, "MAX_LOGIN_ATTEMPT", "5", true);

		assertEquals(1, config.getConfigId());
		assertEquals("MAX_LOGIN_ATTEMPT", config.getConfigKey());
		assertEquals("5", config.getConfigValue());
		assertTrue(config.isActive());

		assertNotNull(config.toString());
	}

	@Test
	void testSettersAndGetters() {

		HomeInstructionConfig config = new HomeInstructionConfig();

		config.setConfigId(10);
		config.setConfigKey("TEST_KEY");
		config.setConfigValue("TEST_VALUE");
		config.setActive(false);

		assertEquals(10, config.getConfigId());
		assertEquals("TEST_KEY", config.getConfigKey());
		assertEquals("TEST_VALUE", config.getConfigValue());
		assertFalse(config.isActive());
	}

	@Test
	void testToString() {

		HomeInstructionConfig config = new HomeInstructionConfig(100, "KEY", "VALUE", true);

		String result = config.toString();

		assertNotNull(result);
		assertTrue(result.contains("AthPrtlConfig"));
		assertTrue(result.contains("KEY"));
	}
}