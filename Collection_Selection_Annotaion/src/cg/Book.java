/**
 * 
 */
package cg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author aruravic
 *
 */
@Component
public class Book {
	@Value("12")
	private int id;
	@Value("Harry Potter")
	private String title;
	@Value("#{1 + 1}")
	private double testAdd; 
 

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getTestAdd() {
		return testAdd;
	}

	public void setTestAdd(double testAdd) {
		this.testAdd = testAdd;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}
	
	
}
