<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge,chrome=1">
    <!-- Boostrap-->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- CSS -->
    <link rel="stylesheet" href="./CSS/w3.css">
    <!-- MY CSS -->
    <link rel="stylesheet" href="./CSS/header-menu-footer.css" />
    <link rel="stylesheet" href="./CSS/quan-tri-vien.css" />
</head>
<body>
    <!-- HEADER -->
    <header>
        <!-- LOGO HOTEL -->
        <div class="container">
            <img src="./Images/logo-hotel.png" alt="logo" class="logo">
        </div>

        <!-- NAVBAR -->
        <div>
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-left">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand"><i class="fa fa-user-secret"></i></a>
                    </div>
                    <div class="nav navbar-nav navbar-left">
                        <a id="page-trich-dan" href="quan-tri-vien.jsp">TRANG CỦA BẠN</a>
                    </div>
                    <div class="nav navbar-nav navbar-right">
                        <a class="image-nhanvien"><img src="./Images/doremon.png" alt="NhanVien"><span>Admin Hoàng Phụng</span></a>
                    </div>
                </div>
            </nav>
        </div>
    </header>

    <!-- MENU-LEFT -->
    <section>
        <nav class="navbar-default nav-menu">
            <div id="nav-left" class="navbar-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="quan-tri-vien.jsp"><i class="fa fa-user-secret"></i> Trang của bạn</a></li>
                    <li ><a href="them-nguoi-dung.jsp"><i class="fa fa-user-plus"></i> Thêm người dùng</a></li>
                    <li ><a href="cap-nhat-nguoi-dung.jsp"><i class="glyphicon glyphicon-upload"></i> Cập nhật người dùng</a></li>
                    <li><a href="xoa-nguoi-dung.jsp"><i class="glyphicon glyphicon-trash"></i> Xóa người dùng</a></li>
                    <li ><a href="#"><i class="fa fa-sign-out"></i> Thoát </a></li>
                </ul>
            </div>
        </nav>
    </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <div class="trang-quan-tri">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="div-square">
                        <a href="them-nguoi-dung.jsp">
                            <i class="fa fa-user-plus"></i>
                            <h5 style="font-weight: bold">Thêm người dùng</h5>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="div-square">
                        <a href="cap-nhat-nguoi-dung.jsp">
                            <i class="glyphicon glyphicon-upload"></i>
                            <h5 style="font-weight: bold">Cập nhật người dùng</h5>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="div-square">
                        <a href="xoa-nguoi-dung.jsp">
                            <i class="glyphicon glyphicon-trash"></i>
                            <h5 style="font-weight: bold">Xóa người dùng</h5>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
    </section>

    <!-- FOOTER -->

</body>
</html>