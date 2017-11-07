<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ThongTinKhachHang" %>
<%@ page import="model.ThongTinThuePhong" %> 
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Chi tiết thống kê đơn thuê phòng</title>
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
    <script src="./JS/thong-ke-don-thue-phong.js"></script>
</head>
<body>
    <!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">     
        <label> THÔNG TIN CHI TIẾT GIAO DỊCH THUÊ PHÒNG: </label>
        <div id="thong-tin-khach-hang">
        	<%
        		List<ThongTinKhachHang> thongKeThongTinKH = 
        						(List<ThongTinKhachHang>)getServletContext().getAttribute("thongKeThongTinKH");
        	
        		List<ThongTinThuePhong> thongKeThongTinThuePhong =  
        						(List<ThongTinThuePhong>)getServletContext().getAttribute("thongKeThongTinThuePhong");
        		int n=thongKeThongTinThuePhong.size();
        	%>
        
        
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
                        		<tr>
                        			<td><%=thongKeThongTinKH.get(0).getMaKH() %> </td>
                        			<td><%=thongKeThongTinKH.get(0).getHoTenKH() %> </td>
                        			<td><%=thongKeThongTinKH.get(0).getCMND() %> </td>
                        			<td><%=thongKeThongTinKH.get(0).getDiaChi() %> </td>
                        			<td><%=thongKeThongTinKH.get(0).getQuocTich() %> </td>
                        			<td><%=thongKeThongTinKH.get(0).getSDT() %> </td>
                        		</tr>
                        </tbody>
                    </table>
                </div>
            </fieldset>
        </div>
            
        <br />
        <div id="thong-tin-thue-phong">
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
                        	<%for(int i=0; i<n; i++){
                        		ThongTinThuePhong p=thongKeThongTinThuePhong.get(i);
                        	%>
                        		  <tr>
                        		  		<td><%=p.getMaPhong() %> </td>
                        		  		<td><%=p.getNgayNhanPhong() %> </td>
                        		  		<td><%=p.getNgayTraPhong() %> </td>
                        		  		<td><%=p.getTienPhong() %> </td>
                        		  </tr>        	
                        	<%}%>
                        </tbody>
                    </table>
                </div>
            </fieldset>
        </div>


    </section>
</body>
</html>