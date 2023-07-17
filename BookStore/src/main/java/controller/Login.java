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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerDAO customerDAO = new CustomerDAO();
		String username = request.getParameter("username");
		String passsword = request.getParameter("password");
		
		request.setAttribute("username", username);
		request.setAttribute("password", passsword);
		
		passsword = MyEncryption.toSHA1(passsword);
		
	
		Customer customer = customerDAO.login(username, passsword);
		
		String loginError = "";
		if (customer != null) {
			HttpSession session  = request.getSession();
			session.setAttribute("customer", customer);
		} else {
			loginError = "Tên đăng nhập hoặc mật khẩu không chính xác.";
		}

		request.setAttribute("loginError", loginError);
		String url = "/index.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
