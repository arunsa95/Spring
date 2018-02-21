/**
 * 
 */
package cg;

/**
 * @author aruravic
 *
 */
public class Product {

	private int productId;
	private String name;
	private String description;
	private double price;
	private int quantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
