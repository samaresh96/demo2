package com.jcboe.home.instruction.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class RestTemplateConfigTest {

	@Mock
	private RestTemplateBuilder builder;

	@Mock
	private RestTemplate restTemplate;

	@Test
	void testConstructor() {
		RestTemplateConfig config = new RestTemplateConfig();

		assertNotNull(config);
	}

	@Test
	void testRestTemplate() {

		RestTemplateConfig config = new RestTemplateConfig();

		ReflectionTestUtils.setField(config, "username", "testUser");
		ReflectionTestUtils.setField(config, "password", "testPassword");

		when(builder.basicAuthentication("testUser", "testPassword")).thenReturn(builder);

		when(builder.build()).thenReturn(restTemplate);

		RestTemplate result = config.restTemplate(builder);

		assertNotNull(result);
		assertSame(restTemplate, result);

		verify(builder).basicAuthentication("testUser", "testPassword");
		verify(builder).build();
	}
}