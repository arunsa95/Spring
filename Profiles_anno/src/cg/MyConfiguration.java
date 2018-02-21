/**
 * 
 */
package cg;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author aruravic
 *
 */
@Configuration
@ComponentScan
public class MyConfiguration {

	private Book bookDev;
	private Book bookProd;
	private Book book;

	@Bean(name = "bookbean")
	@Profile("dev")
	public Book getBookDev() {
		return new Book(1, "development Title", 130);
	}

	public void setBookDev(Book bookDev) {
		this.bookDev = bookDev;
	}

	@Profile("prod")
	@Bean(name = "bookbean")
	public Book getBookProd() {
		return new Book(1, "Production Title", 130);
	}

	public void setBookProd(Book bookProd) {
		this.bookProd = bookProd;
	}

	@Bean(name = "bookbean")
	public Book getBook() {
		return new Book(1, "Default Title", 230);

	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "MyConfiguration [bookDev=" + bookDev + ", bookProd=" + bookProd
				+ ", book=" + book + "]";
	}

}
