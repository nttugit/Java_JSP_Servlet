package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Order() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chartset=UTF-8");

		String amount = request.getParameter("amount");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		boolean isError = false;

		// Validate amount
		int validatedAmount = 0;
		try {
			validatedAmount = Integer.parseInt(amount);
		} catch (Exception e) {
			// TODO: handle exception
			isError = true;
			request.setAttribute("error_amount", "Số lượng phải là một số nguyên");
		}

		if (validatedAmount <= 0) {
			isError = true;
			request.setAttribute("error_amount", "Số lượng phải lớn hơn 0");
		}

		// Validate phone
//		String validatedPhone = "";
		Pattern phoneRegexPattern = Pattern.compile("\\d{10}");
		Matcher phoneMatcher = phoneRegexPattern.matcher(phone);
		if (!phoneMatcher.matches()) {
			isError = true;
			request.setAttribute("error_phone", "Số điện thoại bao gồm đúng 10 ký tự");
		}

		// Validate email
//		String validatedEmail = "";
		Pattern emailRegexPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)*");
		Matcher emailMatcher = emailRegexPattern.matcher(email);
		if (!emailMatcher.matches()) {
			isError = true;
			request.setAttribute("error_email", "Email cần đúng định dạng: abc@def.com");
		}
//		System.out.println("amount "+ amount);
//		System.out.println("phone "+ phone);
//		System.out.println("email "+ email);

		request.setAttribute("amount", amount);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		
		String url = "/success.jsp";

		if (isError) {
			url = "/index.jsp";
		}
		System.out.println(url);
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
	}

}
