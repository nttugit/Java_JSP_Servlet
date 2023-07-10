package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Author;
import model.BookGenre;

public class BookGenreDAO implements DAOInterface<BookGenre> {

	@Override
	public ArrayList<BookGenre> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookGenre selectById(String id) {
		BookGenre genre = null;

		try {

			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT * FROM bookgenre WHERE bookgenre_id=\"" + id + "\"";
			Statement st = connection.createStatement();
			System.out.println(st);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				String genreID = resultSet.getString("bookgenre_id");
				String genreName = resultSet.getString("genrename");

				genre = new BookGenre(genreID, genreName);
				break;
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return genre;
	}

	@Override
	public int insert(BookGenre t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<BookGenre> arr) {
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
	public int update(BookGenre t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
