

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParameterServlet")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		System.out.println(username);
		
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("username: "+ username);
		
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
