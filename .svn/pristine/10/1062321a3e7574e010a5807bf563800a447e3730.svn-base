package com.jcboe.home.instruction.config;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

class WebMvcConfigTest {

	@Test
	void testAddResourceHandlers() {

		WebMvcConfig config = new WebMvcConfig();

		ResourceHandlerRegistry registry = mock(ResourceHandlerRegistry.class);

		ResourceHandlerRegistration registration = mock(ResourceHandlerRegistration.class);

		when(registry.addResourceHandler("swagger-ui.html")).thenReturn(registration);

		when(registration.addResourceLocations("classpath:/META-INF/resources/")).thenReturn(registration);

		ResourceHandlerRegistration webjarsRegistration = mock(ResourceHandlerRegistration.class);

		when(registry.addResourceHandler("/webjars/**")).thenReturn(webjarsRegistration);

		when(webjarsRegistration.addResourceLocations("classpath:/META-INF/resources/webjars/"))
				.thenReturn(webjarsRegistration);

		config.addResourceHandlers(registry);
	}

	@Test
	void testConfigureContentNegotiation() {

		WebMvcConfig config = new WebMvcConfig();

		ContentNegotiationConfigurer configurer = new ContentNegotiationConfigurer(null);

		config.configureContentNegotiation(configurer);

		assertNotNull(configurer);
	}

	@Test
	void testAddCorsMappings() {

		WebMvcConfig config = new WebMvcConfig();

		CorsRegistry registry = new CorsRegistry();

		config.addCorsMappings(registry);

		assertNotNull(registry);
	}

	@Test
	void testConfigureMessageConverters() {

		WebMvcConfig config = new WebMvcConfig();

		List<HttpMessageConverter<?>> converters = new ArrayList<>();

		config.configureMessageConverters(converters);

		assertFalse(converters.isEmpty());

		assertNotNull(converters.get(0));

		assertTrue(converters.get(0) instanceof MappingJackson2HttpMessageConverter);
	}
}