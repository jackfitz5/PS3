package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Date;
import java.util.Map;
import pkgLibrary.Book;
import pkgLibrary.BookException;


public class BookTests {

	@Test
	public void GetBookA() {
				
		Book bk = new Book("bk101");
		assertTrue(bk.GetBook("bk101").getId().equals(bk.getId()));
			}
			
			
	public void GetBookB() {
				
		Book bk = new Book("bk101");
		assertNotEquals(bk.GetBook("bk105"), bk);
				
			}
				
				
	public void AddBookC() {
				
		Book bk = new Book("bk113", "John Fitzpatrick", "Hoop Dreamz", "sports", 100.0, new Date(1,1,1), "my rise to the top",80.0);
		bk.AddBook("bk113", bk);
		assertTrue((bk.GetBook("bk113") != null) && (bk.GetBook("bk113").getId().equals(bk.getId())));
	}
}


