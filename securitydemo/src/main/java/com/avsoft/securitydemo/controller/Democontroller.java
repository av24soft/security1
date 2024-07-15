package com.avsoft.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Democontroller {

	@GetMapping("/helloUser")
	public String helloUser()
	{
		return "hello user";
	}
	
	@GetMapping("/helloadmin")
	public String helladmin()
	{
		return "hello admin";
	}
	
	
}
