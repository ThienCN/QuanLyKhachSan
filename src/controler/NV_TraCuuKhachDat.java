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

import connectionDB.NVTraCuuDB;
import model.ThongTinDatPhong_NV;
import model.ThongTinKhachDat;

@WebServlet("/NV_TraCuuKhachDat")
public class NV_TraCuuKhachDat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NV_TraCuuKhachDat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maTimKiemKD=(String)request.getParameter("maTimKiemKD");
		
		//System.out.println(maTimKiemKD);
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		List<ThongTinKhachDat> thongtinKD=
				NVTraCuuDB.TraCuuThongTinKhachDat(maTimKiemKD, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		if(!thongtinKD.isEmpty())
		{
			getServletContext().setAttribute("maCodeDatPhong", thongtinKD.get(0).getMaKD());
			//System.out.println("Tìm kiếm khách hàng thành công");
		    //Import gson-2.2.2.jar
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(thongtinKD); //Convert List -> Json
		    out.write(objectToReturn); //Đưa Json trả về Ajax
		    out.flush();
		}
		else
		{
			//System.out.println("Không có kết quả");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	
	}

	/*Lấy mã KD đi tìm kiếm thông tin đặt phòng hiện tại (TRA CỨU KHÁCH ĐẶT, CHỈNH SỬA VÀ HỦY ĐƠN ĐẶT PHÒNG)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maKD=(String)request.getParameter("maKD");
		
		//System.out.println(maKHTimKiem);
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		List<ThongTinDatPhong_NV> thongtinDatPhong_NV=
				NVTraCuuDB.TraCuuThongTinDatPhongHienTaiCuaKhachDat(maKD, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		
		
		if(!thongtinDatPhong_NV.isEmpty())
		{
			getServletContext().setAttribute("thongtinDatPhong_NV", thongtinDatPhong_NV);
			
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(thongtinDatPhong_NV); //Convert List -> Json
		    out.write(objectToReturn); //Đưa Json trả về Ajax
		    out.flush();
		}
		else
		{
			//System.out.println("Không có kết quả");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maTimKiemKD=(String)request.getParameter("maTimKiemKD");
		
		//System.out.println(maTimKiemKD);
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		List<ThongTinKhachDat> thongtinKD=
				NVTraCuuDB.TraCuuThongTinKhachDat(maTimKiemKD, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		
		//Bỏ thông tin KD này vào application scope để nếu KD có đặt thêm phòng
		//thì lấy thông tin bỏ lên bảng Thông tin khách đặt bên trang Thêm đơn đặt phòng
		getServletContext().setAttribute("thongTinKDCu", thongtinKD);
		
		out.write("{\"check\":\"ok\"}");
		out.flush();
	
	}
}
