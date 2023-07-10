package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import model.Author;
import mylib.MySQLDate;

public class AuthorDAO implements DAOInterface<Author> {
	private ArrayList<Author> data = new ArrayList<>();

	@Override
	public ArrayList<Author> selectAll() {
		ArrayList<Author> authors = new ArrayList();
		try {
			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT * FROM author";
			PreparedStatement st = connection.prepareStatement(sql);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				String authorID = resultSet.getString("authorid");
				String fullName = resultSet.getString("fullname");
				Date dob = resultSet.getDate("dob");
				String bio = resultSet.getString("bio");

				Author author = new Author(authorID, fullName, dob, bio);
				authors.add(author);
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return authors;
	}

	@Override
	public Author selectById(String id) {
		Author author = null;

		try {

			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT * FROM author WHERE authorid=\"" + id + "\"";
			Statement st = connection.createStatement();
			System.out.println(st);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				String authorID = resultSet.getString("authorid");
				String fullName = resultSet.getString("fullname");
				Date dob = resultSet.getDate("dob");
				String bio = resultSet.getString("bio");

				author = new Author(authorID, fullName, dob, bio);
				break;
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return author;
	}

	@Override
	public int insert(Author t) {
		 
		int result = 0;

		try {
			// B1
			Connection connection = JDBCUtil.getConnection();

			// B2
			String sql = "INSERT INTO author (authorid,fullname,dob,bio) VALUES(?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, t.getAuthorID());
			st.setString(2, t.getFullName());
			st.setDate(3, t.getDob());
			st.setString(4, t.getBio());

			// B3
			result = st.executeUpdate();
			
			
			// B4
			System.out.println(sql);
			System.out.println("table author just updated: " + result + " records");

			// B5
			JDBCUtil.closeConnection(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insertAll(ArrayList<Author> arr) {
		int result = 0;
		
		for(Author author : arr) {
			result += this.insert(author);
		}
		
		return result;
	}

	@Override
	public int deleteById(String id) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from author "+
					 " WHERE authorid=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			result = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ result+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteAll(ArrayList<String> arr) {
		int result = 0;
		
		try {
			for(String id : arr) {
				result += this.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(Author t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE author "+
					 " SET " +
					 " fullname=?"+
					 ", dob=?"
					 + ", bio=?"+
					 " WHERE authorid=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullName());
			st.setDate(2, t.getDob());
			st.setString(3, t.getBio());
			st.setString(4, t.getAuthorID());

			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			result = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ result+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

//	public static void main(String[] args) {
//		AuthorDAO authorDao = new AuthorDAO();
//		MySQLDate mysqlDate = new MySQLDate();		
//		Date dob = mysqlDate.getDateFrom("2001-03-04");
//		
//		
//		Author newAuthor1 = new Author("AUTHOR4","444",dob,"444444");
//		Author newAuthor2 = new Author("AUTHOR5","5",dob,"5");
////		
//		ArrayList<Author> authors = new ArrayList<>();
//		authors.add(newAuthor1);
//		authors.add(newAuthor2);
//		
////		int addedResult = authorDao.insertAll(authors);
//		
////		int insertResult = authorDao.deleteById("AUTHOR3");
//		ArrayList<String> authorIds = new ArrayList<>();
//		authorIds.add("AUTHOR4");
//		authorIds.add("AUTHOR5");
//		
////		int deleteResult = authorDao.deleteById("AUTHOR5");
////		System.out.println(authorDao.deleteAll(authorIds));
//
//		
//	}
}
