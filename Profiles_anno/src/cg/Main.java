/**
 * 
 */
package cg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author aruravic
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("prod");
		
		//ctx.register(Author.class);
		ctx.refresh();
		Author author = (Author) ctx.getBean(Author.class);
		System.out.println(author);
		ctx.close();

	}

}
