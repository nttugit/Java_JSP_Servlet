package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Author;
import model.Customer;
import mylib.MySQLDate;

public class CustomerDAO implements DAOInterface<Customer> {

	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectById(String t) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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
				result =  true;
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
			String sql = "SELECT * FROM customer WHERE username=\"" + username + "\" AND password=\"" + password +"\"";
			Statement st = connection.createStatement();
	
			System.out.println(sql);

			// B3: thuc thi cau lenh SQL
			ResultSet resultSet = st.executeQuery(sql);

			// B4: Xu ly du lieu (ResultSet -> your data)
			while (resultSet.next()) {
				customer = new Customer();
				customer.setFullName(resultSet.getString("fullname"));
				customer.setUsername(resultSet.getString("username"));
				break;
			}
			
			// B5: Ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return customer;
	}
	
//	public Customer selectByUsername(String username) {
//		Customer customer = null;
//
//		try {
//
//			// B1: Tao ket noi den CSDL
//			Connection connection = JDBCUtil.getConnection();
//
//			// B2: tao doi tuong statement
//			String sql = "SELECT * FROM customer WHERE username=\"" + username + "\"";
//			Statement st = connection.createStatement();
//			System.out.println(st);
//
//			// B3: thuc thi cau lenh SQL
//			ResultSet resultSet = st.executeQuery(sql);
//
//			// B4: Xu ly du lieu (ResultSet -> your data)
//			while (resultSet.next()) {
//				String customerID = resultSet.getString("customerid");
//				String userName = resultSet.getString("username");
//				String password = resultSet.getString("password");
//				String fullName = resultSet.getString("fullname");
//				String sex = resultSet.getString("sex");
//				String dob = resultSet.getString("dob");
//				String phone = resultSet.getString("phone");
//				String email = resultSet.getString("email");
//				boolean registeredNotification = resultSet.getBoolean("registerednotification");
//				String address = resultSet.getString("address");
//
//				customer = new Customer(
//						 customerID,  userName,  password,  fullName,  sex,  dob,
//						 phone,  email,  registeredNotification,  address);
//				
//				break;
//			}
//
//			// B5: Ngat ket noi
//			JDBCUtil.closeConnection(connection);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return customer;
//	}
	
//	public static void main(String[] args) {
//		CustomerDAO customerDao = new CustomerDAO();
//
//		System.out.println(customerDao.login("nttu", "123"));
//	}

}
