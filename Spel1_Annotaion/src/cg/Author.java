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
public class Author {
	@Value("Rowling")
	private String name;
	@Value("#{book}")
	private Book book;
	@Value("#{book.title}")
	private String bookTitle;

	
	public Author() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	@Override
	public String toString() {
		return "Author [name=" + name + ", book=" + book + ", bookTitle="
				+ bookTitle + "]";
	}
	
	
}
