package com.example.hacknroll.core.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hacknroll.core.AccessToken;
import com.example.hacknroll.core.LoginHandler;
import com.example.hacknroll.core.dataitems.User;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HomePageRouter {

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ResponseBody
	public boolean signup(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("telegramID") String telegramID) {
		LoginHandler.getInstance().signup(new User(username, telegramID, password));

		return true;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public AccessToken login(@RequestParam("username") String username, @RequestParam("password") String password) {
		return LoginHandler.getInstance().login(username, password);
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	@ResponseBody
	public String seeDashboard() {
		return "lorem impsum";
	}
}
