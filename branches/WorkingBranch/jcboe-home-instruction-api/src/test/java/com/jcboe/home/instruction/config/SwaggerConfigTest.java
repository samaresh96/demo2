package com.jcboe.home.instruction.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import springfox.documentation.spring.web.plugins.Docket;

class SwaggerConfigTest {

	@Test
	void testApi() {

		SwaggerConfig config = new SwaggerConfig();

		Docket docket = config.api();

		assertNotNull(docket);
		assertEquals("jcboe-home-instruction-api", docket.getGroupName());
	}
}