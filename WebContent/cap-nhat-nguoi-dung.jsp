<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>Cập nhật người dùng</title>
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
                        <a class="navbar-brand"><i class="glyphicon glyphicon-upload"></i></a>
                    </div>
                    <div class="nav navbar-nav navbar-left">
                        <a id="page-trich-dan" href="cap-nhat-nguoi-dung.jsp">CẬP NHẬT NGƯỜI DÙNG</a>
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
                    <li><a href="them-nguoi-dung.jsp"><i class="fa fa-user-plus"></i> Thêm người dùng</a></li>
                    <li  class="active"><a href="cap-nhat-nguoi-dung.jsp"><i class="glyphicon glyphicon-upload"></i> Cập nhật người dùng</a></li>
                    <li><a href="xoa-nguoi-dung.jsp"><i class="glyphicon glyphicon-trash"></i> Xóa người dùng</a></li>
                    <li><a href="#"><i class="fa fa-sign-out"></i> Thoát </a></li>
                </ul>
            </div>
        </nav>
    </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>CẬP NHẬT NGƯỜI DÙNG</h4>

        <label> Mã người dùng: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <form>
                    <div class="input-group search">
                        <input type="text" class="form-control" size="50" placeholder="Nhập mã người dùng vào đây">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit" style="background-color: #0d875c; color:white">
                                Tìm <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <br />
        <!-- Danh sách người dùng hiện có -->
        <fieldset>
            <p style="color: #0d875c; font-weight: bold; text-decoration: underline">Danh sách người dùng: </p>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Mã nhân viên </th>
                            <th>Họ tên</th>
                            <th>CMND</th>
                            <th>Địa chỉ</th>
                            <th>SDT</th>
                            <th>Mật khẩu</th>
                            <th>Quyền truy cập</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>NV1</td>
                            <td>Nguyễn Thị A</td>
                            <td>2413589466</td>
                            <td>Khánh Hòa</td>
                            <td>0985261512</td>
                            <td>1234</td>
                            <td>Nhân viên</td>
                            <td><a href="cap-nhat-thong-tin-nguoi-dung.jsp">Cập nhật</a></td>
                        </tr>
                        <tr>
                            <td>NV1</td>
                            <td>Nguyễn Thị A</td>
                            <td>2413589466</td>
                            <td>Khánh Hòa</td>
                            <td>0985261512</td>
                            <td>1234</td>
                            <td>Nhân viên</td>
                            <td><a href="cap-nhat-thong-tin-nguoi-dung.jsp">Cập nhật</a></td>
                        </tr>
                        <tr>
                            <td>NV1</td>
                            <td>Nguyễn Thị A</td>
                            <td>2413589466</td>
                            <td>Khánh Hòa</td>
                            <td>0985261512</td>
                            <td>1234</td>
                            <td>Nhân viên</td>
                            <td><a href="cap-nhat-thong-tin-nguoi-dung.jsp">Cập nhật</a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </fieldset>        
    </section>

    <!-- FOOTER -->

</body>
</html>