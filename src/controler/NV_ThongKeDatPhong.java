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
import model.ThongKeDatPhong;
import model.ThongTinDatPhong;
import model.ThongTinDatPhong_NV;
import model.ThongTinKhachDat;
import model.ThongTinKhachHang;
import model.ThongTinThuePhong;

@WebServlet("/NV_ThongKeDatPhong")
public class NV_ThongKeDatPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_ThongKeDatPhong() {
        super();
    }
    /*Thống kê đặt phòng*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ngayBatDau=(String)request.getParameter("ngayBatDau");
		String ngayKetThuc=(String)request.getParameter("ngayKetThuc"); 
		
		
		String user=(String)request.getSession().getAttribute("user");
		String pass=(String)request.getSession().getAttribute("pass");
		//
		List<ThongKeDatPhong> dsThongKeDatPhong = NVThongKeDB.ThongKeGiaoDichDatPhong(ngayBatDau, ngayKetThuc, user, pass);
		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
		if(!dsThongKeDatPhong.isEmpty())
		{
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(dsThongKeDatPhong); 
		    out.write(objectToReturn);
		    out.flush();
		} 
		else
		{
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}	
	}

	/*Thông tin cá nhân và chi tiết đặt phòng của khách đặt*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKhachDat=(String)request.getParameter("maKhachDat");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		List<ThongTinKhachDat> thongtinKhachDat=
				NVTraCuuDB.TraCuuThongTinKhachDat(maKhachDat, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		List<ThongTinDatPhong_NV> thongtinDatPhong=
				NVTraCuuDB.TraCuuThongTinDatPhongHienTaiCuaKhachDat(maKhachDat, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass")); 
		
		if(!thongtinKhachDat.isEmpty() && !thongtinDatPhong.isEmpty())
		{
			getServletContext().setAttribute("thongKeThongTinKhachDat", thongtinKhachDat); 
			getServletContext().setAttribute("thongKeThongTinDatPhong", thongtinDatPhong);
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
