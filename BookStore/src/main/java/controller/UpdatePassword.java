package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import model.Customer;
import util.MyEncryption;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/update-password")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = null;
		String noMatchPasswordError = "";
		String wrongPasswordError = "";
		String expiredSessionError = "";
		String updateMsg = "";
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
			customer = (Customer)session.getAttribute("customer");
			if (!customer.getPassword().equals(passsword)) {
				wrongPasswordError = "Mật khẩu hiên tại không chính xác.";
			}else {
				if (!newPassword.equals(repeatPassword)) {
					noMatchPasswordError = "Mật khẩu không khớp. Vui lòng nhập lại.";
				}else {
					// Update password into database
					result = customerDAO.updatePassword(customer.getUsername(), newPassword);
					if (result > 0) {
						updateMsg = "Đổi mật khẩu thành công";
					} else {
						updateMsg = "Lỗi trong quá trình cập nhật. Vui lòng thử lại.";
					}
				}
			}
			
		}

		request.setAttribute("noMatchPasswordError", noMatchPasswordError);
		request.setAttribute("wrongPasswordError", wrongPasswordError);
		request.setAttribute("expiredSessionError", expiredSessionError);
		request.setAttribute("updateMsg", updateMsg);

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
