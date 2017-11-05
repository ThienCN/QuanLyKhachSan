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
import model.ThongTinKhachHang;
import model.ThongTinThuePhong;

@WebServlet("/NV_TraCuuKhachHang")
public class NV_TraCuuKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NV_TraCuuKhachHang() {
        super();
    }

    /*Lấy mã tìm kiếm và trả về thông tin khách hàng trên trang TRA CỨU KHÁCH HÀNG*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maTimKiemKH=(String)request.getParameter("maTimKiemKH");
		
		//System.out.println(maTimKiemKH);
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		List<ThongTinKhachHang> thongtinKH=
				NVTraCuuDB.TraCuuThongTinKhachHang(maTimKiemKH, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		//Bỏ thông tin KH này vào application scope để nếu KH có thuê thêm phòng
		//thì lấy thông tin bỏ lên bảng Thông tin khách hàng bên trang Thêm đơn thuê phòng
		getServletContext().setAttribute("thongTinKHCu", thongtinKH); 
		
		if(!thongtinKH.isEmpty())
		{
			//System.out.println("Tìm kiếm khách hàng thành công");
		    //Import gson-2.2.2.jar
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(thongtinKH); //Convert List -> Json
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

	/*Lấy mã KH đi tìm kiếm thông tin thuê phòng hiện tại (TRA CỨU KHÁCH HÀNG, CHỈNH SỬA VÀ HỦY ĐƠN THUÊ PHÒNG)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maKH=(String)request.getParameter("maKH");
		
		//System.out.println(maKHTimKiem);
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		List<ThongTinThuePhong> thongtinThuePhong=
				NVTraCuuDB.TraCuuThongTinThuePhongHienTaiCuaKhachHang(maKH, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		if(!thongtinThuePhong.isEmpty())
		{
			//System.out.println("Tìm kiếm khách hàng thành công");
		    //Import gson-2.2.2.jar
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(thongtinThuePhong); //Convert List -> Json
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

	
}
