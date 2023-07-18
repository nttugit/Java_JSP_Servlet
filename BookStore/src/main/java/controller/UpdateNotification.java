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

/**
 * Servlet implementation class UpdateNotification
 */
@WebServlet("/update-notification")
public class UpdateNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateNotification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		if(result > 0) {
			updateNotificationMsg = "Cập nhật thành công.";
			customer = customerDAO.selectById(customer.getCustomerID());
			session.setAttribute("customer", customer);
		}else {
			updateNotificationMsg = "Cập nhật thất bại. Vui lòng thử lại.";
		}
		
		request.setAttribute("updateNotificationMsg", updateNotificationMsg);
		// để nhận biết và xử lý event chuyển tới tab cập nhật thông báo
		request.setAttribute("isUpdateNotification", "isUpdateNotification");

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
