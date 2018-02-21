package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.Employee;

public class client {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"app-context-annotation.xml");
		// Address ad = (Address) ctx.getBean("address");
		// System.out.println(ad);
		Employee emp = (Employee) ctx.getBean("empl");
		System.out.println(emp);

	}
}