package com.jcboe.home.instruction.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.Duration;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

class WebSecurityConfigTest {

	private WebSecurityConfig config;
	private CorsConfiguration corsConfig;

	@BeforeEach
	void setUp() {

		corsConfig = new CorsConfiguration();

		config = new WebSecurityConfig(corsConfig);

		ReflectionTestUtils.setField(config, "role", "USER");
		ReflectionTestUtils.setField(config, "username", "testuser");
		ReflectionTestUtils.setField(config, "password", "testpassword");
	}

	@Test
	void testConstructor() {

		assertNotNull(config);
	}

	@Test
	void testConfigureAuthenticationManager() throws Exception {

		AuthenticationManagerBuilder auth = mock(AuthenticationManagerBuilder.class,
				org.mockito.Answers.RETURNS_DEEP_STUBS);

		config.configure(auth);

		/*
		 * Verify that in-memory authentication is configured.
		 */
		verify(auth).inMemoryAuthentication();

		/*
		 * Verify user configuration.
		 *
		 * Password is encoded internally by
		 * PasswordEncoderFactories.createDelegatingPasswordEncoder().
		 */
		verify(auth.inMemoryAuthentication()).withUser("testuser");

		verify(auth.inMemoryAuthentication().withUser("testuser")).password(anyString());

		verify(auth.inMemoryAuthentication().withUser("testuser").password(anyString())).roles("USER");
	}

	@Test
	void testConfigureHttpSecurity() throws Exception {

		HttpSecurity http = mock(HttpSecurity.class, org.mockito.Answers.RETURNS_DEEP_STUBS);

		config.configure(http);

		/*
		 * Verify CORS configuration.
		 */
		assertNotNull(corsConfig);

		assertEquals(Arrays.asList("Content-Type", "Accept, X-Requested-With", "X-AUTH-TOKEN", "Authorization",
				"Access-Control-Allow-Origin", "Content-Disposition"), corsConfig.getAllowedHeaders());

		assertEquals(Arrays.asList("Content-Disposition"), corsConfig.getExposedHeaders());

		assertEquals(Duration.ofMillis(3600), Duration.ofSeconds(corsConfig.getMaxAge()));

		assertEquals(Arrays.asList("POST", "GET", "OPTION", "DELETE", "PUT"), corsConfig.getAllowedMethods());

		assertEquals(Arrays.asList("*"), corsConfig.getAllowedOrigins());

		assertTrue(corsConfig.getAllowCredentials());

		/*
		 * Verify that CORS was enabled.
		 */
		verify(http).cors();
	}

	@Test
	void testConfigureHttpSecurity_CorsConfigurationSource() throws Exception {

		HttpSecurity http = mock(HttpSecurity.class, org.mockito.Answers.RETURNS_DEEP_STUBS);

		config.configure(http);

		/*
		 * Capture the CorsConfigurationSource passed to:
		 *
		 * http.cors().configurationSource(request -> corsConfig)
		 *
		 * This is important for covering the lambda expression.
		 */
		ArgumentCaptor<CorsConfigurationSource> captor = ArgumentCaptor.forClass(CorsConfigurationSource.class);

		verify(http.cors()).configurationSource(captor.capture());

		CorsConfigurationSource source = captor.getValue();

		assertNotNull(source);

		HttpServletRequest request = mock(HttpServletRequest.class);

		CorsConfiguration result = source.getCorsConfiguration(request);

		/*
		 * This executes:
		 *
		 * request -> corsConfig
		 */
		assertNotNull(result);

		assertEquals(corsConfig, result);

		assertEquals(Arrays.asList("Content-Type", "Accept, X-Requested-With", "X-AUTH-TOKEN", "Authorization",
				"Access-Control-Allow-Origin", "Content-Disposition"), result.getAllowedHeaders());

		assertEquals(Arrays.asList("Content-Disposition"), result.getExposedHeaders());

		assertEquals(Arrays.asList("POST", "GET", "OPTION", "DELETE", "PUT"), result.getAllowedMethods());

		assertEquals(Arrays.asList("*"), result.getAllowedOrigins());

		assertTrue(result.getAllowCredentials());
	}

