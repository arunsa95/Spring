/**
 * 
 */
package cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aruravic
 *
 */
public class client {

	public static void main(String[] args) {

		ApplicationContext act = new ClassPathXmlApplicationContext(
				"app-context.xml");

		SomeService sm = (SomeService) act.getBean("someService");
		
		
		
		
		System.out.println(sm.getAdministrator());
		
		System.out.println(sm.getDevelopment());
		System.out.println(sm.getSupport());
		
	}

}
