package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connectionDB.NVThuePhongDB;
import connectionDB.NVTraCuuDB;
import model.ThongTinKhachHang;

@WebServlet("/NV_ChinhSuaDonThuePhong")
public class NV_ChinhSuaDonThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NV_ChinhSuaDonThuePhong() {
        super();
    }

    /*Lấy mã KH đi tìm thông tin khách hàng trên trang CHỈNH SỬA ĐƠN THUÊ PHÒNG*/
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
	
	
	/*Cập nhật ngày trả phòng mới: ngày trả phòng phải lớn hơn hoặc bằng ngày hiện tại trên trang CHỈNH SỬA ĐƠN THUÊ PHÒNG*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String ngayTraPhongMoi=(String)request.getParameter("ngayTraPhongMoi");
		String maKH=(String)request.getParameter("maKH");
		String maPhong=(String)request.getParameter("maPhong");
		String ngayTraPhongCu=(String)request.getParameter("ngayTraPhongCu");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
		int kq=NVThuePhongDB.CapNhatChiTietThue(maKH, maPhong, ngayTraPhongCu, ngayTraPhongMoi,
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
				
		if(kq > 0)
		{
			out.write("{\"check\":\"ok\"}"); 
		    out.flush();
		}
		else
		{
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
			
		
	}
	

	/*Hủy 1 phòng thuê với điều kiện ngày hủy phải bằng ngày nhận phòng(kiểm tra trong sql rồi nhưng kiểm tra ở đây luôn cho chắc ăn)
	 *  trên trang HỦY ĐƠN THUÊ PHÒNG*/	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maKH=(String)request.getParameter("maKH");
		String maPhong=(String)request.getParameter("maPhong");
		String ngayNhanPhong=(String)request.getParameter("ngayNhanPhong");
		
		
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
	    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date();
	    //System.out.println("Ngày hiện tại: " + sdf.format(date));
	    //System.out.println("Ngày nhận: " + ngayNhanPhong);
	    
	    if(ngayNhanPhong.equals(sdf.format(date))) 
	    {
	    	//System.out.println("Ngày nhận bằng ngày hiện tại --> được hủy");
			NVThuePhongDB.HuyDonThuePhong(maKH, maPhong, ngayNhanPhong,
					(String)request.getSession().getAttribute("user"), 
					(String)request.getSession().getAttribute("pass"));
			out.write("{\"check\":\"ok\"}"); 
		    out.flush();
	    }
	    else
	    {
	    	//System.out.println("Ngày nhận ko bằng ngày hiện tại --> Ko đc hủy");
			out.write("{\"check\":\"fail\"}");
			out.flush();
	    }			
		
	}
	

}
