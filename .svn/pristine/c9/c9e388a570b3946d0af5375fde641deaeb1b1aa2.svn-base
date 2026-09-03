package com.jcboe.home.instruction.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.web.cors.CorsConfiguration;

class CorsConfigBeanCreatorTest {

	@Test
	void testGetCorsConfigBean() {

		CorsConfigBeanCreator creator = new CorsConfigBeanCreator();

		CorsConfiguration config = creator.getCorsConfigBean();

		assertNotNull(config);
		assertTrue(config instanceof CorsConfiguration);
	}
}