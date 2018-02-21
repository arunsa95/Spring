package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.services.Welcome;

@SpringBootApplication
@ComponentScan({"com.services","com.dao.service"})

public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	
	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(DemoApplication.class, args);
	   Welcome msg= (Welcome) ctx.getBean(Welcome.class);
		System.out.println(msg.welcome());
		
		logger.error("Message logged at ERROR level");
	    logger.warn("Message logged at WARN level");
	    logger.info("Message logged at INFO level");
	    logger.debug("Message logged at DEBUG level");

        
	}
}
