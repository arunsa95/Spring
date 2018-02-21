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

		SomeServiceClass sm = (SomeServiceClass) act.getBean("serviceClass");

		System.out.println(sm.getAdminEmails());

	}

}
