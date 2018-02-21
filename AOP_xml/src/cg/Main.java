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
public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"app-context.xml");
		
		Book bok =  ctx.getBean("book",Book.class);
		
		/*LoggingAspect l = new LoggingAspect();
		l.advice();*/
	
		//System.out.println("after: "+bok.getTitle());
		
		
		
		
		/*System.out.println("Book Id: " + bok.getId());
		System.out.println("Book Title: " + bok.getTitle());
		System.out.println("#{1 == 2} is: " +bok.isTestEqual());

		Author auth = (Author) ctx.getBean("author");
		System.out.println(auth);
		System.out.println("Author: " + auth.getName());
		System.out.println("Book Title: " + auth.getBookTitle());
		System.out.println(auth.getBook());*/
	}

}
