package com.example.hacknroll.core.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/erent")
@CrossOrigin(origins = "http://localhost:3000")
public class ERentalPageRouter {
	@RequestMapping(value = "/allitems", method = RequestMethod.POST)
	@ResponseBody
	public boolean itemsOnRent() {

		return true;
	}
	
	
}
