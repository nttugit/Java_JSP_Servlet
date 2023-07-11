<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Laozi | Đăng ký</title>
        <link rel="icon" type="image/x-icon" href="./img/green-book-icon.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
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

            .register-wrapper {
                display: flex;
            }

            .register-form,
            .register-image {
                flex: 1;
            }

            .register-image {
                display: flex;
                padding-left: 40px;
                /* text-align: center; */
            }


            /* .register-image img {
                height: 90%;
            } */
        </style>
    </head>

    <body>
        <div class="container">
            <div class="register-wrapper">
                <div class="register-form">
                    <h1 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h1>
                    <form action="" class="form">
                        <h3>Thông tin đăng nhập</h3>
                        <div class="mb-3">
                            <label for="username" class="form-label">Tên đăng nhập</label> <span class="red">*</span>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Mật khẩu</label><span class="red">*</span>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="mb-3">
                            <label for="repeatPassword" class="form-label">Nhập lại mật khẩu</label><span
                                class="red">*</span>
                            <input type="password" class="form-control" id="repeatPassword" name="repeatPassword"
                                required>
                        </div>
                        <h3>Thông tin liên lạc</h3>
                        <div class="mb-3">
                            <label for="fullName" class="form-label">Họ và tên</label> <span class="red">*</span>
                            <input type="text" class="form-control" id="fullName" name="fullBName" required>
                        </div>
                        <div class="mb-3">
                            <label for="phone" class="form-label">Số điện thoại</label> <span class="red">*</span>
                            <input type="text" class="form-control" id="phone" name="phone" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email">
                        </div>
                        <div class="mb-3">
                            <label for="sex" class="form-label">Giới tính</label>
                            <select name="sex" id="sex" class="form-control">
                                <option value="Nam">Nam</option>
                                <option value="Nữ">Nữ</option>
                                <option value="Khác">Khác</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="dob" class="form-label">Ngày sinh</label>
                            <input name="dob" id="dob" type="date" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="address" class="form-label">Địa chỉ</label>
                            <input type="text" class="form-control" id="address" name="address">
                        </div>
                        <!-- <div class="mb-3">
                            <label for="deliveryAddress" class="form-label">Địa chỉ nhận hàng</label>
                            <input type="text" class="form-control" id="deliveryAddress" name="deliveryAddress">
                        </div> -->
                        <div class="mb-3">
                            <label for="termsConsent" class="form-label">Tôi đã đọc và đông ý với <a href="/terms">điều
                                    khoản</a> của
                                công
                                ty</label> <span class="red">*</span>
                            <!-- <br> -->
                            <input type="checkbox" class="form-check-input" id="termsConsent" name="termsConsent"
                                required>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Đăng ký
                        </button>
                    </form>
                </div>
                <div class="register-image">
                    <img src="https://m.media-amazon.com/images/I/71Jk3baRdnL._AC_UF1000,1000_QL80_.jpg" alt="">
                </div>
            </div>
        </div>
        <br>
        <!-- End Footer -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
            integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>
    </body>

    </html>