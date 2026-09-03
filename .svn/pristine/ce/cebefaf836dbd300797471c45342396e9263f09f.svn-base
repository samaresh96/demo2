/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigUtility {
	@Value("${commonutilityapi.username:}")
	private String username;

	@Value("${commonutilityapi.password:}")
	private String password;

	public RestTemplateConfigUtility() {
	}

	/*
	 * 
	 * Date: 27-Apr-2023 Method: restTemplate Purpose: Configuring rest template
	 *
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthentication(username, password).build();
	}
}
