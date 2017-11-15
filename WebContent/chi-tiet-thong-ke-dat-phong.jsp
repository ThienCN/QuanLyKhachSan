<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ThongTinKhachDat" %>
<%@ page import="model.ThongTinDatPhong_NV" %> 
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Chi tiết thống kê giao dịch đặt phòng</title>
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
    <script src="./JS/thong-ke-dat-phong.js"></script>
</head>
<body>
    <!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">     
        <label> THÔNG TIN CHI TIẾT GIAO DỊCH ĐẶT PHÒNG: </label>
        <div id="thong-tin-khach-dat">
        	<%
        		List<ThongTinKhachDat> thongKeThongTinKhachDat = 
        						(List<ThongTinKhachDat>)getServletContext().getAttribute("thongKeThongTinKhachDat");
        	
        		List<ThongTinDatPhong_NV> thongKeThongTinDatPhong =  
        						(List<ThongTinDatPhong_NV>)getServletContext().getAttribute("thongKeThongTinDatPhong");
        		
        		int n=thongKeThongTinDatPhong.size();
        	%>
        
        
            <fieldset>
            	<p style="color: #0d875c; font-weight: bold; text-decoration: underline">Thông tin khách đặt: </p>
                <div class="table-responsive">
                    <table class="table" id="table-thong-tin-khach-dat">
                        <thead>
                            <tr>
                            	<th>Mã code</th>
                                <th>Họ tên </th>
                                <th>CMND</th>
                                <th>Địa chỉ</th>
                                <th>Quốc tịch</th>
                                <th>SĐT</th>
                            </tr>
                        </thead>
                        <tbody>
                        		<tr>
                        			<td><%=thongKeThongTinKhachDat.get(0).getMaKD() %> </td>
                        			<td><%=thongKeThongTinKhachDat.get(0).getHoTenKD() %> </td>
                        			<td><%=thongKeThongTinKhachDat.get(0).getCMND() %> </td>
                        			<td><%=thongKeThongTinKhachDat.get(0).getDiaChi() %> </td>
                        			<td><%=thongKeThongTinKhachDat.get(0).getQuocTich() %> </td>
                        			<td><%=thongKeThongTinKhachDat.get(0).getSDT() %> </td>
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
                    <table class="table" id="table-thong-tin-dat-phong">
                        <thead>
                            <tr>
                                <th>Mã phòng </th>
                                <th>Ngày nhận phòng</th>
                                <th>Ngày trả phòng</th>
                                <th>Tiền phòng (USD)</th>
                                <th>Tiền đã đặt cọc (USD) </th>
                                <th>Tình trạng </th>
                                <th>Người hủy </th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%for(int i=0; i<n; i++){
                        		ThongTinDatPhong_NV p = thongKeThongTinDatPhong.get(i);
                        	%>
                        		  <tr>
                        		  		<td><%=p.getMaPhong()%> </td>
                        		  		<td><%=p.getNgayNhanPhong() %> </td>
                        		  		<td><%=p.getNgayTraPhong() %> </td>
                        		  		<td><%=p.getTienPhong() %> </td>
                        		  		<td><%=p.getTienPhong() * 0.1 %></td>
                        		  		<td>
                        		  			<% if(p.getTinhTrang() == 1) {%>
                        		  				Đã đặt thành công
                        		  			<%} %>
                        		  			<% if(p.getTinhTrang() == 0) {%>
                        		  				Đã hủy
                        		  			<%} %>
                        		  			<% if(p.getTinhTrang() == 2) {%>
                        		  				Đã nhận phòng
                        		  			<%} %>
                        		  		</td>
                        		  		<td>
                        		  			<% if((p.getNguoiHuy() == null || p.getNguoiHuy() == "") && p.getTinhTrang() == 0) {%>
                        		  				Khách hủy
                        		  			<%} %>
                        		  			<% if((p.getNguoiHuy() != null || p.getNguoiHuy() != "") && p.getTinhTrang() == 0) {%>
                        		  				<%=p.getNguoiHuy() %>
                        		  			<%} %>
                        		  		</td>
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