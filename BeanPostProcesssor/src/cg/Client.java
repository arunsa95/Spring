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
public class Client {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"app-context.xml");
		BeanInitializationLogger b = (BeanInitializationLogger) ctx.getBean(BeanInitializationLogger.class);
		
		b.postProcessAfterInitialization("df", "fb");
		b.postProcessBeforeInitialization( "nj", "ull");
		
		
		
	}
}
