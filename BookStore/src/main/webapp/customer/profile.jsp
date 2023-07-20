<%@page import="model.Customer" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			<meta name="viewport" content="width=device-width, intial-scale=1, shrink-to-fit=no">
			<title>Laozi Book | Tài khoản</title>
			<link rel="icon" type="image/x-icon" href="../img/green-book-icon.png">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
				crossorigin="anonymous">
			<style>
				body {
					background-color: rgb(236, 238, 240);
				}

				.red {
					color: red;
				}

				.breadcrumb-item a {
					color: rgba(33, 37, 41, 0.75);
				}

				#pills-tab {
					background-color: white;
				}

				.nav-pills .nav-link {
					color: black;
				}

				.nav-pills .nav-link.active,
				.nav-pills .show>.nav-link {
					background-color: #6c757d;
					/* color: white; */
				}

				#termsConsent {
					width: 20px;
				}

				.right-image {
					display: flex;
					align-items: center;
					justify-content: center;
				}

				.right-image img {
					width: 50%;
				}

				.red {
					color: red;
				}

				#logoutBtn a {
					text-decoration: none;
					color: white;
				}

				/* .dropdown-menu>li>a {
					-webkit-transform: rotateY(180deg);
				} */
				.avatar_href_wrapper {
					padding: 5px;
				}

				#customerAvatar {
					width: 30px;
					height: 30px;
					border-radius: 50%;
				}
			</style>
		</head>

		<body>
			<!--  Header -->
			<%@ include file="../layout/header.jsp" %>
				<!-- Lấy thông tin chung (path, customer) -->

				<% if (customer==null) { String redirectURL=path + "/" ; response.sendRedirect(redirectURL); } %>

					<!-- Cập nhật hồ sơ -->
					<% String updateProfileMsg=(request.getAttribute("updateProfileMsg") !=null) ?
						request.getAttribute("updateProfileMsg") + "" : "" ; %>

						<!-- Cập nhật mật khẩu mật khẩu -->
						<% String isUpdatePassword=(request.getAttribute("isUpdatePassword") !=null) ?
							request.getAttribute("isUpdatePassword") + "" : "" ; String
							noMatchPasswordError=(request.getAttribute("noMatchPasswordError") !=null) ?
							request.getAttribute("noMatchPasswordError") + "" : "" ; String
							wrongPasswordError=(request.getAttribute("wrongPasswordError") !=null) ?
							request.getAttribute("wrongPasswordError") + "" : "" ; String
							expiredSessionError=(request.getAttribute("expiredSessionError") !=null) ?
							request.getAttribute("expiredSessionError") + "" : "" ; String
							updatePasswordMsg=(request.getAttribute("updatePasswordMsg") !=null) ?
							request.getAttribute("updatePasswordMsg") + "" : "" ; %>


							<!-- Cập nhật thông báo -->
							<% String isUpdateNotification=(request.getAttribute("isUpdateNotification") !=null) ?
								request.getAttribute("isUpdateNotification") + "" : "" ; String
								updateNotificationMsg=(request.getAttribute("updateNotificationMsg") !=null) ?
								request.getAttribute("updateNotificationMsg") + "" : "" ; %>


								<% if (customer !=null) { %>


									<!--  Main content -->
									<div class="container">
										<div class="">
											<h2 class="text-center">
												THÔNG TIN TÀI KHOẢN
												</h1>

												<nav aria-label="breadcrumb">
													<ol class="breadcrumb">
														<li class="breadcrumb-item"><a href="<%=path%>/">Trang
																chủ</a></li>
														<li class="breadcrumb-item active" aria-current="page">Thông
															tin tài khoản</li>
													</ol>
												</nav>
												<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
													<li class="nav-item" role="presentation">
														<button class="nav-link active" id="pills-update-profile-tab"
															data-bs-toggle="pill" data-bs-target="#pills-update-profile"
															type="button" role="tab"
															aria-controls="pills-update-profile" aria-selected="true">Hồ
															sơ</button>
													</li>
													<li class="nav-item" role="presentation">
														<button class="nav-link" id="pills-update-password-tab"
															data-bs-toggle="pill"
															data-bs-target="#pills-update-password" type="button"
															role="tab" aria-controls="pills-update-password"
															aria-selected="false">Đổi mật khẩu</button>
													</li>
													<li class="nav-item" role="presentation">
														<button class="nav-link" id="pills-update-notification-tab"
															data-bs-toggle="pill"
															data-bs-target="#pills-update-notification" type="button"
															role="tab" aria-controls="pills-update-notification"
															aria-selected="false">Cài
															đặt thông báo</button>
													</li>
												</ul>
												<div class="tab-content" id="pills-tabContent">
													<!-- TAB 1: HỒ SƠ -->

													<div class="tab-pane fade show active" id="pills-update-profile"
														role="tabpanel" aria-labelledby="pills-update-profile-tab">
														<div class="row">
															<div class="user_info col-6">
																<form action="customer" class="form" method="POST">
																	<input type="hidden" name="action"
																		value="updateProfile">
																	<div class="red" id="updateProfileMsg">
																		<%=updateProfileMsg%>
																	</div>
																	<div class="mb-3">
																		<label for="username" class="form-label">Tên
																			đăng nhập</label>
																		<span class="red">*</span> <input type="text"
																			class="form-control" id="username"
																			name="username"
																			value="<%=customer.getUsername()%>"
																			disabled>
																	</div>
																	<div class="mb-3">
																		<label for="fullName" class="form-label">Họ và
																			tên</label> <span class="red">*</span>
																		<input type="text" class="form-control"
																			id="fullName" name="fullName" required
																			value="<%=customer.getFullName()%>">
																	</div>
																	<div class="mb-3">
																		<label for="phone" class="form-label">Số điện
																			thoại</label> <span class="red">*</span>
																		<input type="text" class="form-control"
																			id="phone" name="phone" required
																			value="<%=customer.getPhone()%>">
																	</div>
																	<div class="mb-3">
																		<label for="address" class="form-label">Địa
																			chỉ</label> <span class="red">*</span>
																		<input type="text" class="form-control"
																			id="address" name="address" required
																			value="<%=customer.getAddress()%>">
																	</div>
																	<div class="mb-3">
																		<label for="email"
																			class="form-label">Email</label> <input
																			type="email" class="form-control" id="email"
																			name="email"
																			value="<%=customer.getEmail()%>">
																	</div>
																	<div class="mb-3">
																		<label for="sex" class="form-label">Giới
																			tính</label> <select name="sex" id="sex"
																			class="form-control">
																			<option value="1" <%=(customer.getSex()==1)
																				? "selected" : "" %>>Nam
																			</option>
																			<option value="0" <%=(customer.getSex()==0)
																				? "selected" : "" %>>Nữ
																			</option>
																			<option value="2" <%=(customer.getSex()==2)
																				? "selected" : "" %>>Khác
																			</option>
																		</select>
																	</div>
																	<div class="mb-3">
																		<label for="dob" class="form-label">Ngày
																			sinh</label> <input name="dob" id="dob"
																			type="date" class="form-control"
																			value="<%=customer.getDob()%>">
																	</div>
																	<button type="submit" class="btn btn-success"
																		id="profileSubmitBtn">Cập nhật</button>
																</form>
															</div>

															<div class="right-image col-6">
																<img src="https://top-10.vn/wp-content/uploads/2021/10/2-8.png.webp"
																	alt="">
															</div>
														</div>

													</div>
													<!-- TAB 2: ĐỔI MẬT KHẨU -->
													<span id="isUpdatePassword" hidden>
														<%=isUpdatePassword%>
													</span>
													<div class="tab-pane fade" id="pills-update-password"
														role="tabpanel" aria-labelledby="pills-update-password-tab">

														<div class="row">
															<div class="user_info col-6">
																<form action="customer" class="form" method="POST">
																	<input type="hidden" name="action"
																		value="updatePassword">
																	<div id="updatePasswordMsg" class="red">
																		<%=updatePasswordMsg%>
																	</div>
																	<div class="mb-3">
																		<label for="password" class="form-label">Nhập
																			mật khẩu
																			cũ</label> <span class="red">*
																			<%=wrongPasswordError%>
																		</span> <input type="password"
																			class="form-control" id="password"
																			name="password" required>
																	</div>
																	<div class="mb-3">
																		<label for="newPassword" class="form-label">Nhập
																			mật
																			khẩu mới khẩu</label> <span
																			class="red">*</span> <input type="password"
																			class="form-control" id="newPassword"
																			name="newPassword" required>
																	</div>
																	<div class="mb-3">
																		<label for="repeatPassword"
																			class="form-label">Nhập
																			lại mật khẩu</label> <span class="red">*
																			<%=noMatchPasswordError%>
																		</span> <input type="password"
																			class="form-control" id="repeatPassword"
																			name="repeatPassword" required>
																	</div>
																	<button type="submit" class="btn btn-success"
																		id="passwordSubmitBtn">Cập nhật</button>
																</form>
															</div>
															<div class="right-image col-6">
																<img src="https://static.8cache.com/cover/o/eJzLyTDW1zULTa4wdYuyiA8I1A8zytT1cDIwzfDy1HeEgoC0bH1j78QU55DEcnMzRw-TwjwPf3MXT0en7NzMdJNMt8x033Rn53z9YgMAsFUYBA==/nha-gia-kim-cau-chuyen-mot-giac-mo.jpg"
																	alt="">
															</div>
														</div>

													</div>
													<!-- TAB 3: CÀI ĐẶT THÔNG BÁO -->
													<span id="isUpdateNotification" hidden>
														<%=isUpdateNotification%>
													</span>
													<div class="tab-pane fade" id="pills-update-notification"
														role="tabpanel" aria-labelledby="pills-update-notification-tab">
														<div class="row">
															<div class="user_info col-6">
																<form action="customer" class="form" method="POST">
																	<input type="hidden" name="action"
																		value="updateNotification">

																	<div class="red" id="errorMsg">
																		<%=updateNotificationMsg%>
																	</div>
																	<div class="mb-3">
																		<label for="isRegisteredNotification"
																			class="form-label">Đăng
																			ký nhận mail khuyến mãi</label>
																		<!-- <br> -->
																		<input type="checkbox" class="form-check-input"
																			id="isRegisteredNotification"
																			name="isRegisteredNotification"
																			<%=customer.isRegisteredNotification()
																			!=false ? "checked" : "unchecked" %>>
																	</div>
																	<button type="submit" class="btn btn-success"
																		id="otherSettingSubmitBtn">Cập nhật</button>
																</form>
															</div>
															<div class="right-image col-6">
																<img src="https://product.hstatic.net/200000017360/product/bia-1_ong-gia-va-bien-ca_615e3ecae186401ea06865301bce1a21_master.png"
																	alt="">
															</div>
														</div>
													</div>
												</div>
										</div>
									</div>
									<br>


									<!-- Footer -->
									<%@ include file="../layout/footer.jsp" %>

										<% } %>

											<!-- Xử lý chuyển hướng tab (UX) -->
											<script>
												// Nếu đang là chức năng đổi mặt khẩu thì chuyển tới tab đổi mật khẩu
												document.addEventListener('DOMContentLoaded', function () {
													const updatePasswordTabBtn = document.getElementById('pills-update-password-tab');
													// const updateProfileTabBtn = document.getElementById('pills-update-profile-tab');
													const updateNotificationTabBtn = document.getElementById('pills-update-notification-tab');


													// var button = document.getElementById('pills-update-password-tab'); 
													const isUpdatePassword = document.getElementById("isUpdatePassword");
													// const isUpdateProfile = document.getElementById("isUpdateProfile");
													const isUpdateNotification = document.getElementById("isUpdateNotification");

													if (isUpdatePassword.innerText.includes("isUpdatePassword")) {
														updatePasswordTabBtn.dispatchEvent(new Event('click'));
													}
													// else if (isUpdateProfile.innerText.includes("isUpdateProfile")) {
													//     updateProfileTabBtn.dispatchEvent(new Event('click'));
													// }
													else if (isUpdateNotification.innerText.includes("isUpdateNotification")) {
														updateNotificationTabBtn.dispatchEvent(new Event('click'));
													}
												});

											</script>

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
													// Thay đổi dấu sao màu đỏ (*) thành thông báo lỗi, không có lỗi thì để lại dấu sao như
													cũ
													const repeatPasswordErrorEl = repeatPasswordEl.previousElementSibling;
													if (passwordEl.value === repeatPasswordEl.value) {
														repeatPasswordErrorEl.innerHTML = "*";
													} else {
														repeatPasswordErrorEl.innerHTML = "* Mật khẩu không khớp.";
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
												usernameEl.addEventListener('keyup', (e) => showEmptyError(" Tên đăng nhập không được bỏ
                                trống.", e));
                                fullNameEl.addEventListener('keyup', (e) => showEmptyError(" Họ và tên không được bỏ
                                trống.", e));
                                phoneEl.addEventListener('keyup', (e) => showEmptyError(" Số điện thoại không được bỏ
                                trống.", e));
                                addressEl.addEventListener('keyup', (e) => showEmptyError(" Địa chỉ không được bỏ
                                trống.", e));


                                // Validate confirm password
                                passwordEl.addEventListener("keyup", checkRepeatPassword);
												repeatPasswordEl.addEventListener("keyup", checkRepeatPassword);


                                // submitBtn.addEventListener("click", (e) => {
                                // e.preventDefault();
                                // })



											</script>

											<script
												src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
												integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
												crossorigin="anonymous"></script>
											<script
												src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
												integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
												crossorigin="anonymous"></script>
		</body>

		</html>