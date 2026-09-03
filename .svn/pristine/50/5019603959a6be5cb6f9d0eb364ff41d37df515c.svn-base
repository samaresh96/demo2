/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * 
 * Date: 03-Dec-2022 Class: SwaggerConfig.java Purpose: Swagger configuration
 * class use for configuring the swagger 2
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("jcboe-home-instruction-api").select()
				.apis(RequestHandlerSelectors.basePackage("com.jcboe.home.instruction.controller"))
				.paths(PathSelectors.any()).build().apiInfo(new ApiInfoBuilder().title("JCBOEHomeInstruction API")
						.description("JCBOEHomeInstruction API").build());
	}
}
