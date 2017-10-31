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
    <script src="./JS/chinh-sua-don-thue-phong.js"></script>
</head>
<body>
    <!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>


    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>HỦY ĐƠN THUÊ PHÒNG</h4>
        <label> Mã khách hàng: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <form>
                    <div class="input-group search">
                        <input type="text" class="form-control" size="50" placeholder="Nhập mã khách hàng vào đây" id="maKhachHang">
                        <div class="input-group-btn">
                            <button id="btn-tra-cuu-khach-thue" class="btn btn-default" type="submit" style="background-color: #0d875c; color:white">
                                Tìm <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <br />
        <div class="co-ket-qua">
            <label> KẾT QUẢ TÌM KIẾM: </label>
            <!-- Thông tin khách hàng -->
            <fieldset>
                <p style="font-weight: bold; text-decoration: underline">Thông tin khách hàng: </p>
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã KH:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" class="form-control" size="20" placeholder="Ví dụ: KH1, KH2, .." value="KH1" readonly>
                            </div>
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Họ tên:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" class="form-control" size="30" placeholder="Nguyễn Văn A" value="Hoàng Thị Kim Phụng">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">CMND:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" class="form-control" size="30" placeholder="241386440" value="241386440">
                            </div>
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">SĐT:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" class="form-control" size="30" placeholder="0123456789" value="01668174561">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Quốc tịch:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" class="form-control" size="30" placeholder="Việt Nam" value="Việt Nam">
                            </div>
                            <label class="control-label col-xs-12 col-sm-4 col-md-2">Địa chỉ:</label>
                            <div class="col-xs-12 col-sm-8 col-md-4">
                                <input type="text" class="form-control" size="30" placeholder="Đường, Khu phố, Phường, Quận, Tỉnh"
                                       value="Kha Vạn Cân, Phường Linh Đông, Quận Thủ Đức">
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
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Phòng đơn</td>
                                <td>A1</td>
                                <td>2017-02-02</td>
                                <td>2017-02-02</td>
                                <td> <a> Hủy </a> </td>
                            </tr>
                            <tr>
                                <td>Phòng đơn</td>
                                <td>A1</td>
                                <td>2017-02-02</td>
                                <td>2017-02-02</td>
                                <td> <a> Hủy </a> </td>
                            </tr>
                            <tr>
                                <td>Phòng đơn</td>
                                <td>A1</td>
                                <td>2017-02-02</td>
                                <td>2017-02-02</td>
                                <td> <a> Hủy </a> </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="input-group-btn">
                    <button class="btn btn-default">
                        Hủy tất cả<i class="glyphicon glyphicon-ok"></i>
                    </button>
                </div>
            </fieldset>
        </div>

        <div class="khong-co-ket-qua" style="text-align: center">
            <label>Không tìm thấy kết quả</label>
        </div>

    </section>
</body>
</html>