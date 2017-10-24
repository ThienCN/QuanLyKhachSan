<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Angel Hotel</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href="CSS/bootstrap.min.css">
<script src="JS/jquery-3.2.1.min.js"></script>
<script src="JS/bootstrap.min.js"></script>

<link rel="stylesheet" href="CSS/w3.css">
<link rel="stylesheet" href="CSS/font-awesome.min.css">

<script src="JS/index.js"></script>
<link rel="stylesheet" href="CSS/trangchu.css">

</head>
<body>

	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar" id="myNavbar"
			style="font-size: 17px; line-height: 20px;">
			<a
				class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right"
				href="javascript:void(0);" onclick="toggleFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="#home" class="w3-bar-item w3-button w3-hide-small">Trang
				chủ</a> <a href="#room" class="w3-bar-item w3-button w3-hide-small">Phòng</a>
			<a href="#food" class="w3-bar-item w3-button w3-hide-small"> Dịch
				vụ</a> <a href="#event" class="w3-bar-item w3-button w3-hide-small">Sự
				kiện</a> <a href="#info" class="w3-bar-item w3-button w3-hide-small">Thông
				tin</a> <a href="#contact" class="w3-bar-item w3-button w3-hide-small">Liên
				hệ</a> <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right"
				id="login" style="margin-right: 20px"><i class="fa fa-user"></i>
				Đăng nhập</a>
		</div>

		<!-- Navbar on small screens-->
		<div id="navDemo"
			class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
			<a href="#room" class="w3-bar-item w3-button"
				onclick="toggleFunction()">Phòng</a> <a href="#food"
				class="w3-bar-item w3-button" onclick="toggleFunction()">Dịch vụ</a>
			<a href="#event" class="w3-bar-item w3-button"
				onclick="toggleFunction()">Sự kiện</a> <a href="#info"
				class="w3-bar-item w3-button" onclick="toggleFunction()">Thông
				tin</a> <a href="#contact" class="w3-bar-item w3-button"
				onclick="toggleFunction()">Liên hệ</a> <a href="#"
				class="w3-bar-item w3-button"><i class="fa fa-user"></i> Đăng
				nhập</a>
		</div>
	</div>

	<!--Banner-->
	<div class="parallax1" id="home">
		<div class="centered">
			<span style="font-size: 120px; color: lightgray">A n g e l</span> <span
				id="hotel1">Hotel</span>
			<p class="w3-animate-fading" style="margin-top: 35px">
				<a id="book1" href="#container1"
					style="color: lightgray; font-size: 20px">Đặt phòng <span
					id="show1"> >></span></a>
			</p>
		</div>
	</div>

	<!--Reservation-->
	<div class="container" id="container1">
		<div class="row">
			<div class="col-xs-12 col-sm-5 col-md-5">
				<div
					class="embed-responsive embed-responsive-16by9 wowload fadeInLeft">
					<video style="width: 100%" autoplay muted loop> <source
						src="Images/VideoHotel.mp4" type="video/mp4"> Your
					browser does not support the video tag. </video>
				</div>
			</div>
			<br>

			<div class="col-xs-12 col-sm-5 col-md-5">
				<h2 class="datphong">Đặt phòng</h2>
				<form role="form" class="wowload fadeInRight">
					<div class="form-group">
						<div class="col-sm-6" style="line-height: 35px">
							Ngày nhận phòng: <input type="date" class="form-control"><br>
						</div>
						<div class="col-sm-6" style="line-height: 35px">
							Ngày trả phòng: <input type="date" class="form-control"><br>
						</div>
					</div>
					<div class="col-sm-4" style="float: right">
						<button class="btn w3-button">Tìm phòng</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>

	<!--About-->
	<div class="parallax2" id="home">
		<div class="centered2 w3-padding w3-white w3-opacity">
			<b style="line-height: 90px; font-size: 20px">A&nbsp;&nbsp;&nbsp;N&nbsp;&nbsp;&nbsp;G&nbsp;&nbsp;&nbsp;E&nbsp;&nbsp;&nbsp;L</b><br>
			<br>
			<p style="line-height: 35px">
				<b> Cách trung tâm thành phố 2km, cách sân bay 3km<br>Nằm
					sát bờ biển trong xanh với bãi cát vàng thơ mộng<br>Những căn
					phòng quyến rũ, rộng rãi, sang trọng và đầy đủ tiện nghi<br>Dịch
					vụ ăn uống, thể thao, du lịch biển đầy hấp dẫn và phong phú<br>Một
					nơi nghĩ dưỡng tuyệt vời bên cạnh những người bạn thương yêu ♥
				</b>
			</p>
		</div>
	</div>

	<!--Rooms-->
	<div class="container" style="padding: 50px;">
		<h2 style="text-align: center; color: #0d875c">P H Ò N G</h2>
		<h4 style="text-align: center; font-size: 30px; color: #0d875c">__</h4>
		<br>
		<div class="col-sm-5"
			style="padding: 70px 25px 25px 25px; text-align: center">
			<p>Những căn phòng đạt chất lượng 5 sao với đầy đủ tiện nghi,
				phòng rộng rãi, thoáng mát, chăn ấm, nệm êm, ánh đèn lung linh huyền
				ảo, màu sắc bắt mắt cùng với hướng nhìn ra biển tuyệt đẹp</p>
			<a href="#" id="book1">Xem phòng</a>
		</div>
		<div class="col-sm-1"></div>
		<div class=" wowload fadeInLeft col-sm-6">
			<video width="100%" autoplay muted loop> <source
				src="Images/Video.mp4" type="video/mp4"> Your browser does
			not support the video tag. </video>
		</div>
	</div>

	<!--Services-->
	<div class="w3-padding-64" id="portfolio">
		<h2 style="text-align: center; color: #0d875c">D Ị C H V Ụ</h2>
		<h4 style="text-align: center; font-size: 30px; color: #0d875c">__</h4>
		<br>


		<!-- Responsive Grid. Four columns on tablets, laptops and desktops. Will stack on mobile devices/small screens (100% width) -->
		<div class="w3-row-padding w3-center" style="padding: 0 75px">
			<div class="w3-col m4 showimg">
				<img src="Images/pic1.jpg"
					style="width: 100%; margin-bottom: -100px" class="w3-hover-opacity"
					alt="Free-Wifi">
				<div class="overlay">
					<div class="text">
						<h2>Free Wi-fi</h2>
						<p>Check-in, lướt web, nộp báo cáo</p>
					</div>
				</div>
			</div>

			<div class="w3-col m4 showimg">
				<img src="Images/pic2a.jpg"
					style="width: 100%; margin-bottom: -100px" class="w3-hover-opacity"
					alt="Dining">
				<div class="overlay">
					<div class="text">
						<h2>Ăn tối</h2>
						<p>Một bữa tối thịnh soạn cùng ly rượu vang thơm nồng bên ánh
							đèn lung linh</p>
					</div>
				</div>
			</div>

			<div class="w3-col m4 showimg">
				<img src="Images/pic3.jpg"
					style="width: 100%; margin-bottom: -100px" class="w3-hover-opacity"
					alt="Drink">
				<div class="overlay">
					<div class="text">
						<h2>Thức uống</h2>
						<p>Một ly cafe mỗi sáng thức dậy hay vài ly bia cùng bạn bè</p>
					</div>
				</div>
			</div>
		</div>
		<br> <br> <br> <br> <br> <br>
		<div class="w3-row-padding w3-center" style="padding: 0 75px">
			<div class="w3-col m4 showimg">
				<img src="Images/pic4.jpg"
					style="width: 100%; margin-bottom: -100px" class="w3-hover-opacity"
					alt="Pool">
				<div class="overlay">
					<div class="text">
						<h2>Thư giản</h2>
						<p>Đắm mình trong làn nước trong xanh của hồ bơi hoặc thỏa sức
							với những cơn sóng của biển</p>
					</div>
				</div>
			</div>

			<div class="w3-col m4 showimg">
				<img src="Images/pic5.jpg"
					style="width: 100%; margin-bottom: -100px" class="w3-hover-opacity"
					alt="Spa">
				<div class="overlay">
					<div class="text">
						<h2>Spa</h2>
						<p>Thư giãn với những dịch vụ massage và đắm chìm trong hương
							thơm của thảo dược</p>
					</div>
				</div>
			</div>

			<div class="w3-col m4 showimg">
				<img src="Images/pic6.jpg"
					style="width: 100%; margin-bottom: -100px" class="w3-hover-opacity"
					alt="Housekeeping">
				<div class="overlay">
					<div class="text">
						<h2>Giặt ủi</h2>
						<p>Trắng sáng, thơm tho và thẳng thớm</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="w3-center">
		<button class="w3-button w3-padding-large"
			style="margin-top: 90px; margin-bottom: 70px; color: #0d875c"
			onclick="appendText()" id="loadbtn">XEM THÊM</button>
	</div>

	<!--Contact-->
	<div class="parallax3 w3-opacity-min">
		<div class="centered">
			<span style="font-size: 35px; color: white">L I Ê
				N&nbsp;&nbsp;H Ệ</span>
		</div>
	</div>
	<div class="w3-content w3-container" style="padding-bottom: 64px">
		<h2 style="text-align: center; color: #0d875c">ĐẾN VỚI CHÚNG TÔI</h2>
		<div class="w3-row">
			<div class="w3-col m4 w3-container">
				<div id="googleMap" class="w3-round-large"
					style="height: 400px; position: relative; overflow: hidden;">
					<a
						href="https://www.google.com/maps/place/Hyatt+Regency+Danang+Resort+and+Spa/@16.0130941,108.2621455,17z/data=!4m5!3m4!1s0x314210cf6a42c159:0xaeb535cc2b736240!8m2!3d16.0131183!4d108.2637083"
						target="googlemap"><img src="Images/hyatt.PNG"
						alt="Hyatt Resort"></a>
				</div>
			</div>
			<div class="w3-col m8 w3-panel">
				<div class="w3-large w3-margin-bottom" style="line-height: 35px">
					<i
						class="fa fa-map-marker fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
					Da Nang, Vietnam<br> <i
						class="fa fa-phone fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
					Phone: +00 999999<br> <i
						class="fa fa-envelope fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
					Email: gmail@gmail.com<br>
				</div>
				<a href="#home" class="w3-button top"><i
					class="fa fa-arrow-up w3-margin-right" style="color: white"></i>To
					the top</a>
				<div class="w3-xlarge w3-section">
					<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
						class="fa fa-instagram w3-hover-opacity"></i> <i
						class="fa fa-snapchat w3-hover-opacity"></i> <i
						class="fa fa-pinterest-p w3-hover-opacity"></i> <i
						class="fa fa-twitter w3-hover-opacity"></i> <i
						class="fa fa-linkedin w3-hover-opacity"></i>
				</div>
			</div>
		</div>
	</div>
</body>



</html>