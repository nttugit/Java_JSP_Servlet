<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, intial-scale=1, shrink-to-fit=no">
<title>Laozi Book | Đăng ký</title>
<link rel="icon" type="image/x-icon"
	href="../img/green-book-icon.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>



<style>
body {
	background-color: rgb(236, 238, 240);
}

.red {
	color: red;
}

#termsConsent {
	width: 20px;
}

/* .register-wrapper {
                display: flex;
            } */

/* .register-form,
            .register-image {
                flex: 1;
            } */

/* .register-image {
                display: flex;
                padding-left: 40px;
            } */
.register-image {
	display: flex;
	justify-content: center;
	align-items: center;
}

.register-image img {
	width: 100%;
}
</style>
</head>

<body>

	<%
	String errorMsg = (request.getAttribute("errorMsg") != null) ? request.getAttribute("errorMsg") + "" : "";
	String username = (request.getAttribute("username") != null) ? request.getAttribute("username") + "" : "";
	String password = (request.getAttribute("password") != null) ? request.getAttribute("password") + "" : "";
	String repeatPassword = (request.getAttribute("repeatPassword") != null)
			? request.getAttribute("repeatPassword") + ""
			: "";
	String fullName = (request.getAttribute("fullName") != null) ? request.getAttribute("fullName") + "" : "";
	String phone = (request.getAttribute("phone") != null) ? request.getAttribute("phone") + "" : "";
	String address = (request.getAttribute("address") != null) ? request.getAttribute("address") + "" : "";
	String email = (request.getAttribute("email") != null) ? request.getAttribute("email") + "" : "";
	String sex = (request.getAttribute("sex") != null) ? request.getAttribute("sex") + "" : "";
	String dob = (request.getAttribute("dob") != null) ? request.getAttribute("dob") + "" : "";
	String termsConsent = (request.getAttribute("termsConsent") != null) ? request.getAttribute("termsConsent") + "" : "";
	String isRegisteredNotification = (request.getAttribute("isRegisteredNotification") != null)
			? request.getAttribute("isRegisteredNotification") + ""
			: "";
	%>

	<!-- Header -->
	<%@ include file="../header.jsp"%>

	<!--  Main content -->
	<div class="container">
		<div class="register-wrapper row">
			<h2 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h1>

			<div class="register-form col-6">

				<form action="customer" class="form" method="POST">
					<input type="hidden" name="action" value="register">

					<div class="red" id="errorMsg">
						<%=errorMsg%>
					</div>
					<h3>Thông tin đăng nhập</h3>
					<div class="mb-3">
						<label for="username" class="form-label">Tên đăng nhập</label> <span
							class="red">*</span> <input type="text" class="form-control"
							id="username" name="username" value="<%=username%>" required>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mật khẩu</label> <span
							class="red">*</span> <input type="password" class="form-control"
							id="password" name="password" value="<%=password%>" required>
					</div>
					<div class="mb-3">
						<label for="repeatPassword" class="form-label">Nhập lại
							mật khẩu</label> <span class="red">*</span> <input type="password"
							class="form-control" id="repeatPassword" name="repeatPassword"
							value="<%=repeatPassword%>" required>
					</div>
					<h3>Thông tin liên lạc</h3>
					<div class="mb-3">
						<label for="fullName" class="form-label">Họ và tên</label> <span
							class="red">*</span> <input type="text" class="form-control"
							id="fullName" name="fullName" required value="<%=fullName%>">
					</div>
					<div class="mb-3">
						<label for="phone" class="form-label">Số điện thoại</label> <span
							class="red">*</span> <input type="text" class="form-control"
							id="phone" name="phone" required value="<%=phone%>">
					</div>
					<div class="mb-3">
						<label for="address" class="form-label">Địa chỉ</label> <span
							class="red">*</span> <input type="text" class="form-control"
							id="address" name="address" required value="<%=address%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							value="<%=email%>">
					</div>
					<div class="mb-3">
						<label for="sex" class="form-label">Giới tính</label> <select
							name="sex" id="sex" class="form-control">
							<!-- xu ly here -->

							<option value="1" <%=(sex == "1") ? "selected" : ""%>>Nam</option>
							<option value="0" <%=(sex == "0") ? "selected" : ""%>>Nữ</option>
							<option value="2" <%=(sex == "2") ? "selected" : ""%>>Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="dob" class="form-label">Ngày sinh</label> <input
							name="dob" id="dob" type="date" class="form-control"
							value="<%=dob%>">

					</div>

					<!-- <div class="mb-3">
                            <label for="deliveryAddress" class="form-label">Địa chỉ nhận hàng</label>
                            <input type="text" class="form-control" id="deliveryAddress" name="deliveryAddress">
                        </div> -->
					<div class="mb-3">
						<label for="termsConsent" class="form-label">Tôi đã đọc và
							đông ý với <a href="/terms">điều khoản</a> của công ty
						</label> <span class="red">*</span>
						<!-- <br> -->
						<input type="checkbox" class="form-check-input" id="termsConsent"
							name="termsConsent"
							<%=termsConsent != "" ? "checked" : "unchecked"%> required>
					</div>
					<div class="mb-3">
						<label for="isRegisteredNotification" class="form-label">Đăng
							ký nhận mail khuyến mãi</label>
						<!-- <br> -->
						<input type="checkbox" class="form-check-input"
							id="isRegisteredNotification" name="isRegisteredNotification"
							<%=isRegisteredNotification != "" ? "checked" : "unchecked"%>>
					</div>
					<button type="submit" class="btn btn-primary" id="submitBtn">
						Đăng ký</button>
				</form>
			</div>
			<div class="register-image col-6">
				<img src="<%=path%>/img/bia-sach-ton-tu.png" alt="">
				<!-- <img src="https://salt.tikicdn.com/ts/product/05/89/29/4f3c1118eb1f859204c033758450139e.jpg" -->
				<!-- alt=""> -->

			</div>
		</div>
	</div>
	<br>

	<!-- Footer -->
	<%@ include file="../footer.jsp"%>

	<!-- Login modal -->
	<%@ include file="../loginModal.jsp"%>
	<script>
                    // El = Element
                    const usernameEl = document.getElementById("username");
                    const passwordEl = document.getElementById("password");
                    const repeatPasswordEl = document.getElementById("repeatPassword");
                    const fullNameEl = document.getElementById("fullName");
                    const phoneEl = document.getElementById("phone");
                    const addressEl = document.getElementById("address");

                    const submitBtn = document.getElementById("submitBtn");

                    function checkRepeatPassword() {
                        // Thay đổi dấu sao màu đỏ (*) thành thông báo lỗi, không có lỗi thì để lại dấu sao như cũ
                        const repeatPasswordErrorEl = repeatPasswordEl.previousElementSibling;
                        if (passwordEl.value === repeatPasswordEl.value) {
                            repeatPasswordErrorEl.innerHTML = "*";
                        } else {
                            repeatPasswordErrorEl.innerHTML = "*  Mật khẩu không khớp.";
                        }
                    }

                    function showEmptyError(message, e) {
                        const previousElementSibling = e.target.previousElementSibling;
                        if (e.target.value.length == 0) {
                            previousElementSibling.innerHTML = "* " + message;
                        } else {
                            previousElementSibling.innerHTML = "*";
                        }
                    }


                    // Check Empty Error
                    usernameEl.addEventListener('keyup', (e) => showEmptyError(" Tên đăng nhập không được bỏ trống.", e));
                    fullNameEl.addEventListener('keyup', (e) => showEmptyError(" Họ và tên không được bỏ trống.", e));
                    phoneEl.addEventListener('keyup', (e) => showEmptyError(" Số điện thoại không được bỏ trống.", e));
                    addressEl.addEventListener('keyup', (e) => showEmptyError(" Địa chỉ không được bỏ trống.", e));


                    // Validate confirm password
                    passwordEl.addEventListener("keyup", checkRepeatPassword);
                    repeatPasswordEl.addEventListener("keyup", checkRepeatPassword);


                </script>



</body>

</html>