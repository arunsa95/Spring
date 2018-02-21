package com.capgemini.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Employee;

@RestController
public class EmployeeProducerController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp");
		emp.setDesignation("manager");
		emp.setEmpId("3");
		emp.setSalary(3000);

		return emp;
	}

}
