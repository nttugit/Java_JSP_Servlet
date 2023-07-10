package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import model.Author;
import model.Book;
import model.BookGenre;

public class BookDAO implements DAOInterface<Book> {

	@Override
	public ArrayList<Book> selectAll() {
		ArrayList<Book> books = new ArrayList();
		try {
			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT * FROM book";
			PreparedStatement st = connection.prepareStatement(sql);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				String bookID = resultSet.getString("bookid");
				String title = resultSet.getString("title");
				String authorID = resultSet.getString("authorid");
				int publishedYear = resultSet.getInt("publishedyear");
				double wholesalePrice = resultSet.getDouble("wholesaleprice");
				double originalprice = resultSet.getDouble("originalprice");
				double retailPrice = resultSet.getDouble("retailprice");
				int instockQuantity = resultSet.getInt("instockquantity");
				String genre = resultSet.getString("genre");
				String language = resultSet.getString("language");
				String description = resultSet.getString("description");

				Author author = (new AuthorDAO()).selectById(authorID);
				BookGenre bookGenre = (new BookGenreDAO()).selectById(authorID);

				Book book = new Book(bookID, title, author, publishedYear, wholesalePrice, originalprice, retailPrice,
						instockQuantity, bookGenre, language, description);
				books.add(book);
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return books;
	}

	@Override
	public Book selectById(String id) {
		Book book = null;

		try {

			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT * FROM book WHERE bookid=\"" + id + "\"";
			Statement st = connection.createStatement();
			System.out.println(st);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				String bookID = resultSet.getString("bookid");
				String title = resultSet.getString("title");
				String authorID = resultSet.getString("authorid");
				int publishedYear = resultSet.getInt("publishedyear");
				double wholesalePrice = resultSet.getDouble("wholesaleprice");
				double originalprice = resultSet.getDouble("originalprice");
				double retailPrice = resultSet.getDouble("retailprice");
				int instockQuantity = resultSet.getInt("instockquantity");
				String genre = resultSet.getString("genre");
				String language = resultSet.getString("language");
				String description = resultSet.getString("description");

				Author author = (new AuthorDAO()).selectById(authorID);
				BookGenre bookGenre = (new BookGenreDAO()).selectById(genre);

				book = new Book(bookID, title, author, publishedYear, wholesalePrice, originalprice, retailPrice,
						instockQuantity, bookGenre, language, description);

			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return book;
	}

	@Override
	public int insert(Book t) {
		int result = 0;

		try {

			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "INSERT INTO book (bookid, title, authorid, publishedyear, wholesaleprice, originalprice, retailprice, instockquantity, genre, language, description) "
					+ "VALUES(?,?, ?, ?,?,?,?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, t.getBookID());
			st.setString(2, t.getBookTitle());
			st.setString(3, t.getAuthor().getAuthorID());
			st.setInt(4, t.getPublishedYear());
			st.setDouble(5, t.getWholesalePrice());
			st.setDouble(6, t.getOriginalPrice());
			st.setDouble(7, t.getRetailPrice());
			st.setDouble(8, t.getInstockQuantity());
			st.setString(9, t.getGenre().getBookGenreID());
			st.setString(10, t.getLanguage());
			st.setString(11, t.getDescription());

			System.out.println(st);

			// B3: thuc thi cau lenh SQL
			result = st.executeUpdate();

			// B4: xu ly

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int insertAll(ArrayList<Book> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<String> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Book t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		BookDAO bookDAO = new BookDAO();
		// select all
//		ArrayList<Book> books = bookDAO.selectAll();
//		for (Book book : books) {
//			System.out.println(book);
//		}

		// select by id
//		System.out.println(bookDAO.selectById("BOOK1"));

		// insert a book
		Author author1 = (new AuthorDAO()).selectById("AUTHOR1");
		BookGenre bookGenre = (new BookGenreDAO()).selectById("BOOKGENRE1");

		Book newBook = new Book("BOOK3", "3", author1, 2023, 8000.0, 10000.0, 12500.0, 1000, bookGenre, "English",
				"Stupid book for smart human");

		int insertBookResult = bookDAO.insert(newBook);
		System.out.println(insertBookResult);
	}
}
