package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml.LifecycleBean2;
import decoupled.FileMessageProvider;
import decoupled.MessageProvider;
import decoupled.MessageRenderer;

public class HelloWorldSpringDI {
	public static void main(String[] args) {

		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("classpath:*-context.xml");
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"app-context.xml");
		LifecycleBean2 lf = (LifecycleBean2) ctx.getBean("mrbean");
		 ctx.registerShutdownHook();

		MessageRenderer mr = (MessageRenderer) ctx.getBean("messageRenderer");
		
		MessageProvider mp = (MessageProvider) ctx.getBean("provider");
		
		
		mr.setMessageProvider(mp);
		
		mr.render();
		
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext(
				"app-context.xml");
		
		MessageRenderer mr1 = (MessageRenderer) ctx1.getBean("messageRenderer");
		FileMessageProvider fmp = (FileMessageProvider) ctx1.getBean("fileprovider");
		mr1.setMessageProvider(fmp);
		mr1.render();
	}
}
