/**
 * 
 */
package cg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author aruravic
 *
 */
@Component
public class BookSevice {
	private List<BookSevice> books = new ArrayList<>();

public BookSevice() {
	
}	
	
	
	
	
	
	public List<BookSevice> getBooks() {
		return books;
	}

	public void setBooks(List<BookSevice> books) {
		this.books = books;
	}



}
