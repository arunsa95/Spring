package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public ResponseEntity <String> createEmployee(
	@RequestBody EmployeeVO employee){
		System.out.println(employee.getName()+ " "+employee.getDept());
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	

}
