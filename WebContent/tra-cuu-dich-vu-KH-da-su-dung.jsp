<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Tra cứu dịch vụ khách hàng đã sử dụng</title>
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
        <h4>TRA CỨU DỊCH VỤ <br /> KHÁCH HÀNG ĐÃ SỬ DỤNG</h4>
        <label> Mã khách hàng: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <form>
                    <div class="input-group search">
                        <input type="text" class="form-control" size="50" placeholder="Nhập mã khách hàng vào đây" id="maKhachHang">
                        <div class="input-group-btn">
                            <button id="btn-tra-cuu-dich-vu-KH-da-su-dung" class="btn btn-default" type="submit" style="background-color: #0d875c; color:white">
                                Tìm <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <br />
        <!-- KẾT QUẢ TÌM KIẾM -->
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
                    <p style="color: #0d875c; font-weight: bold; text-decoration: underline">Thông tin dịch vụ khách hàng đã sử dụng: </p>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Mã dịch vụ </th>
                                    <th>Tên dịch vụ</th>
                                    <th>Phí dịch vụ (USD)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td id="maDV">DV1</td>
                                    <td id="tenDV">Ăn trưa</td>
                                    <td id="phiDV">50</td>
                                </tr>
                                <tr>
                                    <td id="maDV">DV2</td>
                                    <td id="tenDV">Spa</td>
                                    <td id="phiDV">150</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <label style="font-style:italic">Tổng số tiền dịch vụ đã sử dụng: <span>200 </span> USD </label><br /><br />
                </fieldset>
            </div>


            <div id="khong-co-ket-qua" style="text-align: center">
                <label>Không tìm thấy kết quả</label>
            </div>
        </div>
    </section>
</body>
</html>