/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.config;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
 * 
 * Date: 03-Dec-2022
 * Class: PropertyPrinter.java
 * Purpose:database url and api version print class from application.properties file
 *
 */
@Component
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class PropertyPrinter {

	private final Logger logger = LogManager.getLogger(PropertyPrinter.class);

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${api.version}")
	private String apiVersion;

	public PropertyPrinter() {
	}


	@PostConstruct
	@Scheduled(cron = "0 1 0 * * ?")
	private void printProperties() {
		logger.info("dbUrl:{} " , dbUrl);
		logger.info("apiVersion:{} " , apiVersion);

	}

}
