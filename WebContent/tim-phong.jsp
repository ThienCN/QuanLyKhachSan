<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="connectionDB.NVTimPhongDB"%>
<%@page import="model.DanhSachPhongTrong"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Tìm phòng</title>
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
    <link rel="stylesheet" href="./CSS/tim-phong.css" />
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
    <script src="./JS/NV-tim-phong.js"></script>
</head>
<body>
    <!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>TÌM PHÒNG</h4>
        <label style="font-weight: bold; text-decoration: underline"> Thông tin tìm phòng: </label><br />
        <div class="col-xs-12 col-sm-12 col-md-12">
            <div class="form-horizontal">
                <div class="form-group"> 
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày nhận phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="date" name="ngayNhanPhong" id="ngayNhanPhong" class="form-control"  
                        	<%
                      			Date date = new Date();                        			  
                      			String strDateFormat = "yyyy-MM-dd";                        			  
                      			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
                        	%>
                        		value= <%=simpleDateFormat.format(date)%>
                        >
                    </div>
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày trả phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="date" name="ngayTraPhong" id="ngayTraPhong"  class="form-control"  
                        	<%
                      			Date date2 = new Date(new Date().getTime()+60*60*24*1000);                        			  
                      			String strDateFormat2 = "yyyy-MM-dd";                        			  
                      			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(strDateFormat2);
                        	%>
                        		value= <%=simpleDateFormat.format(date2)%>
                        >
                    </div>
                </div>
                <div class="input-group-btn" style="text-align: right">
	                <button id="btn-tim-phong" class="btn btn-default" style="background-color: #0d875c; color:white; width:150px; ">
	                    Tìm Kiếm <i class="glyphicon glyphicon-search"></i>
	                </button>
            	</div>
            </div>            
        </div>
		
	    <label> KẾT QUẢ TÌM KIẾM: </label>
	    <div id="ket-qua-tim-phong" style="display:none">
	        <fieldset>
	            <p style="color: #0d875c; font-weight: bold; text-decoration: underline">Danh sách phòng trống: </p>
	            <div class="table-responsive">
	                <table class="table" id="table-ket-qua-tim-phong">
	                    <thead>
	                        <tr>
	                            <th>Loại phòng</th>
	                            <th>Mã phòng </th>
	                            <th>Phí thuê phòng (USD)</th>
	                        </tr>
	                    </thead>
	                    <tbody></tbody>
	                </table>
	            </div>             
	        </fieldset>
	
	        <br />
	        <div class="input-group-btn">                  
	            <a href="them-don-dat-phong.jsp" class="btn btn-default">
	                Đặt phòng <i class="glyphicon glyphicon-edit"></i>
	            </a>
	            <a href="them-don-thue-phong.jsp" class="btn btn-default">
	                Thuê phòng <i class="glyphicon glyphicon-check"></i>
	            </a> 
	        </div>
	   </div>
 
 		<div style="text-align: center">
        <label id="khong-co-ket-qua"></label>
        </div>
    </section>
</body>
</html>