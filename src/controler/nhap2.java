package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/nhap2")
public class nhap2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public nhap2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
        String name= request.getParameter("name");
        String age= request.getParameter("age");
        String nguoiyeu= request.getParameter("nguoiyeu");
        
        System.out.println(name);
        System.out.println(age);
        System.out.println(nguoiyeu);
        

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
