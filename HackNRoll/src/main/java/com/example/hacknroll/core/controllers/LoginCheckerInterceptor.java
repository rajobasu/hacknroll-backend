package com.example.hacknroll.core.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.hacknroll.core.LoginHandler;

public class LoginCheckerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		long startTime = System.currentTimeMillis();
//		logger.info(
//				"Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + System.currentTimeMillis());
		if (request.getMethod().equalsIgnoreCase("POST")) {
			long userID = Long.parseLong(request.getParameter("user_id"));
			long accessToken = Long.parseLong(request.getParameter("access_token"));
			return LoginHandler.getInstance().verifyAccessToken(userID, accessToken);
		} else {
			return true;
		}
	}

}
