<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Thêm người dùng</title>
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
                        <a class="navbar-brand"><i class="fa fa-user-plus"></i></a>
                    </div>
                    <div class="nav navbar-nav navbar-left">
                        <a id="page-trich-dan" href="them-nguoi-dung.jsp">THÊM NGƯỜI DÙNG</a>
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
                    <li><a href="quan-tri-vien.jsp"><i class="fa fa-user-secret"></i> Trang của bạn</a></li>
                    <li class="active"><a href="them-nguoi-dung.jsp"><i class="fa fa-user-plus"></i> Thêm người dùng</a></li>
                    <li><a href="cap-nhat-nguoi-dung.jsp"><i class="glyphicon glyphicon-upload"></i> Cập nhật người dùng</a></li>
                    <li><a href="xoa-nguoi-dung.jsp"><i class="glyphicon glyphicon-trash"></i> Xóa người dùng</a></li>
                    <li><a href="#"><i class="fa fa-sign-out"></i> Thoát </a></li>
                </ul>
            </div>
        </nav>
    </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>THÊM NGƯỜI DÙNG MỚI</h4>
        <!-- Thông tin người dùng -->
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline; color: #0d875c;">Thông tin người dùng: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã nhân viên:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="20" placeholder="Ví dụ: NV1, NV2, ..">
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Họ tên:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="30" placeholder="Nguyễn Văn A">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">CMND:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="30" placeholder="241386440">
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Địa chỉ:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="30" placeholder="Đường, Khu phố, Phường, Quận, Tỉnh">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">SĐT:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="30" placeholder="0123456789">
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
        <br />
        <fieldset>
            <label  style="font-weight: bold; text-decoration: underline; color: #0d875c;">Thông tin tài khoản:</label>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Tên tài khoản:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="text" class="form-control" size="20" placeholder="Ví dụ: NV1, NV2, ..">
                    </div>
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Mật khẩu:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="text" class="form-control" size="30" placeholder="Nguyễn Văn A">
                    </div>
                </div>     
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Quyền truy cập:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <select  class="form-control">
                            <option>Admin</option>
                            <option>Nhân viên</option>
                        </select>
                    </div>
                </div>   
            </form>
        </fieldset>
        <br />
        <div class="input-group-btn">
            <button class="btn btn-default">
                Thêm người dùng <i class="glyphicon glyphicon-ok"></i>
            </button>
        </div>
    </section>

    <!-- FOOTER -->

</body>
</html>