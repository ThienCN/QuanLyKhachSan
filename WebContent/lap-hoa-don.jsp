<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Lập hóa đơn</title>
    <meta charset="UTF-8">
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
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
     <script src="./JS/lap-hoa-don.js"></script>
</head>
<body>
	<!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

   	<!-- CONTENT -->
    <section class="phan-noi-dung">
        <div class="noi-dung">
            <!-- Thanh tìm kiếm -->
            <label> Mã tra cứu: </label>
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="input-group">
                        <input type="text" id="maXuatHoaDon" class="form-control" placeholder="Mã khách hàng hoặc CMND" >
                        <div class="input-group-btn">
                            <button id="btn-lap-hoa-don" class="btn btn-default" style="background-color: #0d875c; color:white">
                                Tìm <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <hr />

            <!-- Thông tin khách hàng -->
            <div id="thong-tin-khach-hang" style="display: none">
            	<fieldset class="w3-half" style="margin:0px;">
                    <label style="text-decoration:underline; color:#0d875c;">THÔNG TIN KHÁCH HÀNG	:</label>
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Mã khách hàng:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="maKH" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Tên khách hàng:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="hoTenKH" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Số CMND:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="CMND" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Số điện thoại:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="SDT" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Quốc tịch:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="QuocTich" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Địa Chỉ:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="DiaChi" class="form-control" readonly>
                            </div>
                        </div>
                    </div>
            	</fieldset>
            </div>
            
           

            <!-- Thông tin hóa đơn -->
            <div id="thong-tin-hoa-don" style="display: none">
            	<fieldset class="w3-half" style="margin:0px">
                    <label style="text-decoration:underline; color:#0d875c;">THÔNG TIN HÓA ĐƠN:</label>
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Mã hóa đơn:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="maHoaDon" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Tổng tiền thuê phòng:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="tongTienThuePhong" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Tổng tiền sử dụng dịch vụ:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="tongTienSuDungDichVu" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Tổng tiền đền bù (nếu có):</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="tongTienDenBu" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Tiền cọc (nếu có):</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="tienCoc" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Tổng tiền cần thanh toán:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="text" id="tongTienCanThanhToan" class="form-control" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Ngày thanh toán:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="date" id="ngayThanhToan" class="form-control" readonly
                                <%
                        			Date date = new Date();                        			  
                        			String strDateFormat = "yyyy-MM-dd";                        			  
                        			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
	                        	%>
	                        		value= <%=simpleDateFormat.format(date)%>
                                >
                            </div>
                        </div>
                    </div>
            	</fieldset>
            	<!-- Nút thanh toán -->
	            <hr />
	            <div class="input-group-btn" style="text-align: right">
	                <button id="btn-thanh-toan" class="btn btn-default" type="submit" style="background-color: #0d875c; color:white; width:150px; ">
	                    Thanh toán <i class="glyphicon glyphicon-ok"></i>
	                </button>
	            </div>
            </div>
        </div>
        
        <div style="text-align: center">
        <label id="khong-co-ket-qua"> </label>
        </div>
    </section>
   	
</body>
</html>