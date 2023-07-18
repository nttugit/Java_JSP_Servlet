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
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/update-profile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		if(result > 0) {
			updateProfileMsg = "Cập nhật thành công.";
//			customer = customerDAO.selectById(customer.getCustomerID());
			session.setAttribute("customer", customer);
		}else {
			updateProfileMsg = "Cập nhật thất bại. Vui lòng thử lại.";
		}
		
		request.setAttribute("updateProfileMsg", updateProfileMsg);
		// để nhận biết và xử lý event chuyển tới tab cập nhật hồ sơ
//		request.setAttribute("isUpdateProfile", "isUpdateProfile");

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
