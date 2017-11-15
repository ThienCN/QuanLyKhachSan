package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connectionDB.NVLapHoaDon;
import connectionDB.NVTimPhongDB;
import model.ThongTinHoaDon;


@WebServlet("/NV_LapHoaDon")
public class NV_LapHoaDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NV_LapHoaDon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
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

}
