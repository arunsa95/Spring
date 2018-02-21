package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import decoupled.FileMessageProvider;
import decoupled.MessageProvider;
import decoupled.MessageRenderer;

public class HelloWorldSpringDI {
	public static void main(String[] args) {

		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("classpath:*-context.xml");

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"app-context-annotation.xml");

		MessageRenderer mr = (MessageRenderer) ctx
				.getBean("standardOutMessageRenderer");// -->for @component file
														// config
		// MessageRenderer mr = (MessageRenderer)
		// ctx.getBean("messageRenderer");-->for xml file config
		MessageProvider mp = (MessageProvider) ctx.getBean("provider");
		mr.setMessageProvider(mp);

		mr.render();

		// from filemessageprovider
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext(
				"app-context-annotation.xml");

		MessageRenderer mr1 = (MessageRenderer) ctx1
				.getBean("standardOutMessageRenderer");
		FileMessageProvider fmp = (FileMessageProvider) ctx1
				.getBean("fileprovider");
		mr1.setMessageProvider(fmp);
		mr1.render();

	}
}
