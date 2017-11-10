package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connectionDB.KDDatPhongDB;
import connectionDB.KDTimPhongDB;

import java.util.*;

import model.SoLuongPhongTrong;
import model.ThongTinDatPhong;

@WebServlet("/KD_ThongTinDatPhong")
public class KD_ThongTinDatPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KD_ThongTinDatPhong() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy thông tin đặt phòng
		String maloaiphong = request.getParameter("maloaiphong");
		int sophong = Integer.parseInt(request.getParameter("sophong"));
		String ngaynhanphong = request.getParameter("ngaynhanphong");
		String ngaytraphong = request.getParameter("ngaytraphong");
		float tiencoc = Float.parseFloat(request.getParameter("tiencoc"));
		

//		System.out.println(maloaiphong);
//		System.out.println(sophong);
//		System.out.println(ngaynhanphong);
//		System.out.println(ngaytraphong);
//		System.out.println(tiencoc);
		
		//Lấy dsThongTinDatPhong được lưu trong application scope ra
		List<ThongTinDatPhong> thongtindatphong= (List<ThongTinDatPhong>)getServletContext().getAttribute("thongtindatphong");
		//Thêm thông tin phòng mới thuê vào
		thongtindatphong.add(new ThongTinDatPhong(maloaiphong, sophong, ngaynhanphong, ngaytraphong, tiencoc));
//		for(ThongTinDatPhong i :thongtindatphong) {
//			System.out.println(i.getMaLoaiPhong());
//			System.out.println(i.getSoPhong());
//			System.out.println(i.getNgayNhanPhong());
//			System.out.println(i.getNgayTraPhong());
//			System.out.println(i.getTienCoc());
//			System.out.println("------");
//			System.out.println("Đã lưu thành công phòng ");
//		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy thông tin phòng vừa xóa khỏi Bảng Chi tiết đặt phòng
		String maloaiphong = request.getParameter("maloaiphong");
		int sophong = Integer.parseInt(request.getParameter("sophong"));
		String ngaynhanphong = request.getParameter("ngaynhanphong");
		String ngaytraphong = request.getParameter("ngaytraphong");
		float tiencoc = Float.parseFloat(request.getParameter("tiencoc"));
//		System.out.println("=======");
//		System.out.println("=======");
//		System.out.println(maloaiphong);
//		System.out.println(sophong);
//		System.out.println(ngaynhanphong);
//		System.out.println(ngaytraphong);
//		System.out.println(tiencoc);
			
//		//Lấy dsThongTinDatPhong được lưu trong application scope ra
		List<ThongTinDatPhong> thongtindatphong = (List<ThongTinDatPhong>)getServletContext().getAttribute("thongtindatphong");
		
		//Tìm phòng muốn xóa trong dsThongTinPhongThue và xóa đi
		int n=thongtindatphong.size();
		for(int i=0; i<n; i++) {
			ThongTinDatPhong p=thongtindatphong.get(i);
			if(p.getMaLoaiPhong().equals(maloaiphong) && p.getSoPhong() == sophong && p.getTienCoc() == tiencoc) 				 
			{ 
				thongtindatphong.remove(i);
				System.out.println("Đã xóa thành công phòng ");
				break;
			}				
		}
//		System.out.println("=======");
//		for(ThongTinDatPhong i :thongtindatphong) {
//			System.out.println(i.getMaLoaiPhong());
//			System.out.println(i.getSoPhong());
//			System.out.println(i.getNgayNhanPhong());
//			System.out.println(i.getNgayTraPhong());
//			System.out.println(i.getTienCoc());
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		List<ThongTinDatPhong> thongtindatphong = (List<ThongTinDatPhong>)getServletContext().getAttribute("thongtindatphong");
		int n = thongtindatphong.size();
		int phongdon = 0, phongdoi = 0, phongtt = 0;
		for(int i=0; i<n; i++) {
			ThongTinDatPhong p=thongtindatphong.get(i);
			if(p.getMaLoaiPhong().equals("1"))
			{ 
				phongdon+=p.getSoPhong();
			}
			if(p.getMaLoaiPhong().equals("2"))
			{ 
				phongdoi+=p.getSoPhong();
			}
			if(p.getMaLoaiPhong().equals("3"))
			{ 
				phongtt+=p.getSoPhong();
			}
//			System.out.println(phongdon);
//			System.out.println(phongdoi);
//			System.out.println(phongtt);
		}
		
		if(!thongtindatphong.isEmpty()) {
			Gson gson = new Gson();
			//Convert List to Json
			String objectToReturn=gson.toJson(thongtindatphong);
			//Đưa Json trả về Ajax
			out.write(objectToReturn);
			out.flush();
		}else
		{
			System.out.println("danh sach trong");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ThongTinDatPhong> thongtindatphong = (List<ThongTinDatPhong>)getServletContext().getAttribute("thongtindatphong");
		thongtindatphong.clear();
	}
	
}
