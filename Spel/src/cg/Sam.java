/**
 * 
 */
package cg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author aruravic
 *
 */
public class Sam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ExpressionParser parser = new SpelExpressionParser(); Expression exp
		 * = parser.parseExpression("'Hello World'"); String message = (String)
		 * exp.getValue(); System.out.println(message);
		 */
		/*
		 * ExpressionParser parser = new SpelExpressionParser(); Expression exp
		 * = parser.parseExpression("'Hello World'.concat('!')"); String msg =
		 * (String)exp.getValue(); System.out.println(msg);
		 */
		
		ExpressionParser parser = new SpelExpressionParser();
		/*Expression exp = parser.parseExpression("'Hello World'.bytes"); 
		byte[] bytes = (byte[]) exp.getValue();

		System.out.println(bytes);*/
		Expression exp = parser.parseExpression("'Hello World'.bytes.length"); 
		int length = (Integer) exp.getValue();
		System.out.println(length);
		Expression exp1 = parser.parseExpression("new String('hello world').toUpperCase()"); 
		String message = exp1.getValue(String.class);
		System.out.println(message);
	}

}