	@Test
	void testConfigureHttpSecurity_AllSecurityCalls() throws Exception {

		HttpSecurity http = mock(HttpSecurity.class, org.mockito.Answers.RETURNS_DEEP_STUBS);

		config.configure(http);

		/*
		 * HTTP Basic authentication
		 */
		verify(http).httpBasic();

		/*
		 * Authorization configuration
		 */
		verify(http.httpBasic()).and();

		verify(http.httpBasic().and()).authorizeRequests();

		/*
		 * Verify CORS configuration call.
		 */
		verify(http).cors();

		/*
		 * Verify CSRF disable.
		 */
		verify(http.httpBasic().and().authorizeRequests()
				.antMatchers(org.springframework.http.HttpMethod.GET, "/DownloadTemplate**").permitAll()
				.antMatchers(org.springframework.http.HttpMethod.GET, "/*").hasRole("USER")
				.antMatchers(org.springframework.http.HttpMethod.POST, "/*").hasRole("USER").anyRequest()
				.authenticated().and()).csrf();

		verify(http.httpBasic().and().authorizeRequests()
				.antMatchers(org.springframework.http.HttpMethod.GET, "/DownloadTemplate**").permitAll()
				.antMatchers(org.springframework.http.HttpMethod.GET, "/*").hasRole("USER")
				.antMatchers(org.springframework.http.HttpMethod.POST, "/*").hasRole("USER").anyRequest()
				.authenticated().and().csrf()).disable();
	}

	@Test
	void testConfigureHttpSecurity_CorsMethods() throws Exception {

		HttpSecurity http = mock(HttpSecurity.class, org.mockito.Answers.RETURNS_DEEP_STUBS);

		config.configure(http);

		/*
		 * Verify that the CORS configuration source is registered.
		 */
		ArgumentCaptor<CorsConfigurationSource> captor = ArgumentCaptor.forClass(CorsConfigurationSource.class);

		verify(http.cors()).configurationSource(captor.capture());

		assertNotNull(captor.getValue());

		/*
		 * Execute the lambda.
		 */
		CorsConfiguration result = captor.getValue().getCorsConfiguration(mock(HttpServletRequest.class));

		assertEquals(corsConfig, result);
	}

	@Test
	void testConfigureHttpSecurity_WithDifferentRole() throws Exception {

		/*
		 * Extra test to ensure the role comes from the @Value field.
		 */
		ReflectionTestUtils.setField(config, "role", "ADMIN");

		HttpSecurity http = mock(HttpSecurity.class, org.mockito.Answers.RETURNS_DEEP_STUBS);

		config.configure(http);

		assertEquals("ADMIN", ReflectionTestUtils.getField(config, "role"));

		verify(http.httpBasic().and().authorizeRequests().antMatchers(org.springframework.http.HttpMethod.GET, "/*"))
				.hasRole("ADMIN");

		verify(http.httpBasic().and().authorizeRequests().antMatchers(org.springframework.http.HttpMethod.POST, "/*"))
				.hasRole("ADMIN");
	}

	@Test
	void testConfigureAuthenticationManager_WithDifferentCredentials() throws Exception {

		ReflectionTestUtils.setField(config, "username", "admin");
		ReflectionTestUtils.setField(config, "password", "adminPassword");
		ReflectionTestUtils.setField(config, "role", "ADMIN");

		AuthenticationManagerBuilder auth = mock(AuthenticationManagerBuilder.class,
				org.mockito.Answers.RETURNS_DEEP_STUBS);

		config.configure(auth);

		verify(auth).inMemoryAuthentication();

		verify(auth.inMemoryAuthentication()).withUser("admin");

		verify(auth.inMemoryAuthentication().withUser("admin")).password(anyString());

		verify(auth.inMemoryAuthentication().withUser("admin").password(anyString())).roles("ADMIN");
	}
}
