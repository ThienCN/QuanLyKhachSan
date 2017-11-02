<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="connectionDB.NVTimPhongDB"%>
<%@page import="model.DanhSachPhongTrong"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
</head>
<body>

		<!--List<DanhSachPhongTrong> lst = 
				NVTimPhongDB.NVTimPhong(
				(String)getServletContext().getAttribute("ngayNhanPhong"), 
				(String)getServletContext().getAttribute("ngayTraPhong"),	 
				(String)getServletContext().getAttribute("user"), 
				(String)getServletContext().getAttribute("pass")); -->
		
		 
        <br />
        <div>
            <label> KẾT QUẢ TÌM KIẾM: </label>
            <div id="co-ket-qua">
                <fieldset>
                    <p style="color: #0d875c; font-weight: bold; text-decoration: underline">Danh sách phòng trống: </p>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Loại phòng</th>
                                    <th>Mã phòng </th>
                                    <th>Phí thuê phòng (USD)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                List<DanhSachPhongTrong> dsPhongTrong = (List)getServletContext().getAttribute("dsPhongTrong"); 
								 	for(DanhSachPhongTrong sp : dsPhongTrong){
									 //out.println(sp.getLoaiPhong()); 
								 %>
								 <tr>									 
									 <td><%=sp.getLoaiPhong() %></td>
									 <td><%=sp.getMaPhong() %></td>
									 <td><%=sp.getTienPhong() %></td>
								 </tr>
								 <%
								 }
								 %>
                            </tbody>
                        </table>
                    </div>
                    <div>
                        <label>Số loại phòng đơn trống là : 2 phòng </label> <br />
                        <label>Số loại phòng đôi trống là : 1 phòng </label> <br />
                        <label>Số loại phòng tập thể trống là : 1 phòng</label>
                    </div>                
                </fieldset>

                <br />
                <div class="input-group-btn">                  
                    <a href="#" class="btn btn-default">
                        Đặt phòng <i class="glyphicon glyphicon-edit"></i>
                    </a>
                    <a href="them-don-thue-phong.jsp" class="btn btn-default">
                        Thuê phòng <i class="glyphicon glyphicon-check"></i>
                    </a>
                </div>
            </div>
        </div>
</body>
</html>