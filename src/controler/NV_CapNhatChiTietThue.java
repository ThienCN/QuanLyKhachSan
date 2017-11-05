package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ThongTinThuePhong;

@WebServlet("/NV_CapNhatChiTietThue")
public class NV_CapNhatChiTietThue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_CapNhatChiTietThue() {
        super();
    }

    /*Lưu 1 chi tiết thuê vào CSDL*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH=(String)request.getParameter("maKH");
		String loaiPhong=(String)request.getParameter("loaiPhong");
		String maPhong=(String)request.getParameter("maPhong");
		String ngayNhanPhong=(String)request.getParameter("ngayNhanPhong");
		String ngayTraPhong=(String)request.getParameter("ngayTraPhong");
		//System.out.println(request.getParameter("tienPhong"));
		float tienPhong=Float.parseFloat(request.getParameter("tienPhong"));
		//System.out.println(tienPhong);
		
		String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		
		//Lưu lại thông tin để sử dụng cho việc hủy giao dịch thuê phòng
		//Lấy thông tin thuê phòng trong quá trình thực hiện giao dịch 
		List<ThongTinThuePhong> thongtinThuePhongTamThoi=
				(List<ThongTinThuePhong>)getServletContext().getAttribute("thongtinThuePhongTamThoi");
		//Nếu thông tin chưa tồn tại trong application scope thì khởi tạo rồi lưu nó vào scope
		if(thongtinThuePhongTamThoi == null)
		{
			//System.out.println("Khởi tạo list thuê tạm"); 
			thongtinThuePhongTamThoi=new ArrayList<ThongTinThuePhong>(); 
			thongtinThuePhongTamThoi.add(new ThongTinThuePhong(maKH,loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong,tienPhong));
			getServletContext().setAttribute("thongtinThuePhongTamThoi", thongtinThuePhongTamThoi);
		}			
		else//Nếu có rồi thì chỉ việc thêm vào
			thongtinThuePhongTamThoi.add(new ThongTinThuePhong(maKH,loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong,tienPhong));
				
		int kq=connectionDB.NVThuePhongDB.ThemChiTietThue(maKH, maPhong, ngayNhanPhong, ngayTraPhong,user, pass);
        
		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
        
		if(kq>0)
		{
			//System.out.println("Thêm phòng thuê thành công");
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		}
		else {
			//System.out.println("Thêm phòng thuê không thành công");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}	
		
		
	}

	
	/*Hủy toàn bộ giao dịch thuê phòng*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		
		//Lấy thông tin thuê phòng tạm thời được lưu trong quá trình thực hiện giao dịch thuê phòng
		List<ThongTinThuePhong> thongtinThuePhongTamThoi=
				(List<ThongTinThuePhong>)getServletContext().getAttribute("thongtinThuePhongTamThoi");
		
		//Nếu có tồn tại thì thực hiện xóa các chi tiết thuê này
		if(thongtinThuePhongTamThoi != null)   
		{
			String makhachhang,maphong,ngaynhanphong;
			int n=thongtinThuePhongTamThoi.size();
			for(int i=0; i<n; i++)
			{
				ThongTinThuePhong p = thongtinThuePhongTamThoi.get(i);
				makhachhang=p.getMaKH();
				maphong=p.getMaPhong();
				ngaynhanphong=p.getNgayNhanPhong();
				connectionDB.NVThuePhongDB.XoaChiTietThue(makhachhang, maphong, ngaynhanphong, user, pass);
			}
			getServletContext().setAttribute("thongtinThuePhongTamThoi", null);
		}		
		
		String maKH = (String)request.getParameter("maKH");
		String ngayNhanPhong = (String)request.getParameter("ngayNhanPhong");
		
		//System.out.println(maKH);
		//System.out.println(ngayNhanPhong);

		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		//Hủy giao dịch thuê phòng thực hiện việc xóa thông tin KH nếu như KH này là KH mới
		connectionDB.NVThuePhongDB.HuyGiaoDichThuePhong(maKH, ngayNhanPhong, user, pass);
		
		//System.out.println("Hủy giao dịch thuê phòng thành công");	
		out.write("Yes");
		out.flush();
	}
	
	/*Xóa một chi tiết thuê với điều kiện phòng đó chưa được sử dụng 
	 * --> tức là ngày xóa phải là ngày ban đầu thuê*/
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy thông tin phòng vừa xóa khỏi Bảng Chi tiết thuê phòng
		String maKH = (String)request.getParameter("maKhachHang");
		String maPhong=(String)request.getParameter("maPhong");
		String ngayNhanPhong=(String)request.getParameter("ngayNhanPhong");
		
//		System.out.println(maKH);
//        System.out.println(maPhong);
//        System.out.println(ngayNhanPhong);
		
        String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		
		int kq=connectionDB.NVThuePhongDB.XoaChiTietThue(maKH, maPhong, ngayNhanPhong, user, pass);
		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
		if(kq>0)
		{
			//System.out.println("Thêm phòng thuê thành công");
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		}
		else {
			//System.out.println("Thêm phòng thuê không thành công");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}		
		
		
	}

}
