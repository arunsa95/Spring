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
public class LocaleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"app-context.xml");
		FieldValueTestBean ftb = (FieldValueTestBean) ctx
				.getBean("fieldValueTestBean");
		System.out.println(ftb.getDefaultLocale());

	}

}
