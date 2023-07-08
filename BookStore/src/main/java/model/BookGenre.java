package model;

public class BookGenre {
	private String bookGenreID;
	private String genreName;

	public BookGenre() {
		super();
	}

	public BookGenre(String bookGenreID, String genreName) {
		super();
		this.bookGenreID = bookGenreID;
		this.genreName = genreName;
	}

	public String getBookGenreID() {
		return bookGenreID;
	}

	public void setBookGenreID(String bookGenreID) {
		this.bookGenreID = bookGenreID;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
