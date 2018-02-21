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
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ex1-config.xml");
		ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
		Product p = new Product();
		p.setName("Majrul's Hackbook");
		p.setDescription("Hackintosh is fun!");
		p.setPrice(20000.0);
		p.setQuantity(99);
		productRepository.add(p);

	}

}
