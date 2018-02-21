/**
 * 
 */
package cg;

/**
 * @author aruravic
 *
 */
public class Book {
	private int id;
	private String title;
	private boolean testEqual; 

	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isTestEqual() {
		return testEqual;
	}

	public void setTestEqual(boolean testEqual) {
		this.testEqual = testEqual;
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}
	
	
}
