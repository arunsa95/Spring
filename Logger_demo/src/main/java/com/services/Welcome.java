package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Welcome {
	
	@Autowired
	private WelcomeService service;

	public String welcome() {
		
		return service.getWelcomeMessage();
	}
	
}
