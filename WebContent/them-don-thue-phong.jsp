<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ThongTinKhachHang" %>
<%@ page import="java.util.List" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<title>Thêm đơn thuê phòng</title>
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
    <link rel="stylesheet" href="./CSS/them-don-thue-phong.css" />
    <!-- MY JS -->
    <script src="./JS/include-html.js"></script>
    <script src="./JS/them-don-thue-phong.js"></script>
    
</head>
<body>
    <!-- HEADER -->
    <header id="header"></header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>


    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h4>THÊM ĐƠN THUÊ PHÒNG</h4>
        <!-- Thông tin khách hàng -->
        <%
        	boolean flagKHCu = false;
        	List<ThongTinKhachHang> thongTinKHCu=(List<ThongTinKhachHang>)getServletContext().getAttribute("thongTinKHCu"); 
        	if(thongTinKHCu!=null)
        	{
        		flagKHCu=true;
        		getServletContext().setAttribute("thongTinKHCu", null);
        	}
        %>
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline">Thông tin khách hàng: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">                  	
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã KH:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" id="maKH" readonly 
                            <% if(flagKHCu){%>
                            	value="<%= thongTinKHCu.get(0).getMaKH()%>"
                            <%}%> 
                            >
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Họ tên:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" id="hotenKH"  placeholder="Nguyễn Văn A" required
                            <% if(flagKHCu){%>
                            	value="<%= thongTinKHCu.get(0).getHoTenKH()%>" readonly
                            <%}%>
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">CMND:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" id="CMND" placeholder="241386440" required
                            <% if(flagKHCu){%>
                            	value="<%= thongTinKHCu.get(0).getCMND()%>" readonly
                            <%}%>
                            >
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">SĐT:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" id="SDT" placeholder="0123456789" required
                            <% if(flagKHCu){%>
                            	value="<%= thongTinKHCu.get(0).getSDT()%>" readonly
                            <%}%>                            
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Quốc tịch:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" id="QuocTich"  placeholder="Việt Nam" required
                            <% if(flagKHCu){%>
                            	value="<%= thongTinKHCu.get(0).getSDT()%>" readonly
                            <%}%>
                            >
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Địa chỉ:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" class="form-control" id="DiaChi"  placeholder="Đường, Khu phố, Phường, Quận, Tỉnh" required
                            <% if(flagKHCu){%>
                            	value="<%= thongTinKHCu.get(0).getDiaChi()%>" readonly
                            <%}%>
                            >
                        </div>
                    </div>                   
                </form>
                <div class="input-group-btn">
	                <button id="luu-thong-tin-KH"  class="btn btn-default"
	                <% if(flagKHCu){%>
                         disabled
                    <%}%>
	                >
	                    Lưu <i class="glyphicon glyphicon-ok"></i>
	                </button> 
	            </div>
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
                            <th>Phí thuê phòng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="input-group-btn">
            	<button id="huy-giao-dich-thue-phong" class="btn btn-default" 
            	<% if(!flagKHCu){%>
                         disabled
                <%}%>
            	>
                    Hủy giao dịch <i class="glyphicon glyphicon-trash"></i>
                 </button>
                <button id="xac-nhan-giao-dich-thue-phong"  class="btn btn-default"  style="width: 200px;" 
                <% if(!flagKHCu){%>
                         disabled
                <%}%>
            	>
                    Xác nhận giao dịch <i class="glyphicon glyphicon-ok"></i>
                </button>
            </div>
        </fieldset>

        <hr />
        <!--Chọn phòng -->
        <div>   
            <div class="w3-half">
                <fieldset>
                    <form class="form-horizontal">
                        <label style="text-decoration:underline; color:#0d875c;">TÌM PHÒNG MỚI:</label> <br />
                        <div class="form-group">
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Ngày nhận phòng:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="date" id="ngayNhanPhong" class="form-control" readonly                        	
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
                            <label class="control-label col-xs-12 col-sm-4 col-md-4">Ngày trả phòng:</label>
                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <input type="date" id="ngayTraPhong" class="form-control"
                                	<%
                        		if(getServletContext().getAttribute("ngayTraPhong") == null)
                        		{
                        			Date date2 = new Date(new Date().getTime()+60*60*24*1000);                        			  
                        			String strDateFormat2 = "yyyy-MM-dd";                        			  
                        			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(strDateFormat2);
	                        	%>
	                        		value= <%=simpleDateFormat2.format(date2)%>
	                        	<%
	                        		}
	                        		else
	                        		{
	                        	%>	                        
	                        		value= <%=getServletContext().getAttribute("ngayTraPhong")%>
	                        	<%
	                        		}
	                        	%>  
                                >
                            </div>
                        </div>
                    </form>
                    <div class="input-group-btn">
                        <button class="btn btn-default" id="thay-doi-ngay-tim-phong" disabled>
                            Thay đổi ngày <i class="glyphicon glyphicon-edit"></i>
                        </button>
                        <button class="btn btn-default" id="tim-phong" >
                            Tìm phòng <i class="glyphicon glyphicon-search"></i> 
                        </button>
                    </div>
                </fieldset>                
            </div>
            <div class="w3-half">
                <fieldset>
                    <form class="form-horizontal" action="NV_LuuMotPhongThue" method="post"> 
                        <label style="text-decoration:underline; color:#0d875c;">CHỌN PHÒNG:</label> <br />                       
                        <div class="w3-third" >
                            <div class="form-group">
                                <label id="ds-phong-don" class="btn btn-info" style="width:100%; text-align:center; font-weight:bold; background-color:#0d875c">
                                    Phòng đơn <span id="giaPhongDon" style="display: none"> (  <span id="phiThuePhongDon">  </span> USD)</span>
                                </label>
                                <div>
                                    <select class="form-control" id="phongDon" disabled>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="w3-third">
                            <div class="form-group">
                                <label id="ds-phong-doi" class="btn btn-info" style="width:100%; text-align:center; font-weight:bold; background-color:#0d875c">
                                    Phòng đôi <span id="giaPhongDoi" style="display: none"> (  <span id="phiThuePhongDoi">  </span> USD)</span>
                                </label>
                                <div>
                                    <select class="form-control" id="phongDoi" disabled>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="w3-third">
                            <div class="form-group">
                                <label id="ds-phong-tap-the" class="btn btn-info" style="width:100%; text-align:center; font-weight:bold; background-color:#0d875c">
                                    Phòng tập thể <span id="giaPhongTapThe" style="display: none"> (  <span id="phiThuePhongTapThe">  </span> USD)</span>
                                </label>
                                <div>
                                    <select class="form-control" id="phongTapThe" disabled>
                                    </select>
                                </div>
                            </div> 
                          </div>                         
                    </form>
                    <br />
	                    <div class="input-group-btn">
	                        <button id="btn-chon-phong" type="submit" class="btn btn-default" disabled>
	                            Chọn <i class="glyphicon glyphicon-ok"></i>
	                        </button>
	                    </div>                      
                </fieldset>
            </div>
        </div>
    </section>
</body>
</html>