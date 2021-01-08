package com.example.hacknroll.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class LoginRegistrationConfig implements WebMvcConfigurer {
	@Autowired
	LoginCheckerInterceptor loginCheckerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckerInterceptor);
	}
}
