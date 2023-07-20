package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import model.Author;
import model.Customer;
import mylib.MySQLDate;
import util.MyRandom;

public class CustomerDAO implements DAOInterface<Customer> {

	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectById(String id) {
		Customer customer = null;
		try {
			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT * FROM customer WHERE customerid=\'" + id + "\'";
			Statement st = connection.createStatement();

			System.out.println(sql);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				String customerID = resultSet.getString("customerid");
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				String fullName = resultSet.getString("fullname");
				int sex = resultSet.getInt("sex");
				String dob = resultSet.getString("dob");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				boolean registeredNotification = resultSet.getBoolean("notificationregistration");
				String address = resultSet.getString("address");
				String verificationCode = resultSet.getString("verificationcode");
				String codeExpiredTime = resultSet.getDate("codeexpiredtime") !=null ? resultSet.getDate("codeexpiredtime").toString() : null;

				customer = new Customer(customerID, userName, password, fullName, sex, dob, phone, email, address,
						registeredNotification,verificationCode, codeExpiredTime);
				break;
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int insert(Customer t) {
		int result = 0;

		try {
			// B1
			Connection connection = JDBCUtil.getConnection();

			// B2
			String sql = "INSERT INTO customer (customerid,username,password,fullname,sex,dob,phone,email,address,notificationregistration) VALUES(?,?,?,?,?, ?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, t.getCustomerID());
			st.setString(2, t.getUsername());
			st.setString(3, t.getPassword());
			st.setString(4, t.getFullName());
			st.setInt(5, t.getSex());
			MySQLDate mySqlDate = new MySQLDate();
			st.setDate(6, mySqlDate.getDateFrom(t.getDob()));
			st.setString(7, t.getPhone());
			st.setString(8, t.getEmail());
			st.setString(9, t.getAddress());
			st.setBoolean(10, t.isRegisteredNotification());

			// B3
			result = st.executeUpdate();

			// B4
			System.out.println(sql);
			System.out.println("table customer just updated: " + result + " records");

			// B5
			JDBCUtil.closeConnection(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insertAll(ArrayList<Customer> arr) {
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
	public int update(Customer t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer SET fullname=?, sex=?, dob=?"
					+ ", phone=?, email=?, address=?, notificationregistration=?" + " WHERE customerid=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullName());
			st.setInt(2, t.getSex());
			MySQLDate mySqlDate = new MySQLDate();
			st.setDate(3, mySqlDate.getDateFrom(t.getDob()));
			st.setString(4, t.getPhone());
			st.setString(5, t.getEmail());
			st.setString(6, t.getAddress());
			st.setBoolean(7, t.isRegisteredNotification());
			st.setString(8, t.getCustomerID());

			// Bước 3: thực thi câu lệnh SQL
			result = st.executeUpdate();

			// Bước 4:
			System.out.println(sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int updatePassword(String username, String newPassword) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer " + " SET " + " password=?" + " WHERE username=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, newPassword);
			st.setString(2, username);

			// Bước 3: thực thi câu lệnh SQL
			result = st.executeUpdate();

			// Bước 4:
			System.out.println(sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int updateAFieldByID(String customerID, String fieldName, String value) {
		int result = 0;
		try {
			System.out.println(customerID + ", " + fieldName + ", " + value);
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer " + " SET " + fieldName + "=?" + " WHERE customerid=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(2, customerID);
			if (fieldName == "notificationregistration") {
				st.setBoolean(1, value != null);
			} else {
				st.setString(1, customerID);
			}

			// Bước 3: thực thi câu lệnh SQL
			result = st.executeUpdate();

			// Bước 4:
			System.out.println(sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public boolean isExistedUsername(String username) {
		boolean result = false;
		try {

			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT 1 FROM customer WHERE username=\"" + username + "\"";
			Statement st = connection.createStatement();
			System.out.println(st);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);
//			System.out.println("result: " + resultSet);
			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				result = true;
				break;
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public Customer login(String username, String password) {
		Customer customer = null;
		try {

			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			String sql = "SELECT * FROM customer WHERE username=? AND password=?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			System.out.println(sql);
			System.out.println(username + " " + password);
			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery();

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				String customerID = resultSet.getString("customerid");
				String userName = resultSet.getString("username");
//				String password = resultSet.getString("password");
				String fullName = resultSet.getString("fullname");
				int sex = resultSet.getInt("sex");
				String dob = resultSet.getString("dob");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				boolean registeredNotification = resultSet.getBoolean("notificationregistration");
				String address = resultSet.getString("address");
				String verificationCode = resultSet.getString("verificationcode");
				String codeExpiredTime = resultSet.getDate("codeexpiredtime") !=null ? resultSet.getDate("codeexpiredtime").toString() : null;
				

				customer = new Customer(customerID, userName, password, fullName, sex, dob, phone, email, address,
						registeredNotification,verificationCode, codeExpiredTime);
				break;
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public Customer getVerificationCode(String customerID) {
		Customer customer = null;
		try {
			// B1: Tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();

			// B2: tao doi tuong statement
			// Kiểm tra mã code phải là null, nếu nó không là null thì chưa xác thực
			String sql = "SELECT *  FROM customer WHERE customerid=\"" + customerID + "\"";
//			String sql = "SELECT * FROM customer WHERE username=? AND verificationcode=?";
			Statement st = connection.createStatement();
//			PreparedStatement st = connection.prepareStatement(sql);
//			st.setString(1, username);
//			st.setString(2, null);
			System.out.println(sql);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerID(customerID);
				customer.setUsername(resultSet.getString("username"));
				customer.setVerficationCode(resultSet.getString("verificationcode"));
				customer.setCodeExpiredTime(resultSet.getString("codeexpiredtime"));
				break;
			}

			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public int verifyAccount(String customerID) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();

			String sql = "UPDATE Customer SET verificationcode = NULL, codeexpiredtime = NULL WHERE customerid=?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, customerID);
			System.out.println(sql);
			
			result = st.executeUpdate();

			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Customer createNewVerificationCode(String customerID) {
		Customer customer = null;
		try {
			Connection connection = JDBCUtil.getConnection();

			// todo: update here
			// Generate code and expired time
			String newCode = MyRandom.randomVerificationCode(16);
			int timeToAdd =2; // hours
			Date todaysDate = new Date(new java.util.Date().getTime());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(todaysDate);
			calendar.add(Calendar.DATE, timeToAdd);
			Date codeExpiredTime = new Date(calendar.getTimeInMillis());
			
			// Execute query
			String sql = "UPDATE customer SET verificationcode = ?, codeexpiredtime = ? WHERE customerid = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, newCode);
			st.setDate(2,  codeExpiredTime);
			st.setString(3, customerID);
						
			int result = st.executeUpdate();
			if(result > 0 ) {
				customer = selectById(customerID);
			}

			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}


//	public static void main(String[] args) {
//		CustomerDAO customerDao = new CustomerDAO();
//		int result = customerDao.createNewVerificationCode("0d2a1707-15a3-4a94-bfd8-03117586c6a2");
//		System.out.println(result);
//
//	}

}
