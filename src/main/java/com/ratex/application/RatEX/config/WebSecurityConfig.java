package com.ratex.application.RatEX.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Configuration
@EnableWebSecurity
@Component
//class WebSecurityConfig that extends WebSecurityConfigurerAdapter
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// method to encrypt password
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	// In this example we do not use Security.
	// Override this method with empty code
	// to disable the default Spring Boot security.
	@Override
	public void configure(WebSecurity web) throws Exception {

		// Grant permission to access this resource below (/resources/**)
		// This is done to give access to properties and get configurations defined in
		// properties
		web.ignoring().antMatchers("/User/**");

	}

	// method to allow access to any project that makes a request to User/register
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Grant permission to access this resource below (save method)

		http.authorizeRequests().antMatchers("/User/register").permitAll();
		http.csrf().disable();
	}
}