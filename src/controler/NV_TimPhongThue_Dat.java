package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connectionDB.NVTimPhongDB;
import model.DanhSachPhongTrong;

@WebServlet("/NV_TimPhongThue_Dat")
public class NV_TimPhongThue_Dat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NV_TimPhongThue_Dat() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ngayNhan=(String)request.getParameter("ngayNhan");
		String ngayTra=(String)request.getParameter("ngayTra");
		
		//System.out.println(ngayNhan);
		//System.out.println(ngayTra);
		
		
		response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        PrintWriter out=response.getWriter();
		
		List<DanhSachPhongTrong> dsPhongTrong=
				NVTimPhongDB.NVTimPhong(ngayNhan, ngayTra, 
				(String)request.getSession().getAttribute("user"), 
				(String)request.getSession().getAttribute("pass"));
		
		if(!dsPhongTrong.isEmpty())
		{
			//System.out.println("Co danh sach");
			////Import gson-2.2.2.jar --> Create Gson
			Gson gson=new Gson();
			//Convert List --> Json
			String objectToReturn=gson.toJson(dsPhongTrong);
			//Đưa Json trả về Ajax
			out.write(objectToReturn);
			out.flush();
		}
		else
		{
			System.out.println("danh sach trong");
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
