<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Thêm phòng</title>
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
    <link rel="stylesheet" href="./CSS/them-phong.css" />
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
    <script src="./JS/them-phong.js"></script>
</head>
<body>
	<!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <div class="noi-dung">
        	<!-- Nhập thông tin phòng -->
	    	<div class="nhap-thong-tin-phong">
            <label style="text-decoration:underline; color:#0d875c;">NHẬP THÔNG TIN PHÒNG:</label>
            <form class="form-horizontal">
                <div class="form-group">
                	<label class="control-label col-xs-12 col-sm-4 col-md-2">Mã phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="text" id="maPhong" class="form-control" size="30" placeholder="Nhập mã phòng">
                    </div>
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Loại phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <select class="form-control" id="loaiPhong">
                            <option>Phòng đơn</option>
                            <option>Phòng đôi</option>
                            <option>Phòng tập thể</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                     <label class="control-label col-xs-12 col-sm-4 col-md-2">Tình trạng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <select class="form-control" id="tinhTrang">
                            <option>Còn trống</option>
                            <option>Đã có người ở</option>
                        </select>
                    </div>
                    <div class="col-xs-12 col-sm-8 col-md-6">
                        <div class="input-group-btn" style="text-align: right">
                			<button id="btn-xac-nhan-thong-tin-phong" class="btn btn-default" type="submit" style="background-color: #0d875c; color:white; width:150px; ">
                   				 Xác nhận <i class="glyphicon glyphicon-ok"></i>
                			</button>
           				 </div>
                    </div>
                </div>
            </form>
        	</div>
        	
        	<hr/>
        	
        	<!-- Thông tin phòng -->
        	<div class="table-line">
	        	<fieldset>
	           	 	<p style="font-weight: bold; text-decoration: underline">Thông tin phòng: </p>
	            	<div class="table-responsive">
	                	<table class="table" id="table-thong-tin-phong">
	                  	 	<thead>
	                       	 <tr>
	                            <th>Mã phòng </th>
	                           	<th>Loại phòng</th>
	                          	<th>Tình trạng</th>
	                      	  </tr>
	                  	  	</thead>
	                 	   <tbody>
	                 	   </tbody>
	              	  </table>
	          	  </div>
	        	</fieldset>
	        </div>
	        
	        <!-- Nút thêm tất cả các phòng trong bảng vào csdl -->
	        <br/>
	        <div class="input-group-btn" style="text-align: right">
                <button id="btn-them-vao-csdl" class="btn btn-default" type="submit" style="background-color: #0d875c; color:white; width:150px; ">
	   				 Thêm phòng <i class="glyphicon glyphicon-plus"></i>
                </button>
           	</div>
        </div>
    </section>
</body>
</html>