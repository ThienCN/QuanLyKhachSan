<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Hủy đơn thuê phòng</title>
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
    <link rel="stylesheet" href="./CSS/chinh-sua-don-thue-phong.css" />
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
    <script src="./JS/huy-don-thue-phong.js"></script>
</head>
<body>
    <!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>


    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>HỦY ĐƠN THUÊ PHÒNG</h4>
        <label> Thông tin tìm kiếm: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <div class="input-group search">
                    <input type="text"  id="maTimKiem" class="form-control" placeholder="Nhập mã khách hàng hoặc CMND vào đây">
                    <div class="input-group-btn">
                        <button id="tim-thong-tin-khach-hang" class="btn btn-default" style="background-color: #0d875c; color:white">
                            Tìm <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <br />
        <label> KẾT QUẢ TÌM KIẾM: </label>
        <div id="thong-tin-khach-hang" style="display:none">
            <!-- Thông tin khách hàng -->
            <fieldset>
                <p style="font-weight: bold; text-decoration: underline">Thông tin khách hàng: </p>
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã KH:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" id="maKH" class="form-control" readonly>
                            </div>
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Họ tên:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" id="hoTenKH" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">CMND:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" id="CMND" class="form-control" readonly>
                            </div>
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">SĐT:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" id="SDT" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Quốc tịch:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" id="QuocTich" class="form-control" readonly>
                            </div>
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Địa chỉ:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" id="DiaChi" class="form-control" readonly>
                            </div>
                        </div>
                    </form>
                </div>
            </fieldset>
		</div>
		
        <hr />
        <div id="thong-tin-thue-phong" style="display:none">
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
                                <th></th>
                            </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </fieldset>
        </div>

       <div style="text-align: center">
            <label id="khong-co-ket-qua"></label>
        </div>
        <div style="text-align: center">
            <label id="khong-co-thong-tin-thue-phong"></label>
        </div>

    </section>
</body>
</html>