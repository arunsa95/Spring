/**
 * 
 */
package cg;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

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

		BookSevice service = (BookSevice) ctx.getBean(BookSevice.class);
		ExpressionParser parser = new SpelExpressionParser();

		List<BookSevice> books = (List<BookSevice>) parser.parseExpression(
				"books.?[title.startsWith('Harry')]").getValue(service);
		for (BookSevice book : books)
			System.out.println(book);

	}

}
