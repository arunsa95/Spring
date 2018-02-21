package com.example.mvcdemo;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateUser(String username, String password){
		
	   return (username.equalsIgnoreCase("anil") && password.equalsIgnoreCase("password")) ;	
	
	}

}
