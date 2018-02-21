package com.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
 
	@Value("${welcome.message}") 
	private String message;
	 
    @Value("${first_name}")	
    private String name;
    
	 public String getWelcomeMessage() 
	 {
		 return name + message;
	 }
	
}
