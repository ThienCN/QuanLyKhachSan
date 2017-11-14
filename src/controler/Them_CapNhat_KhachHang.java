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

import connectionDB.NVThuePhongDB;
import connectionDB.NVTraCuuDB;
import model.ThongTinThuePhong;

@WebServlet("/Them_CapNhat_KhachHang")
public class Them_CapNhat_KhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Them_CapNhat_KhachHang() {
        super();
    }
    
    //Thêm một khách hàng mới vào cơ sở dữ liệu --SỬ DỤNG TRONG TRANG THÊM ĐƠN THUÊ PHÒNG
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		//
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
		//		
		String hoten=(String)request.getParameter("hoTenKH");
		String cmnd=(String)request.getParameter("CMND");
		String diachi=(String)request.getParameter("DiaChi");
		String quoctich=(String)request.getParameter("QuocTich");
		String sdt=(String)request.getParameter("SDT");
		
		//Lấy cmnd đi kiểm tra khách hàng này đã tồn tại trong dữ liệu chưa?
		String maKHCu = NVThuePhongDB.KiemTraKhachHang(cmnd, user, pass);
		
		
		//Nếu khách hàng đã tồn tại trong csdl (đã từng thuê phòng)
		if(maKHCu != null) {
			//Thì ta cập nhật thông tin mới của khách hàng
			int kq = NVThuePhongDB.CapNhatKhachHang(maKHCu, hoten, cmnd, diachi, quoctich, sdt, user, pass);
			if(kq == 1) {
				out.write("{\"MaKH\":\""+ maKHCu +"\"}");
				out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}"); 
				out.flush();
			}	
			return;
		}
		else { //Nếu là khách hàng mới thì thêm vào csdl
			String kq=connectionDB.NVThuePhongDB.ThemKhachHangMoi(hoten, cmnd, diachi, quoctich, sdt, user, pass);
			if(kq != null)           
			{
				out.write("{\"MaKH\":\""+ kq +"\"}");
				System.out.println(kq); 
				out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}	
			return;
		}
	}
	
	
	//Cập nhật thông tin khách hàng vào cơ sở dữ liệu --SỬ DỤNG TRONG TRANG CẬP NHẬT ĐƠN THUÊ PHÒNG
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		//		
		String maKH=(String)request.getParameter("maKH");
		String hoTenKH=(String)request.getParameter("hoTenKH");
		String CMND=(String)request.getParameter("CMND");
		String DiaChi=(String)request.getParameter("DiaChi");
		String QuocTich=(String)request.getParameter("QuocTich");
		String SDT=(String)request.getParameter("SDT");
		
		int kq=connectionDB.NVThuePhongDB.CapNhatKhachHang(maKH, hoTenKH, CMND, DiaChi, QuocTich, SDT, user, pass);		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
        
		if(kq>0)
		{
			out.write("{\"check\":\"ok\"}");
			out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}	
		
	}

	
}
