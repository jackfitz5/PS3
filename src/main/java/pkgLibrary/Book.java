package pkgLibrary;

import java.io.File;
import java.util.Date;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;



public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private Date publish_date;
	private String description;
	private double cost;

	public Book() {

	}

	public Book(String id)
	{
		super();
		Book tempBook = GetBook(id);
		this.setCost(tempBook.getCost());
		this.setId(id);
		this.setAuthor(tempBook.getAuthor());
		this.setTitle(tempBook.getTitle());
		this.setGenre(tempBook.getGenre());
		this.setPrice(tempBook.getPrice());
		this.setPublish_date(tempBook.getPublish_date());
		this.setDescription(tempBook.getDescription());
		this.setCost(tempBook.getCost());
		
}
	
	public Book(String id, String author, String title, String genre, double price, Date publish_date, String description, double cost)
	{
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;		
		this.price = price;
		this.publish_date = publish_date;
		this.description = description;
		this.cost = cost;
	}
	

	
	public Book GetBook(String id){
		try
			{
			
			Catalog cat = ReadXMLFile();
			for(Book bk : cat.getBooks()){
				
				if(bk.getId() == (id))
					return bk;
			}
			throw new BookException(this);
			
				}catch(BookException e){
			
				System.out.println("Book" + id + "is not in the catalog.");
			
			return null;
			
		}
	}
	
	public void AddBook(String id, Book book){
		try{
			
			Catalog cat = ReadXMLFile();
			ArrayList<Book>tempList = cat.getBooks();
			for(Book b : cat.getBooks())
				
				if(b.getId() == (id))
					
					throw new BookException(this);
			
			tempList.add(book);
			cat.setBooks(tempList);
			WriteXMLFile(cat);
		
					}
					catch(BookException e)
					{
						
			System.out.println("Book" + id + " is in the catalog.");
		}
}
	
	

	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	
	private static void WriteXMLFile(Catalog cat) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}

}

	
	


