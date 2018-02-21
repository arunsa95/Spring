/**
 * 
 */
package cg;

import java.util.List;

/**
 * @author aruravic
 *
 */
public interface ProductRepository {
	public void add(Product product);

	public Product get(int productId);

	public List<Product> getAll();

}
