package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connectionDB.NVTraCuuDB;
import model.ThongTinDatPhong_NV;
import java.util.*;

@WebServlet("/KD_XacNhanNhanPhong")
public class KD_XacNhanNhanPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KD_XacNhanNhanPhong() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ThongTinDatPhong_NV> thongtinDatPhong_NV = (List<ThongTinDatPhong_NV>) getServletContext()
				.getAttribute("thongtinDatPhong_NV");

		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		if (!thongtinDatPhong_NV.isEmpty()) {
			
			//System.out.println("Tìm kiếm khách hàng thành công");
		    //Import gson-2.2.2.jar
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(thongtinDatPhong_NV); //Convert List -> Json
		    out.write(objectToReturn); //Đưa Json trả về Ajax
		    out.flush();
		}
		else
		{
			//System.out.println("Không có kết quả");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		
		Date date = new Date();
		System.out.println(date);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maCodeDatPhong = (String)getServletContext().getAttribute("maCodeDatPhong");
		
		List<ThongTinDatPhong_NV> thongtinDatPhong_NV = (List<ThongTinDatPhong_NV>) getServletContext()
				.getAttribute("thongtinDatPhong_NV");
		
		java.sql.Date ngayhientai = (java.sql.Date) new Date(Calendar.getInstance().getTimeInMillis());
		System.out.println(ngayhientai);
	}

}
