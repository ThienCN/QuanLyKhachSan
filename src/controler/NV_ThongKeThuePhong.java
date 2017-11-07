package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connectionDB.NVThongKeDB;
import connectionDB.NVTraCuuDB;
import model.ThongKeThuePhong;
import model.ThongTinKhachHang;
import model.ThongTinThuePhong;

@WebServlet("/NV_ThongKeThuePhong")
public class NV_ThongKeThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NV_ThongKeThuePhong() {
        super();
    }
    
    /*Thống kê thuê phòng*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ngayBatDau=(String)request.getParameter("ngayBatDau");
		String ngayKetThuc=(String)request.getParameter("ngayKetThuc");
		
		String user=(String)request.getSession().getAttribute("user");
		String pass=(String)request.getSession().getAttribute("pass");
		//
		List<ThongKeThuePhong> dsThongKeThuePhong=NVThongKeDB.ThongKeGiaoDichThuePhong(ngayBatDau, ngayKetThuc, user, pass);
		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
		if(!dsThongKeThuePhong.isEmpty())
		{
		    //Import gson-2.2.2.jar
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(dsThongKeThuePhong); //Convert List -> Json
		    out.write(objectToReturn); //Đưa Json trả về Ajax
		    out.flush();
		} 
		else
		{
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}		
	}
	
	/*Thông tin cá nhân và chi tiết thuê phòng của khách hàng*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH=(String)request.getParameter("maKH");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		List<ThongTinKhachHang> thongtinKH=
				NVTraCuuDB.TraCuuThongTinKhachHang(maKH, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		List<ThongTinThuePhong> thongtinThuePhong=
				NVTraCuuDB.TraCuuThongTinThuePhongHienTaiCuaKhachHang(maKH, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		if(!thongtinKH.isEmpty() && !thongtinThuePhong.isEmpty())
		{
			getServletContext().setAttribute("thongKeThongTinKH", thongtinKH); 
			getServletContext().setAttribute("thongKeThongTinThuePhong", thongtinThuePhong);
			out.write("{\"check\":\"ok\"}"); 
		    out.flush();
		}
		else
		{
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	
	
	}

}
