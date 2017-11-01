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
    <script src="./JS/tracuu.js"></script>
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
            <form class="form-horizontal" action="NV_TimPhong" method="get">
                <div class="form-group"> 
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày nhận phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="date" name="ngayNhanPhong" id="ngayNhanPhong" class="form-control"  
                        	<%
                        		if(getServletContext().getAttribute("ngayNhanPhong") == null)
                        		{
                        			Date date = new Date();                        			  
                        			String strDateFormat = "yyyy-MM-dd";                        			  
                        			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
                        	%>
                        		value= <%=simpleDateFormat.format(date)%>
                        	<%
                        		}
                        		else
                        		{
                        	%>	                        
                        		value= <%=getServletContext().getAttribute("ngayNhanPhong")%>
                        	<%
                        		}
                        	%>                        	
                        >
                    </div>
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày trả phòng:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="date" name="ngayTraPhong" id="ngayTraPhong"  class="form-control"  
                        	<%
                        		if(getServletContext().getAttribute("ngayTraPhong") == null)
                        		{
                        			Date date = new Date();                        			  
                        			String strDateFormat = "yyyy-MM-dd";                        			  
                        			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
                        	%>
                        		value= <%=simpleDateFormat.format(date)%>
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
                <div class="input-group-btn" style="text-align: right">
	                <button id="btn-tim-phong" class="btn btn-default" type="submit" style="background-color: #0d875c; color:white; width:150px; ">
	                    Tìm <i class="glyphicon glyphicon-search"></i>
	                </button>
            	</div>
            </form>            
        </div>
		 
		 
		<%
			if(getServletContext().getAttribute("dsPhongTrong") != null)
			{		
		%>
				<jsp:include page="ket-qua-NV-tim-phong.jsp"></jsp:include>
		<%	
			}
		%>
        
    </section>
</body>
</html>