<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Tra cứu khách hàng</title>
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
                <div class="input-group search">
                     <input type="text" id="maTimKiemKH" class="form-control" placeholder="Nhập mã khách hàng hoặc CMND vào đây">
                     <div class="input-group-btn">
                         <button type="button" id="btn-tra-cuu-khach-thue" class="btn btn-default" style="background-color: #0d875c; color:white">
                             Tìm <i class="glyphicon glyphicon-search"></i>
                         </button>
                     </div>
                 </div>
            </div>
        </div>
        <br />
       
        <label> KẾT QUẢ TÌM KIẾM: </label>
        <div id="thong-tin-khach-hang" style="display:none">
            <fieldset>
            	<p style="color: #0d875c; font-weight: bold; text-decoration: underline">Thông tin khách hàng: </p>
                <div class="table-responsive">
                    <table class="table" id="table-thong-tin-khach-hang">
                        <thead>
                            <tr>
                            	<th>Mã KH</th>
                                <th>Họ tên </th>
                                <th>CMND</th>
                                <th>Địa chỉ</th>
                                <th>Quốc tịch</th>
                                <th>SĐT</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <div class="input-group-btn">
          	<button id="tra-cuu-thong-tin-thue-phong-hien-tai" type="button" style="width: 300px;"  class="btn btn-default" >
                  Tra cứu thông tin thuê phòng hiện tại <i class="glyphicon glyphicon-search"></i>
               </button>
              <button id="thue-them-phong"  type="button" class="btn btn-default" style="width: 250px;" >
                  Thuê thêm phòng <i class="glyphicon glyphicon-check"></i>
              </button>
        		</div>
            </fieldset>
        </div>
            
        <br />
        <div id="thong-tin-thue-phong" style="display:none">
            <fieldset>
                <p style="color: #0d875c; font-weight: bold; text-decoration: underline">Thông tin thuê phòng: </p>
                <div class="table-responsive">
                    <table class="table" id="table-thong-tin-thue-phong">
                        <thead>
                            <tr>
                                <th>Mã phòng </th>
                                <th>Ngày nhận phòng</th>
                                <th>Ngày trả phòng</th>
                                <th>Tiền phòng (USD)</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </fieldset>
        </div>

        <div style="text-align: center">
        <label  id="khong-co-ket-qua" style="display:none"></label>
        </div>
            
    </section>
</body>
</html>