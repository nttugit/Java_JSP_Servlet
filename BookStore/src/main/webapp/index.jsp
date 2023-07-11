<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Laozi | Trang chủ</title>
        <link rel="icon" type="image/x-icon" href="./img/green-book-icon.png">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <style>

        </style>
    </head>

    <body>


        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="./img/logo.png" alt="Bootstrap" height="24">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Combo giảm giá</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Thể loại
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Quần Jeans</a></li>
                                <li><a class="dropdown-item" href="#">Áo thun</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Hết hàng</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Từ khoá" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Tìm</button>
                        <a href="register.jsp" class="btn btn-primary" style="white-space: nowrap; margin-left: 10px;">
                            Đăng ký
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->

        <!-- Page content -->
        <div class="container">
            <div class="row">
                <!-- Sidebar -->
                <div class="col-lg-3">
                    <div class="list-group">

                        <button type="button" class="list-group-item list-group-item-action">
                            Thời trang nam</button>
                        <button type="button" class="list-group-item list-group-item-action">
                            Thời trang nữ</button>

                        <button type="button" class="list-group-item list-group-item-action">
                            Thời trang unisex</button>
                        <button type="button" class="list-group-item list-group-item-action">
                            Thời trang trung niên
                        </button>
                        <button type="button" class="list-group-item list-group-item-action">
                            Dành cho bé</button>
                    </div>
                </div>
                <!-- End Sidebar -->

                <!-- Slider and products -->
                <div class="col-lg-9">
                    <!-- Slider -->
                    <div id="carouselExampleIndicators" class="carousel slide">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                                class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="./img/slider/slider_1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="./img/slider/slider_2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="./img/slider/slider_3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <!-- End slider -->
                    <!-- Products -->
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="card">
                                <img src="./img/product/product_1.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h4 class="card-title">Jeans Denim Unisex JDU1</h4>
                                    <h5>1,050,000</h5>
                                    <p class="card-text">Thời trang năng động, đẳng cấp chất liệu.</p>
                                    <a href="#" class="btn btn-primary">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card">
                                <img src="./img/product/product_2.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h4 class="card-title">Trench coat Paris TTL</h4>
                                    <h5>2,250,000</h5>
                                    <p class="card-text">Cafe Paris, ngon hơn mọi khi.</p>
                                    <a href="#" class="btn btn-primary">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card">
                                <img src="./img/product/product_3.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h4 class="card-title">Class Suit BM CS21</h4>
                                    <h5>5,50,000</h5>
                                    <p class="card-text">Lịch lãm quý ông, doanh nhân thành đạt.</p>
                                    <a href="#" class="btn btn-primary">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card">
                                <img src="./img/product/product_4.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h4 class="card-title">Dynamic Cool Outfit DCF2</h4>
                                    <h5>1,500,000</h5>
                                    <p class="card-text">Trang phục thoải mái, làm những điều mình thích.
                                    </p>
                                    <a href="#" class="btn btn-primary">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- End Products -->
                </div>
                <!-- End Slider and products -->

            </div>
        </div>
        <!-- End Page content -->
        <!-- Footer -->
        <footer class="bg-dark text-light text-center py-3">
            <div class="container">
                <p>© 2023 laozi.com. All rights reserved.</p>
            </div>
        </footer>
        <!-- End Footer -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
            integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>
    </body>

    </html>