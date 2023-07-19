<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>


<%
Customer customer = session.getAttribute("customer") != null ? (Customer) session.getAttribute("customer") : null;
String userFirstName = "";
if (customer != null) {
	String arr[] = customer.getFullName().split(" ");
	userFirstName = arr[arr.length - 1];
}
%>

<nav class=" navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img
			src="<%=path%>/img/logo.png" alt="Bootstrap" height="24">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="<%=path%>/index.jsp">Trang chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Combo
						giảm giá</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Quần Jeans</a></li>
						<li><a class="dropdown-item" href="#">Áoo thun</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
					</ul></li>

			</ul>
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Từ khoá"
					aria-label="Search">
				<button class="btn btn-outline-success" type="button">Tìm</button>
				<!-- <a  

href="register.jsp" class="btn btn-primary" style="white-space: nowrap; margin-left: 10px;">
    ÄÄng kÃ½
</a> -->
				<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal"
   data-whatever="@mdo">ÄÄng nháº­p</button> -->
				<%
				if (customer == null) {
				%>
				<button type="button" class="btn btn-success" data-bs-toggle="modal"
					data-bs-target="#loginModal" data-bs-whatever="@mdo"
					style="white-space: nowrap; margin-left: 10px;">Đăng nhập</button>

				<%
				} else {
				%>
				<!-- <button type="button" class="btn btn-outline-success"
                       style="white-space: nowrap; margin-left: 10px;">
                      userFirstNameame %>

                   </button> -->
				<!-- <button type="button" class="btn btn-success" id="logoutBtn"
                       style="white-space: nowrap; margin-left: 10px;">
                       <a href="logout">ÄÄng xuáº¥t</a>
                   </button> -->

				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle avatar_href_wrapper" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<img id="customerAvatar" src="<%=path%>/img/avatar_tu.jpg"
							alt=""> <%=userFirstName%>
					</a>

						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="<%= path %>/customer/profile.jsp">Tài
									khoản</a></li>
							<li><a class="dropdown-item" href="<%= path %>/customer/my-orders.jsp">Đơn
									mua</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="<%= path %>/customer?action=logout">Đăng
									xuất</a></li>
						</ul></li>
				</ul>
				<%
				}
				%>
			</form>
		</div>
	</div>
</nav>