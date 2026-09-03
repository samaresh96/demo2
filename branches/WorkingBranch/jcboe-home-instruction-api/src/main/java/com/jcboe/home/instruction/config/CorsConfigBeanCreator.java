/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

/*
 * 
 * Date: 03-Dec-2022
 * Class: CorsConfigBeanCreator.java
 * Purpose:Cors configuration bean creation class
 *
 */
@Configuration
public class CorsConfigBeanCreator {

	@Bean
	public CorsConfiguration getCorsConfigBean() {
		return new CorsConfiguration();
	}

}
