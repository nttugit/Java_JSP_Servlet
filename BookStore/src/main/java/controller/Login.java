package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDAO customerDAO = new CustomerDAO();
		String username = request.getParameter("username");
		String passsword = request.getParameter("password");
		
		System.out.println("username: " + username);
		System.out.println("passsword: " + passsword);
		
		request.setAttribute("username", username);
		request.setAttribute("password", passsword);
		boolean isSucceeded = customerDAO.login(username, passsword);
		System.out.println("isSucceeded: " + isSucceeded);
		String url = "/";
		String loginError = "";
		if (!isSucceeded) {
			loginError = "Tên đăng nhập hoặc mật khẩu không chính xác.";
//			url = "/";
		}
		
		request.setAttribute("loginError", loginError);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
