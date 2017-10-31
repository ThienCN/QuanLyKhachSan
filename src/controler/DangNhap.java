package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connectionDB.ConnectDB;
import connectionDB.NguoiDungDB;



@WebServlet("/DangNhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DangNhap() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		String gender = request.getParameter("gender");
		//System.out.println("User: " + user);
		//System.out.println("Pass: " + pass);
		
		
		int role = 0;
		if (("QuanTriVien").equals(gender)) {
			role = 1;
		}
		if (("NhanVien").equals(gender))
			role = 2;
		
		//
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=ConnectDB.getConnect_sa();
			if(conn==null)
				return;
			String sql="SELECT * FROM dbo.TAIKHOAN WHERE tenTK= ? AND matKhau= ? AND quyenTruyCap= ?";
			
			
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			pstmt.setInt(3, role);
			ResultSet kq;
			kq = pstmt.executeQuery();
			
			
			if(kq.next()) {
				if(role==1)
					response.sendRedirect("quan-tri-vien.jsp");										
				if(role==2)
					response.sendRedirect("nhan-vien.jsp");
				//
				getServletContext().setAttribute("user", user);
				getServletContext().setAttribute("pass", pass);
				getServletContext().setAttribute("role", role);
			}
			else
				response.sendRedirect("login.jsp?err=fail");
			
		}catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                	pstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
