package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/maintain")
public class MaintaindataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("attr1", "value2");//request
		getServletContext().setAttribute("attr2", "value2");//servlet context
		request.getSession().setAttribute("attr3", "value3");//session
		
		//forward
//		request.getRequestDispatcher("/maintain2").forward(request, response);
		
		//send redirect
		response.sendRedirect("/Webbasic2/maintain2");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
