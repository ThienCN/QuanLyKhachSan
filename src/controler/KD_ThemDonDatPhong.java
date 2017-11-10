package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.KDDatPhongDB;


@WebServlet("/KD_ThemDonDatPhong")
public class KD_ThemDonDatPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public KD_ThemDonDatPhong() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy thông tin phòng vừa xóa khỏi Bảng Chi tiết đặt phòng
				int phongdon = Integer.parseInt(request.getParameter("phongdon"));
				int phongdoi = Integer.parseInt(request.getParameter("phongdoi"));
				int phongtt = Integer.parseInt(request.getParameter("phongtt"));
				String ngaynhanphong = request.getParameter("ngaynhanphong");
				String ngaytraphong = request.getParameter("ngaytraphong");
				String hoten = request.getParameter("hoten");
				String CMND = request.getParameter("CMND");
				String diachi = request.getParameter("diachi");
				String quoctich = request.getParameter("quoctich");
				String SDT = request.getParameter("SDT");
//				System.out.println(phongdon);
//				System.out.println(phongdoi);
//				System.out.println(phongtt);
//				System.out.println(ngaynhanphong);
//				System.out.println(ngaytraphong);
//				System.out.println(tiencoc);
//				System.out.println(hoten);
//				System.out.println(CMND);
//				System.out.println(diachi);
//				System.out.println(quoctich);
//				System.out.println(SDT);
//				System.out.println(rows);

				String maKD = KDDatPhongDB.TaoMaKhachDat();
				request.getServletContext().setAttribute("maKD", maKD);
				
				int k = KDDatPhongDB.ThemKhachDatMoi(maKD, hoten, CMND, diachi, quoctich, SDT);
				if(k>=1) {
				
					int j; 
					boolean flag=false;
					
					for(j=0; j<phongdon; j++) {
						String maphong = KDDatPhongDB.ChonMaPhongChoKhachDat(ngaynhanphong, ngaytraphong, "1");
						float tiencoc = KDDatPhongDB.TienCocCuaMotPhong(maphong, ngaynhanphong, ngaytraphong);
						
						int b1 = KDDatPhongDB.ChiTietDatPhong(maKD, maphong, ngaynhanphong, ngaytraphong, tiencoc);
						if(b1<=0) {
							//System.out.println("Không thêm được chi tiết đặt phòng!");
							break;
						}
						else {
							flag=true;
							//System.out.println("Thêm thành công!");
						}
					}
					for(j=0; j<phongdoi; j++) {
						String maphong = KDDatPhongDB.ChonMaPhongChoKhachDat(ngaynhanphong, ngaytraphong, "2");
						float tiencoc = KDDatPhongDB.TienCocCuaMotPhong(maphong, ngaynhanphong, ngaytraphong);
						int b2 = KDDatPhongDB.ChiTietDatPhong(maKD, maphong, ngaynhanphong, ngaytraphong, tiencoc);
						if(b2<=0) {
							//System.out.println("Không thêm được chi tiết đặt phòng!");
							break;
						}
						else {
							flag=true;
							//System.out.println("Thêm thành công!");
						}
					}
					for(j=0; j<phongtt; j++) {
						String maphong = KDDatPhongDB.ChonMaPhongChoKhachDat(ngaynhanphong, ngaytraphong, "3");
						float tiencoc = KDDatPhongDB.TienCocCuaMotPhong(maphong, ngaynhanphong, ngaytraphong);
						int b3 = KDDatPhongDB.ChiTietDatPhong(maKD, maphong, ngaynhanphong, ngaytraphong, tiencoc);
						if(b3<=0) {
							//System.out.println("Không thêm được chi tiết đặt phòng!");
							break;
						}
						else {
							flag=true;
							//System.out.println("Thêm thành công!");
						}
					}
					
					response.setContentType("application/json;charset=UTF-8");
				    request.setCharacterEncoding("utf-8");
			        
				    PrintWriter out=response.getWriter();
				    
					if(flag)
					{	
						//System.out.println("OKK!");
						out.write("{\"check\":\"ok\"}");
					    out.flush();
					}
					else
					{
						out.write("{\"check\":\"fail\"}");
					    out.flush();
					}
				}
				else {
					//System.out.println("Không thể thêm KD mới!");
				}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
