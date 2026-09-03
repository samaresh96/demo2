/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.config;

import java.time.Duration;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

/*
 * 
 * Date: 03-Dec-2022
 * Class: WebSecurityConfig.java
 * Purpose:Web security config class use for API's security configuration
 *
 */
@Configuration
@EnableWebSecurity
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${webSecurity.role}")
	private String role;

	@Value("${webSecurity.username}")
	private String username;

	@Value("${webSecurity.password}")
	private String password;

	private CorsConfiguration corsConfig;

	@Autowired
	public WebSecurityConfig(CorsConfiguration corsConfig) {
		this.corsConfig = corsConfig;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser(username).password(encoder.encode(password)).roles(role);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/DownloadTemplate**").permitAll()
				.antMatchers(HttpMethod.GET, "/*").hasRole(role).antMatchers(HttpMethod.POST, "/*").hasRole(role)
				.anyRequest().authenticated().and().csrf().disable();

		corsConfig.setAllowedHeaders(Arrays.asList("Content-Type", "Accept, X-Requested-With", "X-AUTH-TOKEN",
				"Authorization", "Access-Control-Allow-Origin", "Content-Disposition"));
		corsConfig.setExposedHeaders(Arrays.asList("Content-Disposition"));
		corsConfig.setMaxAge(Duration.ofMillis(3600));
		corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "OPTION", "DELETE", "PUT"));
		corsConfig.addAllowedOrigin("*");
		corsConfig.setAllowCredentials(true);

		http.cors().configurationSource(request -> corsConfig);

	}
}
