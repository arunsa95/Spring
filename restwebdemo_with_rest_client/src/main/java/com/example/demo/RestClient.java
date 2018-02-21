package com.example.demo;

import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String uri = "http://localhost:8000/employee";
		
		EmployeeVO newEmployee= new EmployeeVO();
		newEmployee.setName("Anil");
		newEmployee.setDept("L&D");
		
		RestTemplate restTemplate = new RestTemplate();
		EmployeeVO result = restTemplate.postForObject(uri, newEmployee, EmployeeVO.class);
				
	}

}
