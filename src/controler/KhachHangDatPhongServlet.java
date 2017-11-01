package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.SoLuongPhongTrongDB;
import model.SoLuongPhongTrong;

@WebServlet("/KhachHangDatPhongServlet")
public class KhachHangDatPhongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KhachHangDatPhongServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<SoLuongPhongTrong> listphong;
//		try {
//			listphong = SoLuongPhongTrongDB.soPhongTrongTungLoai();
//			for(SoLuongPhongTrong i :listphong) {
//				if(i.getMaLoaiPhong()=="1") {
//					
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
