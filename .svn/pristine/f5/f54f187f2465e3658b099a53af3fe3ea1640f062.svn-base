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

/*
 * 
 *
 * Date: 26-Apr-2023 Class: RestTemplateConfig.java Purpose:For configuring rest
 * template to call the APIs
 *
 */
@Configuration
public class RestTemplateConfig {
	@Value("${awsUtility.username:}")
	private String username;

	@Value("${awsUtility.password:}")
	private String password;

	public RestTemplateConfig() {
	}

	/*
	 * 
	 * Date: 27-Apr-2023 Method: restTemplate Purpose: Configuring rest template
	 *
	 */
	@Bean(name = "restTemplateForUtility")
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthentication(username, password).build();
	}
}
