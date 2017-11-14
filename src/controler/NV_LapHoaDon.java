package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connectionDB.NVLapHoaDon;
import model.ThongTinHoaDon;


@WebServlet("/NV_LapHoaDon")
public class NV_LapHoaDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NV_LapHoaDon() {
        super();
    }

//    Kiểm tra ngày khách hàng thanh toán có hợp lệ không
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH = request.getParameter("maKH");
		String user = (String)request.getSession().getAttribute("user");
		String pass = (String)request.getSession().getAttribute("pass");
		
		Date ngayThanhToan=NVLapHoaDon.KiemTraXuatHoaDon(maKH, user, pass);
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = response.getWriter();
		
		if(ngayThanhToan != null) {
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(ngayThanhToan);  
		    out.write(objectToReturn); 
		    out.flush();
		}
		else {
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		}
		
	}


// Lấy mã KH đi tìm các thông tin trên hóa đơn
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH = request.getParameter("maKH");
		String user = (String)request.getSession().getAttribute("user");
		String pass = (String)request.getSession().getAttribute("pass");
		
		String maHD = NVLapHoaDon.MaHoaDonMoi(user, pass);
		float tienPhong=NVLapHoaDon.TinhTongTienPhong(maKH, user, pass);
		float tienDenBu=NVLapHoaDon.TinhTienDenBu(maKH, user, pass);
		float tienSuDungDichVu=NVLapHoaDon.TinhTongTienSuDungDichVu(maKH, user, pass);
		float tienCoc = NVLapHoaDon.TinhTienCoc(maKH, user, pass);
		
		List<ThongTinHoaDon> thongTinHD = new ArrayList<ThongTinHoaDon>();
		thongTinHD.add(new ThongTinHoaDon(maHD, tienPhong, tienSuDungDichVu, tienDenBu, tienCoc));
		
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = response.getWriter();
		
		if(!thongTinHD.isEmpty()) {
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(thongTinHD);  
		    out.write(objectToReturn); 
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	
	
	}

// Lấy thông tin hóa đơn lưu xuống cơ sở dữ liệu
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH = request.getParameter("maKH");
		float tongTienPhong = Float.parseFloat(request.getParameter("tongTienPhong"));
		float tongTienSuDungDichVu =  Float.parseFloat(request.getParameter("tongTienSuDungDichVu"));
		float tienDenBu = Float.parseFloat(request.getParameter("tienDenBu"));
		float tienDatCoc = Float.parseFloat(request.getParameter("tienDatCoc"));
		float tongTienCanThanhToan = Float.parseFloat(request.getParameter("tongTienCanThanhToan"));
		
		String user = (String)request.getSession().getAttribute("user");
		String pass = (String)request.getSession().getAttribute("pass");
		
		NVLapHoaDon.LapHoaDon(maKH, tongTienPhong, tongTienSuDungDichVu, tienDenBu, 
							tienDatCoc, tongTienCanThanhToan, user, pass); 		
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = response.getWriter();
		
		out.write("{\"check\":\"ok\"}");
	    out.flush();
	
	
	}


}
