package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import model.Customer;
import util.MyEmailService;
import util.MyEncryption;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "login": {
			login(request, response);
			break;
		}
		case "logout": {
			logout(request, response);
			break;
		}
		case "register": {
			register(request, response);
			break;
		}
		case "verifyAccount": {
			verifyAccount(request, response);
			break;
		}
		case "resendVerificationCode": {
			resendVerificationCode(request, response);
			break;
		}
		case "updatePassword": {
			updatePassword(request, response);
			break;
		}
		case "updateProfile": {
			updateProfile(request, response);
			break;
		}
		case "updateNotification": {
			updateNotification(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
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

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerDAO customerDAO = new CustomerDAO();
		String username = request.getParameter("loginUsername");
		String passsword = request.getParameter("loginPassword");

		request.setAttribute("loginPassword", username);
		request.setAttribute("loginPassword", passsword);
		String loginError = "";
		String url = "/index.jsp";

		passsword = MyEncryption.toSHA1(passsword);

		Customer customer = customerDAO.login(username, passsword);
		System.out.println(customer);
		if (customer != null) {
			if (customer.getVerficationCode() != null) {
				loginError = "Tài khoản chưa được xác thực. Vui lòng xác thực qua email đã đăng ký";
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
			}
		} else {
			loginError = "Tên đăng nhập hoặc mật khẩu không chính xác.";
		}

		request.setAttribute("loginError", loginError);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();

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

		// Xử lý lỗi
		String errorMsg = "";
		String registerMsg = "";
		String url = "/customer/register.jsp";
		CustomerDAO customerDAO = new CustomerDAO();

		boolean exist = customerDAO.isExistedUsername(username);

		if (exist) {
			errorMsg = "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác. <br/>";
		}

		if (!password.equals(repeatPassword)) {
			errorMsg = "Mật khẩu không khớp.";
		}

		if (errorMsg.length() == 0) {
			password = MyEncryption.toSHA1(password);
		}

		String customerID = UUID.randomUUID().toString();

		System.out.println(username + password + repeatPassword + fullName + phone + address + email + sex + dob
				+ termsConsent + customerID);

		Customer newCustomer = new Customer(customerID, username, password, fullName, sex, dob, phone, email, address,
				isRegisteredNotification != null);

		System.out.println("new customer: " + newCustomer);
		// Tạo vào DB
		customerDAO.insert(newCustomer);

		// Gửi mail verification
		Customer customer = customerDAO.createNewVerificationCode(customerID);
		if (customer != null) {
			String subject = "XÁC THỰC TÀI KHOẢN - LAOZI BOOK";
			String content = "Nhấp vào liên kết phía dưới để tiến hành xác thực tài khoản:\n" + path
					+ "/customer?action=verifyAccount&customerID=" + customerID + "&code="
					+ customer.getVerficationCode();
			System.out.println(content);
			MyEmailService.sendEmail(customer.getEmail(), subject, content);
			registerMsg = "Vui lòng kiểm tra email để tiến hành xác thực tài khoản.";
		}

		request.setAttribute("errorMsg", errorMsg);
		request.setAttribute("registerMsg", registerMsg);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void verifyAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		/**
		 * Nếu đường link không hợp lệ (user chỉnh sửa) -> redirect trang chủ hoặc 404
		 * -> ok Nếu đường link có thông tin, check nếu hợp lệ -> forward đến trang
		 * thông báo thành công -> ok check code và expiration time nếu không hợp lệ ->
		 * thông báo người dùng có thể resend để nhận link mới ->
		 */

		String customerID = request.getParameter("customerID");
		String code = request.getParameter("code");
		CustomerDAO customerDAO = new CustomerDAO();

		String verifyMsg = "";
		String verifyError = "";
		String url = "/customer/verification.jsp";
		Customer customer = customerDAO.getVerificationCode(customerID);

		if (customer == null) {
			response.sendRedirect("index.jsp");
		} else {
			// Verify code, expired time < current time
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime currentTime = LocalDateTime.now();
			LocalDateTime expiredTime = LocalDateTime.parse(customer.getCodeExpiredTime(), formatter);

			if (code.equals(customer.getVerficationCode()) && (expiredTime.compareTo(currentTime) > 0)) {
				customerDAO.verifyAccount(customerID);
				verifyMsg = "Xác thực thành công. Giờ đây bạn có thể đăng nhập bằng tài khoản của mình.";
			} else {
				verifyError = "Đường liên kết xác thực đã hết hiệu lực.";
			}

			request.setAttribute("verifyMsg", verifyMsg);
			request.setAttribute("verifyError", verifyError);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

	private void resendVerificationCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();

		String customerID = request.getParameter("customerID");

		System.out.println(customerID + ", " + customerID);

		CustomerDAO customerDAO = new CustomerDAO();

		String url = "/customer/verification.jsp";
		String resendMsg = "";
		Customer customer = customerDAO.createNewVerificationCode(customerID);
		if (customer != null) {
			String subject = "XÁC THỰC TÀI KHOẢN - LAOZI BOOK";
			String content = "Nhấp vào liên kết phía dưới để tiến hành xác thực tài khoản:\n" + path
					+ "/customer?action=verifyAccount&customerID=" + customerID + "&code="
					+ customer.getVerficationCode();
			System.out.println(content);
			MyEmailService.sendEmail(customer.getEmail(), subject, content);
			resendMsg = "Vui lòng kiểm tra email để tiến hành xác thực tài khoản.";
		} else {
			resendMsg = "Xảy ra lỗi trong quá trình yêu cầu xác thực. Vui lòng thử lại sau.";
		}

//		
//		String verifyMsg = "";
//		String verifyError = "";
//		String url = "/customer/verification.jsp";
//		Customer customer = customerDAO.getVerificationCode(customerID);
//		System.out.println("customer: " + customer);
//		
//		
//		if (customer == null) {
//			response.sendRedirect("index.jsp");
//		} else {
//			// Verify code, expired time < current time
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			LocalDateTime currentTime = LocalDateTime.now();
//			LocalDateTime expiredTime = LocalDateTime.parse(customer.getCodeExpiredTime(), formatter);
//			
//			if(code.equals(customer.getVerficationCode()) && (expiredTime.compareTo(currentTime) > 0) ) {
//				verifyMsg = "Xác thực thành công. Giờ đây bạn có thể đăng nhập bằng tài khoản của mình.";
//			}else {
//				verifyError = "Đường liên kết xác thực đã hết hiệu lực.";
//			}
//			
//			request.setAttribute("verifyMsg", verifyMsg);
		request.setAttribute("resendMsg", resendMsg);
//
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
//		}
//		
	}

	private void updatePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = null;
		String noMatchPasswordError = "";
		String wrongPasswordError = "";
		String expiredSessionError = "";
		String updatePasswordMsg = "";
		int result = 0;

		// Get data
		HttpSession session = request.getSession();
		String url = "/profile.jsp";
		String passsword = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String repeatPassword = request.getParameter("repeatPassword");
		passsword = MyEncryption.toSHA1(passsword);
		newPassword = MyEncryption.toSHA1(newPassword);
		repeatPassword = MyEncryption.toSHA1(repeatPassword);

		// Get user from session
		Object obj = session.getAttribute("customer");
		if (obj == null) {
			expiredSessionError = "Vui lòng đăng nhập lại.";
			url = "/index.jsp";
		} else {
			customer = (Customer) session.getAttribute("customer");
			System.out.println(customer);
			if (!customer.getPassword().equals(passsword)) {
				wrongPasswordError = "Mật khẩu hiên tại không chính xác.";
			} else {
				if (!newPassword.equals(repeatPassword)) {
					noMatchPasswordError = "Mật khẩu không khớp. Vui lòng nhập lại.";
				} else {
					// Update password into database
					result = customerDAO.updatePassword(customer.getUsername(), newPassword);
					if (result > 0) {
						updatePasswordMsg = "Đổi mật khẩu thành công";
					} else {
						updatePasswordMsg = "Lỗi trong quá trình cập nhật. Vui lòng thử lại.";
					}
				}
			}

		}

		request.setAttribute("noMatchPasswordError", noMatchPasswordError);
		request.setAttribute("wrongPasswordError", wrongPasswordError);
		request.setAttribute("expiredSessionError", expiredSessionError);
		request.setAttribute("updatePasswordMsg", updatePasswordMsg);

		// để nhận biết và xử lý event chuyển tới tab đổi mật khẩu
		request.setAttribute("isUpdatePassword", "isUpdatePassword");

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void updateProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fullName = request.getParameter("fullName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String dob = request.getParameter("dob");

		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = null;
		String updateProfileMsg = "";
		int result = 0;
		String url = "/profile.jsp";

		// Get user from session
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("customer");
		if (obj == null) {
			url = "/index.jsp";
		} else {
			customer = (Customer) session.getAttribute("customer");

			customer.setFullName(fullName);
			customer.setPhone(phone);
			customer.setAddress(address);
			customer.setEmail(email);
			customer.setSex(sex);
			customer.setDob(dob);
			result = customerDAO.update(customer);
		}

		if (result > 0) {
			updateProfileMsg = "Cập nhật thành công.";
//			customer = customerDAO.selectById(customer.getCustomerID());
			session.setAttribute("customer", customer);
		} else {
			updateProfileMsg = "Cập nhật thất bại. Vui lòng thử lại.";
		}

		request.setAttribute("updateProfileMsg", updateProfileMsg);
		// để nhận biết và xử lý event chuyển tới tab cập nhật hồ sơ
//		request.setAttribute("isUpdateProfile", "isUpdateProfile");

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void updateNotification(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = null;

		String isRegisteredNotification = request.getParameter("isRegisteredNotification");
		String updateNotificationMsg = "";
		int result = 0;
		String url = "/profile.jsp";

		// Get user from session
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("customer");
		if (obj == null) {
			url = "/index.jsp";
		} else {
			customer = (Customer) session.getAttribute("customer");
			result = customerDAO.updateAFieldByID(customer.getCustomerID(), "notificationregistration",
					isRegisteredNotification);
		}
		if (result > 0) {
			updateNotificationMsg = "Cập nhật thành công.";
			customer = customerDAO.selectById(customer.getCustomerID());
			session.setAttribute("customer", customer);
		} else {
			updateNotificationMsg = "Cập nhật thất bại. Vui lòng thử lại.";
		}

		request.setAttribute("updateNotificationMsg", updateNotificationMsg);
		// để nhận biết và xử lý event chuyển tới tab cập nhật thông báo
		request.setAttribute("isUpdateNotification", "isUpdateNotification");

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
