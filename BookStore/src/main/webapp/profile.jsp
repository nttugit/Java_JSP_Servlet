<%@page import="model.Customer" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <meta name="viewport" content="width=device-width, intial-scale=1, shrink-to-fit=no">
            <title>Laozi Book | Tài khoản</title>
            <link rel="icon" type="image/x-icon" href="./img/green-book-icon.png">
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

                .right-image {
                    display: flex;
                    align-items: center;
                    justify-content: center;
                }

                .right-image img {
                    width: 50%;
                }
            </style>
        </head>

        <body>
            <% String path=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath(); %>
                <% Customer customer=session.getAttribute("customer") !=null ? (Customer)
                    session.getAttribute("customer") : null; if(customer==null) { String redirectURL=path +"/";
                    response.sendRedirect(redirectURL); } %>


                    <% String noMatchPasswordError=(request.getAttribute("noMatchPasswordError") !=null) ?
                        request.getAttribute("noMatchPasswordError") + "" : "" ; String
                        wrongPasswordError=(request.getAttribute("wrongPasswordError") !=null) ?
                        request.getAttribute("wrongPasswordError") + "" : "" ; String
                        expiredSessionError=(request.getAttribute("expiredSessionError") !=null) ?
                        request.getAttribute("expiredSessionError") + "" : "" ; String
                        updateMsg=(request.getAttribute("updateMsg") !=null) ? request.getAttribute("updateMsg") + ""
                        : "" ; %>

                        <% String errorMsg=(request.getAttribute("errorMsg") !=null) ? request.getAttribute("errorMsg")
                            + "" : "" ; String username=(request.getAttribute("username") !=null) ?
                            request.getAttribute("username") + "" : "" ; String
                            fullName=(request.getAttribute("fullName") !=null) ? request.getAttribute("fullName") + ""
                            : "" ; String phone=(request.getAttribute("phone") !=null) ? request.getAttribute("phone")
                            + "" : "" ; String address=(request.getAttribute("address") !=null) ?
                            request.getAttribute("address") + "" : "" ; String email=(request.getAttribute("email")
                            !=null) ? request.getAttribute("email") + "" : "" ; String sex=(request.getAttribute("sex")
                            !=null) ? request.getAttribute("sex") + "" : "" ; String dob=(request.getAttribute("dob")
                            !=null) ? request.getAttribute("dob") + "" : "" ; String
                            termsConsent=(request.getAttribute("termsConsent") !=null) ?
                            request.getAttribute("termsConsent") + "" : "" ; String
                            isRegisteredNotification=(request.getAttribute("isRegisteredNotification") !=null) ?
                            request.getAttribute("isRegisteredNotification") + "" : "" ; %>

                            <% if(customer !=null){ %>
                                <div class="container">
                                    <div class="register-wrapper">
                                        <h1 class="text-center">THÔNG TIN TÀI KHOẢN</h1>

                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="<%= path %>/">Trang chủ</a></li>
                                                <li class="breadcrumb-item active" aria-current="page">Thông tin tài
                                                    khoản
                                                </li>
                                            </ol>
                                        </nav>
                                        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link active" id="pills-home-tab"
                                                    data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
                                                    role="tab" aria-controls="pills-home" aria-selected="true">Hồ
                                                    sơ</button>
                                            </li>
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill"
                                                    data-bs-target="#pills-profile" type="button" role="tab"
                                                    aria-controls="pills-profile" aria-selected="false">Đổi mật
                                                    khẩu</button>
                                            </li>
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill"
                                                    data-bs-target="#pills-contact" type="button" role="tab"
                                                    aria-controls="pills-contact" aria-selected="false">Cài đặt thông
                                                    báo</button>
                                            </li>
                                        </ul>
                                        <div class="tab-content" id="pills-tabContent">
                                            <!-- TAB 1: HỒ SƠ -->
                                            <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                                                aria-labelledby="pills-home-tab">
                                                <div class="row">
                                                    <div class="user_info col-6">
                                                        <form action="" class="form" method="POST">
                                                            <div class="red" id="errorMsg">
                                                                <%= errorMsg %>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="username" class="form-label">Tên đăng
                                                                    nhập</label>
                                                                <span class="red">*</span>
                                                                <input type="text" class="form-control" id="username"
                                                                    name="username" value="<%= 
                                                            customer.getUsername() %>" disabled>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="fullName" class="form-label">Họ và
                                                                    tên</label>
                                                                <span class="red">*</span>
                                                                <input type="text" class="form-control" id="fullName"
                                                                    name="fullName" required value="<%= 
                                                           customer.getFullName()
                                                            
                                                            %>">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="phone" class="form-label">Số điện
                                                                    thoại</label>
                                                                <span class="red">*</span>
                                                                <input type="text" class="form-control" id="phone"
                                                                    name="phone" required
                                                                    value="<%= customer.getPhone() %>">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="address" class="form-label">Địa chỉ</label>
                                                                <span class="red">*</span>
                                                                <input type="text" class="form-control" id="address"
                                                                    name="address" required
                                                                    value="<%= customer.getAddress() %>">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="email" class="form-label">Email</label>
                                                                <input type="email" class="form-control" id="email"
                                                                    name="email" value="<%=  customer.getEmail()  %>">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="sex" class="form-label">Giới tính</label>
                                                                <select name="sex" id="sex" class="form-control">
                                                                    <!-- xu ly here -->

                                                                    <option value="1" <%=(sex=="1" ) ? "selected" : ""
                                                                        %>
                                                                        >Nam
                                                                    </option>
                                                                    <option value="0" <%=(sex=="0" ) ? "selected" : ""
                                                                        %>
                                                                        >Nữ
                                                                    </option>
                                                                    <option value="2" <%=(sex=="2" ) ? "selected" : ""
                                                                        %>
                                                                        >Khác
                                                                    </option>
                                                                </select>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="dob" class="form-label">Ngày sinh</label>
                                                                <input name="dob" id="dob" type="date"
                                                                    class="form-control"
                                                                    value="<%=  customer.getDob() %>">
                                                            </div>
                                                            <button type="submit" class="btn btn-primary"
                                                                id="profileSubmitBtn">
                                                                Cập nhật
                                                            </button>
                                                        </form>
                                                    </div>

                                                    <div class="right-image col-6">
                                                        <img src="https://top-10.vn/wp-content/uploads/2021/10/2-8.png.webp"
                                                            alt="">
                                                    </div>
                                                </div>

                                            </div>
                                            <!-- TAB 2: ĐỔI MẬT KHẨU -->
                                            <div class="tab-pane fade" id="pills-profile" role="tabpanel"
                                                aria-labelledby="pills-profile-tab">

                                                <div class="row">
                                                    <div class="user_info col-6">
                                                        <form action="update-password" class="form" method="POST">
                                                            <div class="red">
                                                                <%= updateMsg %>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="password" class="form-label">Nhập mật khẩu
                                                                    cũ</label>
                                                                <span class="red">* <%= wrongPasswordError %></span>
                                                                <input type="password" class="form-control"
                                                                    id="password" name="password" required>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="newPassword" class="form-label">Nhập mật
                                                                    khẩu
                                                                    mới
                                                                    khẩu</label> <span class="red">*</span>
                                                                <input type="password" class="form-control"
                                                                    id="newPassword" name="newPassword" required>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="repeatPassword" class="form-label">Nhập lại
                                                                    mật
                                                                    khẩu</label>
                                                                <span class="red">* <%= noMatchPasswordError %></span>
                                                                <input type="password" class="form-control"
                                                                    id="repeatPassword" name="repeatPassword" required>
                                                            </div>
                                                            <button type="submit" class="btn btn-primary"
                                                                id="passwordSubmitBtn">
                                                                Cập nhật
                                                            </button>
                                                        </form>
                                                    </div>
                                                    <div class="right-image col-6">
                                                        <img src="https://static.8cache.com/cover/o/eJzLyTDW1zULTa4wdYuyiA8I1A8zytT1cDIwzfDy1HeEgoC0bH1j78QU55DEcnMzRw-TwjwPf3MXT0en7NzMdJNMt8x033Rn53z9YgMAsFUYBA==/nha-gia-kim-cau-chuyen-mot-giac-mo.jpg"
                                                            alt="">
                                                    </div>
                                                </div>

                                            </div>
                                            <!-- TAB 3: CÀI ĐẶT THÔNG BÁO -->
                                            <div class="tab-pane fade" id="pills-contact" role="tabpanel"
                                                aria-labelledby="pills-contact-tab">
                                                <div class="row">
                                                    <div class="user_info col-6">
                                                        <form action="" class="form" method="POST">
                                                            <div class="red" id="errorMsg">
                                                                <%= errorMsg %>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="isRegisteredNotification"
                                                                    class="form-label">Đăng ký
                                                                    nhận mail
                                                                    khuyến
                                                                    mãi</label>
                                                                <!-- <br> -->
                                                                <input type="checkbox" class="form-check-input"
                                                                    id="isRegisteredNotification"
                                                                    name="isRegisteredNotification"
                                                                    <%=customer.isRegisteredNotification() !=false
                                                                    ? "checked" : "unchecked" %>
                                                                >
                                                            </div>
                                                            <button type="submit" class="btn btn-primary"
                                                                id="otherSettingSubmitBtn">
                                                                Cập nhật
                                                            </button>
                                                        </form>
                                                    </div>
                                                    <div class="right-image col-6">
                                                        <img src="https://product.hstatic.net/200000017360/product/bia-1_ong-gia-va-bien-ca_615e3ecae186401ea06865301bce1a21_master.png"
                                                            alt="">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- <div class="register-form col-6">

                                    <form action="do-register" class="form" method="POST">

                                        <a href="index.jsp">
                                            < Trang chủ</a>

                                    </form>
                                </div> -->
                                        <!-- <div class="register-image col-6">
                                    <img src="<%= path %>/img/bia-sach-ton-tu.png" alt="">
                                </div> -->
                                    </div>
                                </div>
                                <br>
                                <% } %>
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

                                    <!-- End Footer -->
                                    <script
                                        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                                        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                                        crossorigin="anonymous"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
                                        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
                                        crossorigin="anonymous"></script>
        </body>

        </html>