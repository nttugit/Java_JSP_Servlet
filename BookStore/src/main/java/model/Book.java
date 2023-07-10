package model;

public class Book {
	private String bookID;
	private String title;
	private Author author;
	private int publishedYear;
	private double wholesalePrice;
	private double originalPrice;
	private double retailPrice;
	private int instockQuantity;
	private BookGenre genre;
	private String language; // enum cung ok
	private String description;

	public Book() {
		super();
	}

	public Book(String bookID, String bookTitle, Author author, int publishedYear, double wholesalePrice, double originalPrice,
			double retailPrice, int instockQuantity, BookGenre genre, String language, String description) {
		this.bookID = bookID;
		this.title = bookTitle;
		this.author = author;
		this.publishedYear = publishedYear;
		this.wholesalePrice = wholesalePrice;
		this.originalPrice = originalPrice;
		this.retailPrice = retailPrice;
		this.instockQuantity = instockQuantity;
		this.genre = genre;
		this.language = language;
		this.description = description;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return title;
	}

	public void setBookTitle(String bookTitle) {
		this.title = bookTitle;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public int getInstockQuantity() {
		return instockQuantity;
	}

	public void setInstockQuantity(int instockQuantity) {
		this.instockQuantity = instockQuantity;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", author=" + author + ", publishedYear=" + publishedYear
				+ ", wholesalePrice=" + wholesalePrice + ", retailPrice=" + retailPrice + ", instockQuantity="
				+ instockQuantity + ", genre=" + genre + ", language=" + language + ", description=" + description
				+ "]";
	}

	
}
