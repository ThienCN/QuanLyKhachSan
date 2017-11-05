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


@WebServlet("/nhap")
public class nhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public nhap() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		
        List<DanhSachPhongTrong> list;
		list = NVTimPhongDB.NVTimPhong("2017-11-05", "2017-11-10", "sa", "12345678");
		if (!list.isEmpty()) {
			
		    response.setContentType("application/json;charset=UTF-8");
		    request.setCharacterEncoding("utf-8");
		    
		    PrintWriter out = response.getWriter();
		    //Import gson-2.2.2.jar
		    Gson gson = new Gson();
		    String objectToReturn = gson.toJson(list); //Convert List -> Json
		    out.write(objectToReturn); //Đưa Json trả về Ajax
		    out.flush();
		} else {
		    PrintWriter out = response.getWriter();
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("application/json");
		    out.write("{\"check\":\"fail\"}");
		    out.flush();
		}


        
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
