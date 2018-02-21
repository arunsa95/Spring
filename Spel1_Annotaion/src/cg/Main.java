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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"app-context.xml");

		Book bok = (Book) ctx.getBean("book");
		System.out.println("Book Id: " + bok.getId());
		System.out.println("Book Title: " + bok.getTitle());
		System.out.println("1+1 is: "+bok.getTestAdd());
		
		Author auth = (Author) ctx.getBean("author");
		System.out.println("Author: " + auth.getName());
		System.out.println("Book Title: " + auth.getBookTitle());
		System.out.println(auth.getBook());
		
		
		
		
	}

}
