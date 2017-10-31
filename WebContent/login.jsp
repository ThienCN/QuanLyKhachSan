<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href="./CSS/bootstrap.min.css">
<link rel="stylesheet" href="./CSS/font-awesome.min.css">

<script src="./JS/jquery-3.2.1.min.js"></script>
<script src="./JS/bootstrap.min1.js"></script>
<!--My CSS-->
<link rel="stylesheet" href="./CSS/dangnhap.css">
</head>
<body>
	<div class="container" id="modallogin">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="text-align:center">
                    <img src="./Images/logoks.png" alt="Avatar" style="width:30%" class="">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>                    
                </div>
                <div class="modal-body">
                    <form action="DangNhap" method="post">
                    	<div class="checkbox-login">
                        <label class="col-xs-6 col-md-6 col-sm-6"><input type="radio" value="NhanVien" name="gender" checked> Nhân viên</label>
                        <label class="col-xs-6 col-md-6 col-sm-6"><input type="radio" value="QuanTriVien" name="gender"> Quản trị viên</label>
                    </div>
                        <div class="form-group">
                            <label>Tên đăng nhập:</label>
                            <input type="text" class="form-control" id="txt-user" placeholder="Từ 5 đến 20 ký tự" name="username" required>
                            <span class="error" id="error-user"></span>
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu:</label>
                            <input type="password" class="form-control" id="txt-pass" placeholder="Không ít hơn 5 ký tự" name="password" required>
                            <span class="error" id="error-pass"></span>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" style="margin-top:13px" value="" checked>Lưu mật khẩu</label>
                        </div>
                        <%
                        	String err = request.getParameter("err");
                        	if("fail".equals(err)){
                        		out.println("<h4 style=\"color: red; text-align:center\">Tên đăng nhập hoặc mật khẩu không đúng</h4>");
                        	}
                        %>
                        <span class="error" id="error-login"></span>
                        <div class="div-btnLogin">
                            <button id="btnLogin" type="submit" style="color:white"><span class="fa fa-sign-in"></span> ĐĂNG NHẬP</button>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <p><a href="#" style="color:blue">Quên mật khẩu</a></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>