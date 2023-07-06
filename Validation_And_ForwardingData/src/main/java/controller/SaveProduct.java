package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/save-product")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String productID = request.getParameter("productID");
		String productName = request.getParameter("productName");
		String productCostPrice = request.getParameter("productCostPrice");
		String productRetailPrice = request.getParameter("productRetailPrice");
		String productExpiredDate = request.getParameter("productExpiredDate");
		String productVAT = request.getParameter("productVAT");
		String productDesc = request.getParameter("productDesc");
		
		
		String url = "/success.jsp";
		
		// validate
		String error_productID = "";
		
		if(productID == null || productID.trim().length() == 0) {
			error_productID = "Vui lòng nhập mã sản phẩm!";
		}else if(productID.equals("123")) {
			error_productID = "Mã sản phẩm đã tồn tại!";
		}
		
		if(error_productID.length() > 0) {
			url = "/product.jsp";
		}
		
		request.setAttribute("error_productID", error_productID);
		request.setAttribute("productID", productID);
		request.setAttribute("productName", productName);
		request.setAttribute("productCostPrice", productCostPrice);
		request.setAttribute("productRetailPrice", productRetailPrice);
		request.setAttribute("productExpiredDate", productExpiredDate);
		request.setAttribute("productVAT", productVAT);
		request.setAttribute("productDesc", productDesc);

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
