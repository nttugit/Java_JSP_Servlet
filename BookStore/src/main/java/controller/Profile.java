package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customer;
import util.MyEncryption;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/update-profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Profile() {	
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		String fullName = request.getParameter("fullName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String dob = request.getParameter("dob");
		String termsConsent = request.getParameter("termsConsent");
		String isRegisteredNotification = request.getParameter("isRegisteredNotification");
		
		
		System.out.println("termsConsent: "+termsConsent);
		System.out.println("isRegisteredNotification: "+isRegisteredNotification);
		System.out.println("sex: "+sex);

		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("repeatPassword", repeatPassword);
		request.setAttribute("fullName", fullName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("email", email);
		request.setAttribute("sex", sex + "");
		request.setAttribute("dob", dob);
		request.setAttribute("termsConsent", termsConsent);
		request.setAttribute("isRegisteredNotification", isRegisteredNotification);

//		System.out.println(username + password+  repeatPassword+ fullName+ phone+ address+ email+sex +dob + termsConsent);
		;

		// Xử lý lỗi
		String errorMsg = "";
		String url = "/";
		CustomerDAO customerDAO = new CustomerDAO();

		boolean exist = customerDAO.isExistedUsername(username);

		if (exist) {
			errorMsg = "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác. <br/>";
		}

		if (!password.equals(repeatPassword)) {
			errorMsg = "Mật khẩu không khớp.";
		}
		
		if(errorMsg.length() == 0) {
			password = MyEncryption.toSHA1(password);
		}

		if (errorMsg.length() > 0) {
			url = "/profile.jsp";
		} else {
			String customerID = UUID.randomUUID().toString();

			System.out.println(username + password + repeatPassword + fullName + phone + address + email + sex + dob
					+ termsConsent + customerID);

			Customer newCustomer = new Customer(customerID, username, password, fullName, sex, dob, phone, email,
					address, isRegisteredNotification != null);
			
			System.out.println("new customer: " + newCustomer);
			customerDAO.insert(newCustomer);
		}
		request.setAttribute("errorMsg", errorMsg);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
