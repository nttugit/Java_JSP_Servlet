
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Laozi Book | Trang chủ</title>
<link rel="icon" type="image/x-icon" href="./img/green-book-icon.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>

<style>
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


	<!-- Header -->
	<%@ include file="header.jsp"%>

	<!-- Page content -->
	<div class="container">
		<div class="row">

			<!-- Sidebar -->
			<jsp:include page="sidebar.jsp"></jsp:include>

			<!-- Slider and products -->
			<div class="col-lg-9">
				<!-- Slider -->
				<div id="carouselExampleIndicators" class="carousel slide">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="./img/slider/slider_1.png" class="d-block w-100"
								alt="...">
						</div>
						<div class="carousel-item">
							<img src="./img/slider/slider_2.png" class="d-block w-100"
								alt="...">
						</div>
						<div class="carousel-item">
							<img src="./img/slider/slider_3.png" class="d-block w-100"
								alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End slider -->
				<!-- Products -->
				<div class="row">
					<div class="col-lg-3">
						<div class="card">
							<img src="./img/product/product_1.png" class="card-img-top"
								alt="...">
							<div class="card-body">
								<h4 class="card-title">Jeans Denim Unisex JDU1</h4>
								<h5>1,050,000</h5>
								<p class="card-text">Thời trang năng động, đẳng cấp chất
									liệu.</p>
								<a href="#" class="btn btn-primary">Mua ngay</a>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="card">
							<img src="./img/product/product_2.png" class="card-img-top"
								alt="...">
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
							<img src="./img/product/product_3.png" class="card-img-top"
								alt="...">
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
							<img src="./img/product/product_4.png" class="card-img-top"
								alt="...">
							<div class="card-body">
								<h4 class="card-title">Dynamic Cool Outfit DCF2</h4>
								<h5>1,500,000</h5>
								<p class="card-text">Trang phục thoải mái, làm những điều
									mình thích.</p>
								<a href="#" class="btn btn-primary">Mua ngay</a>
							</div>
						</div>
					</div>
				</div>

				<!-- End Products -->
			</div>

		</div>
	</div>

	<!-- Footer -->
	<%@ include file="footer.jsp"%>

	<!-- Login modal -->
	<%@ include file="loginModal.jsp"%>


	
</body>

</html>
