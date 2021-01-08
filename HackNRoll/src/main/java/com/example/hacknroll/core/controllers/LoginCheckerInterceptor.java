package com.example.hacknroll.core.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.hacknroll.core.LoginHandler;

@Component
public class LoginCheckerInterceptor implements HandlerInterceptor {
	private void addHeaderInfo(HttpServletResponse response, boolean... x) {
		System.out.println(response.getHeaderNames());
		System.out.println(response.getHeaders("Access-Control-Allow-Credentials"));
		
		response.addHeader("Access-Control-Allow-Credentials","true");
		System.out.println(response.getHeaders("Access-Control-Allow-Credentials"));
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		addHeaderInfo(response);
//		long startTime = System.currentTimeMillis();
//		logger.info(
//				"Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + System.currentTimeMillis());
		if (request.getMethod().equalsIgnoreCase("POST")) {

			if (request.getServletPath().equals("/login") || request.getServletPath().equals("/signup")) {
				return true;
			}
			// System.out.println(request.getServletPath() + " g ");
			try {
				long userID = Long.parseLong(request.getParameter("user_id"));
				long accessToken = Long.parseLong(request.getParameter("access_token"));

				return LoginHandler.getInstance().verifyAccessToken(userID, accessToken);
			} catch (Exception e) {
				return false;
			}
		} else {
			return true;
		}
	}

}
