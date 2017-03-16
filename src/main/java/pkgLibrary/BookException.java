package pkgLibrary;

public class BookException extends Exception {

	private Book b;
	
	public BookException()
	
	{	super();	}
	
	
	public BookException(Book b)
	
	{	super("Nope");
		
		this.b = b;		}
	
	
	public Book bk()
	
	{	return b;	}
	
}
	
	


