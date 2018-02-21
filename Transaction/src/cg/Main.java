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
				"cg/config.xml");
		AccountService acc = (AccountService) ctx.getBean("accountService");

		Account ac = (Account) ctx.getBean("account");

		Account ac1 = (Account) ctx.getBean("account");

		// acc.transferFunds(ac, ac1, 10.00);
		System.out.println(acc.getAccount("A001"));
		System.out.println(ac.getNumber());

	}

}
