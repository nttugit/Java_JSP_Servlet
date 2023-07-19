<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String loginUsername = (request.getAttribute("username") != null) ? request.getAttribute("username") + "" : "";
String loginPassword = (request.getAttribute("password") != null) ? request.getAttribute("password") + "" : "";
String loginError = (request.getAttribute("loginError") != null) ? request.getAttribute("loginError") + "" : "";
%>


<div class="modal fade" id="loginModal" tabindex="-1"
	aria-labelledby="loginModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="loginModallLabel">
					Login to <span style="color: rgb(0, 104, 0)">Laozi Book</span>
				</h1>
				<img src="./img/green-book-icon.png" width="50px" alt="">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="<%= path %>/customer" method="POST">
					<input type="hidden" name="action" value="login" />
					<div class="red" id="loginError">
						<%=loginError%>
					</div>
					<div class="mb-3">
						<label for="loginUsername" class="col-form-label">Tên đăng
							nhập</label> <input type="text" class="form-control" id="loginUsername"
							name="loginUsername"
							value="<%=loginError != "" ? loginUsername : ""%>" required>
					</div>
					<div class="mb-3">
						<label for="loginPassword" class="col-form-label">Mật khẩu</label>
						<input type="password" class="form-control" id="loginPassword"
							name="loginPassword"
							value="<%=loginError != "" ? loginPassword : ""%>" required>
					</div>
					<div class="mb-3 text-center">
						<a href="customer/forgot-password.jsp">Quên mật khẩu</a> | <a
							href="customer/register.jsp">Đăng ký tài khoản mới</a>
					</div>
					<!-- <div class="modal-footer"> -->
					<div class="mb-3 text-center">
						<button type="submit" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#loginModal">Đăng
							nhập</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>

<script>
	// Kiểm tra nếu thẻ chứa biến loginError có giá trị, nghĩa là có lỗi, thì cho hiển thị lại modal đăng nhập
	$(window).on('load', function() {
		if ($("#loginError").text().toString().indexOf("không") > -1) {
			$('#loginModal').modal('show');
		}
	});
</script>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>