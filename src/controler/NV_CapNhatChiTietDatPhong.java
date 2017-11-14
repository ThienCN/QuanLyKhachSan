package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ThongTinDatPhong_NV;;

@WebServlet("/NV_CapNhatChiTietDatPhong")
public class NV_CapNhatChiTietDatPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NV_CapNhatChiTietDatPhong() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKD=(String)request.getParameter("maKD");
		String loaiPhong=(String)request.getParameter("loaiPhong");
		String maPhong=(String)request.getParameter("maPhong");
		String ngayNhanPhong=(String)request.getParameter("ngayNhanPhong");
		String ngayTraPhong=(String)request.getParameter("ngayTraPhong");
		float tienPhong=Float.parseFloat(request.getParameter("tienPhong"));
		//int tinhTrang=Integer.parseInt(request.getParameter("tinhTrang"));
		//System.out.println(tienPhong);
		
		
		
		String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		
		//Lấy danh sách thông tin đặt phòng tạm thời 
		List<ThongTinDatPhong_NV> thongtinDatPhongTamThoi =
					(List<ThongTinDatPhong_NV>)request.getSession().getAttribute("thongtinDatPhongTamThoi");
				
		//Lưu chi tiết đặt vào danh sách đặt phòng tạm thời
		//System.out.println("Thêm chi tiết đặt vào ds đặt phòng tạm thời-->ds đã đc tạo rồi"); 
		thongtinDatPhongTamThoi.add(new ThongTinDatPhong_NV(maKD, loaiPhong, maPhong, ngayNhanPhong, ngayTraPhong, 1, tienPhong, null));
		
		
		int kq=connectionDB.NVDatPhongDB.ThemChiTietDatPhong(maKD, maPhong, ngayNhanPhong, ngayTraPhong, (float)(tienPhong * 0.1), user, pass);
        
		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
        
		if(kq>0)
		{
			//System.out.println("Thêm phòng đặt thành công");
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		}
		else {
			//System.out.println("Thêm phòng đặt không thành công");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}	
		
		
	}
	
	/*Hủy toàn bộ giao dịch đặt phòng*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		
		//Lấy thông tin đặt phòng tạm thời được lưu trong quá trình thực hiện giao dịch đặt phòng
		List<ThongTinDatPhong_NV> thongtinDatPhongTamThoi=
				(List<ThongTinDatPhong_NV>)request.getSession().getAttribute("thongtinDatPhongTamThoi"); 
		
		//Nếu có tồn tại thì thực hiện xóa các chi tiết đặt này
		if(thongtinDatPhongTamThoi != null)   
		{
			//System.out.println("Có danh sách đặt phòng tạm thời-->Xóa ds đặt phòng tạm thời");
			String makhachdat,maphong,ngaynhanphong;
			int n=thongtinDatPhongTamThoi.size();
			for(int i=0; i<n; i++)
			{
				ThongTinDatPhong_NV p = thongtinDatPhongTamThoi.get(i);
				makhachdat=p.getMaKD();
				maphong=p.getMaPhong();
				ngaynhanphong=p.getNgayNhanPhong();
				connectionDB.NVDatPhongDB.XoaChiTietDatPhong(makhachdat, maphong, ngaynhanphong, user, pass);
			}
		}		
		
		String maKD = (String)request.getParameter("maKD");
		
		//System.out.println(maKD);

		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		//Hủy giao dịch thuê phòng thực hiện việc xóa thông tin KH nếu như KH này là KH mới
		connectionDB.NVDatPhongDB.HuyGiaoDichDatPhong(maKD, user, pass);
		
		//System.out.println("Hủy giao dịch thuê phòng thành công");	
		out.write("Yes");
		out.flush();
	}
	
	/*Xóa một chi tiết đặt 
	 * --> tức là chỉ đươc xóa khi đang trong quá trình thực hiện giao dịch đặt phòng*/
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy thông tin phòng vừa xóa khỏi Bảng Chi tiết đặt phòng
		String maKD = (String)request.getParameter("maKD");
		String maPhong=(String)request.getParameter("maPhong");
		String ngayNhanPhong=(String)request.getParameter("ngayNhanPhong");
		
//		System.out.println(maKD);
//        System.out.println(maPhong);
//        System.out.println(ngayNhanPhong);
		
        String user=(String)request.getSession().getAttribute("user");
		String pass =(String)request.getSession().getAttribute("pass");
		
		int kq=connectionDB.NVDatPhongDB.XoaChiTietDatPhong(maKD, maPhong, ngayNhanPhong, user, pass);
		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
		if(kq>0)
		{
			//System.out.println("Thêm phòng đặt thành công");
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		}
		else {
			//System.out.println("Thêm phòng đặt không thành công");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}		
		
		
	}

}
