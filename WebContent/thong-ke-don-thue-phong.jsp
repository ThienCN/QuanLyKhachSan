<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>	

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
    <link rel="stylesheet" href="./CSS/thong-ke-don-thue-phong.css" />
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
    <script src="./JS/thong-ke-don-thue-phong.js"></script>
</head>
<body>
    <!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>THỐNG KÊ ĐƠN THUÊ PHÒNG</h4>
        <!-- Từ ngày a đến ngày b có bao nhiêu đơn thuê phòng -->
        <p style="font-weight: bold; text-decoration: underline">Thống kê các đơn thuê phòng: </p>
        <div class="row ">
        	<div class="col-xs-12 col-md-6">
        		<form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 col-md-3"> Bắt đầu từ ngày:</label>
                    <div class="col-xs-12 col-sm-9 col-md-9">
                        <input type="date" id="ngayBatDau" class="form-control"
                        	<%
	                        	Date date1 = new Date();                        			  
	                			String strDateFormat1 = "yyyy-MM-dd";                        			  
	                			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(strDateFormat1);
                        	%>
                        		value= <%=simpleDateFormat1.format(date1)%>
                        >
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 col-md-3"> Đến ngày:</label>
                    <div class="col-xs-12 col-sm-9 col-md-9">
                        <input type="date" id="ngayKetThuc" class="form-control"
                        	<%
                       			Date date = new Date(new Date().getTime()+60*60*24*1000);                        			  
                       			String strDateFormat = "yyyy-MM-dd";                        			  
                       			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
                        	%>
                        		value= <%=simpleDateFormat.format(date)%>
                        >
                    </div>
                </div>
            </form>
            <div class="input-group-btn" style="text-align: right">
             <button id="btn-thong-ke" class="btn btn-default" style="background-color: #0d875c; color:white; width:150px; ">
                 Thống kê <i class="glyphicon glyphicon-list"></i>
             </button>
        	</div>
        	</div>         
    	</div>

        <hr />
        <label> KẾT QUẢ TÌM KIẾM: </label>
        <!-- KẾT QUẢ -->
        <div id="ket-qua-thong-ke" style="display:none">        	
	        <fieldset>
	            <div class="table-responsive">
	                <table class="table" id="table-thong-ke-thue-phong">
	                    <thead>
	                        <tr>
	                            <th>Mã khách hàng</th>
	                            <th>Họ tên KH</th>
	                            <th>Số phòng đơn</th>
	                            <th>Số phòng đôi</th>
	                            <th>Số phòng tập thể</th>
	                            <th></th>
	                        </tr>
	                    </thead>
	                    <tbody></tbody>
	                </table>
	            </div>
	        </fieldset>
        </div>
        
        <div style="text-align: center">
            <label id="khong-co-ket-qua" style="display:none"></label>
        </div>
</section>
</body>
</html>