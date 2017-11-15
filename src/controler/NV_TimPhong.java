package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.List;
import model.DanhSachPhongTrong;
import model.SoLuongPhongTrong;
import connectionDB.KDTimPhongDB;
import connectionDB.NVTimPhongDB;

@WebServlet("/NV_TimPhong")
public class NV_TimPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NV_TimPhong() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ngayNhanPhong=request.getParameter("ngayNhanPhong");
		String ngayTraPhong=request.getParameter("ngayTraPhong");
//		request.getSession().setAttribute("ngaynhanphong", ngayNhanPhong);
//		request.getSession().setAttribute("ngaytraphong", ngayTraPhong);
	
		List<DanhSachPhongTrong> dsPhongTrong = 
				NVTimPhongDB.NVTimPhong(ngayNhanPhong, ngayTraPhong, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass")); 
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = response.getWriter();
		
		if(!dsPhongTrong.isEmpty()) {
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(dsPhongTrong); 
		    out.write(objectToReturn); 
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ngaynhanphong = request.getParameter("ngaynhanphong");
		String ngaytraphong = request.getParameter("ngaytraphong");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    
		PrintWriter out=response.getWriter();
		
		List<SoLuongPhongTrong> phongtrong;
		try {
			phongtrong = NVTimPhongDB.SoLuongLoaiPhongTrong(ngaynhanphong, ngaytraphong);				
			
			if(!phongtrong.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(phongtrong);
				out.write(objectToReturn);
				out.flush();
			}
			else
			{
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
