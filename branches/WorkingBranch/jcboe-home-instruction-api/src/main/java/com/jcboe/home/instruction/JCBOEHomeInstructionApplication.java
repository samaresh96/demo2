/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
/*
 * 
 * Date: 30-July-2026 Class: JCBOEHomeInstructionApplication.java Purpose: Main
 * method used to execute the Springboot API project.
 *
 */
public class JCBOEHomeInstructionApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JCBOEHomeInstructionApplication.class, args);
	}

}
