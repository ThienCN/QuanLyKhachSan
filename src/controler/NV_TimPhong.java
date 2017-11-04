package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import model.DanhSachPhongTrong;
import connectionDB.NVTimPhongDB;

@WebServlet("/NV_TimPhong")
public class NV_TimPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NV_TimPhong() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); 
		
		String ngayNhanPhong=request.getParameter("ngayNhanPhong");
		String ngayTraPhong=request.getParameter("ngayTraPhong");
	
		List<DanhSachPhongTrong> dsPhongTrong = 
				NVTimPhongDB.NVTimPhong(ngayNhanPhong, ngayTraPhong, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass")); 
		
		getServletContext().setAttribute("ngayNhanPhong", ngayNhanPhong);
		getServletContext().setAttribute("ngayTraPhong", ngayTraPhong); 
		getServletContext().setAttribute("dsPhongTrong", dsPhongTrong);
		response.sendRedirect("tim-phong.jsp"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
