package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.NVDatPhongDB;

@WebServlet("/NV_ChinhSuaDonDatPhong")
public class NV_ChinhSuaDonDatPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_ChinhSuaDonDatPhong() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	/*Hủy 1 phòng đặt với điều kiện ngày hủy phải nhỏ hơn hoặc bằng ngày nhận phòng(kiểm tra trong sql rồi nhưng kiểm tra ở đây luôn cho chắc ăn)
	 *  trên trang HỦY ĐƠN ĐẶT PHÒNG*/	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKhachDat=(String)request.getParameter("maKhachDat");
		String maPhong=(String)request.getParameter("maPhong");
		String ngayNhanPhong=(String)request.getParameter("ngayNhanPhong");
		String nguoiHuy = (String)request.getParameter("nguoiHuy");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
        
	    PrintWriter out=response.getWriter();
		
	    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date();	  
	    
	    //Ngày hủy phải nhỏ hơn hoặc bằng ngày nhận phòng
	    try {
	    	
	    	Date ngayNhan = sdf.parse(ngayNhanPhong);
		    Date today = sdf.parse(sdf.format(date));		    
		    
	    	if(today.compareTo(ngayNhan) <= 0)
			{			
				
				int kq = NVDatPhongDB.HuyDonDatPhong(maKhachDat, maPhong, ngayNhanPhong, nguoiHuy, 
						(String)request.getSession().getAttribute("user"), 
						(String)request.getSession().getAttribute("pass"));
				
				if(kq == 1) {
					out.write("{\"check\":\"ok\"}"); 
				    out.flush();
				}
				else
				{
					out.write("{\"check\":\"fail\"}");
					out.flush();
				}
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	
	}

}
