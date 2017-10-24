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
    <link rel="stylesheet" href="./CSS/tra-cuu.css" />
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
    <script src="./JS/tracuu.js"></script>
</head>
<body>
	<!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>TRA CỨU KHÁCH THUÊ</h4>
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
        <div class="ket-qua-tim-kiem">
            <label> KẾT QUẢ TÌM KIẾM: </label>
            <div id="co-ket-qua">
                <fieldset>
                    <p style="color: #0d875c; font-weight: bold; text-decoration: underline">Thông tin khách hàng: </p>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Họ tên </th>
                                    <th>CMND</th>
                                    <th>Địa chỉ</th>
                                    <th>Quốc tịch</th>
                                    <th>SĐT</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td id="HoTen">Hoàng Phụng</td>
                                    <td id="CMND">241386440</td>
                                    <td id="DiaChi">01 Kha Vạn Cân, Phường Linh Đông, Quận Thủ Đức, Tp.HCM</td>
                                    <td id="QuocTich">Việt Nam</td>
                                    <td id="SDT">01668174561</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </fieldset>
                <br />
                <fieldset>
                    <p style="color: #0d875c; font-weight: bold; text-decoration: underline">Thông tin thuê phòng: </p>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Mã phòng </th>
                                    <th>Ngày nhận phòng</th>
                                    <th>Ngày trả phòng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td id="maPhong">A1</td>
                                    <td id="ngayNhanPhong">02/02/2017</td>
                                    <td id="ngayTraPhong">05/02/2017</td>
                                </tr>
                                <tr>
                                    <td id="maPhong">A2</td>
                                    <td id="ngayNhanPhong">02/02/2017</td>
                                    <td id="ngayTraPhong">05/02/2017</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <label style="font-style:italic">Tổng số phòng thuê: <span>2</span> </label><br /><br />
                </fieldset>
            </div>


            <div id="khong-co-ket-qua" style="text-align: center">
                <label>Không tìm thấy kết quả</label>
            </div>
        </div>
    </section>
</body>
</html>