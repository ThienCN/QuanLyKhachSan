<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Tra cứu khách hàng</title>
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
    <link rel="stylesheet" href="./CSS/them-don-thue-phong.css" />
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
    <script src="./JS/them-don-thue-phong.js"></script>
</head>
<body>
	<!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>


    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>THÊM ĐƠN THUÊ PHÒNG</h4>
        <!-- Thông tin khách hàng -->
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline">Thông tin khách hàng: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã KH:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="20" placeholder="Ví dụ: KH1, KH2, ..">
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
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">SĐT:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="30" placeholder="0123456789">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Quốc tịch:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="30" placeholder="Việt Nam">
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Địa chỉ:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" size="30" placeholder="Đường, Khu phố, Phường, Quận, Tỉnh">
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
       
        <hr />
        <!-- Thông tin thuê phòng -->
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline">Thông tin thuê phòng: </p>
            <div class="table-responsive">
                <table class="table" id="table-thong-tin-thue-phong">
                    <thead>
                        <tr>
                            <th>Loại phòng </th>
                            <th>Mã phòng</th>
                            <th>Ngày nhận phòng</th>
                            <th>Ngày trả phòng</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </fieldset>

        <hr />
        <!--Chọn phòng -->
        <div class="chon-phong">
            <label style="text-decoration:underline; color:#0d875c;">CHỌN PHÒNG:</label>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Loại phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <select class="form-control" id="loaiPhong">
                            <option>Phòng đơn</option>
                            <option>Phòng đôi</option>
                            <option>Phòng tập thể</option>
                        </select>
                    </div>
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <select class="form-control" id="maPhong">
                            <option>A1</option>
                            <option>A2</option>
                            <option>A3</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày nhận phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="date" id="ngayNhanPhong" class="form-control" size="30" placeholder="Mã phòng cần tra cứu">
                    </div>
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày trả phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="date" id="ngayTraPhong" class="form-control" size="30" placeholder="Mã phòng cần tra cứu">
                    </div>
                </div>
            </form>
            <div class="input-group-btn" style="text-align: right">
                <button id="btn-chon-phong" class="btn btn-default" type="submit" style="background-color: #0d875c; color:white; width:150px; ">
                    Chọn <i class="glyphicon glyphicon-ok"></i>
                </button>

            </div>
        </div>
    </section>
</body>
</html>