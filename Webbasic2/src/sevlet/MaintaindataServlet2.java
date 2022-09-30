package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/maintain2")
public class MaintaindataServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String att1=(String)request.getAttribute("attr1");
		String att2=(String)getServletContext().getAttribute("attr2");
		String att3=(String)request.getSession().getAttribute("attr3");
		
		System.out.println(att1);
		System.out.println(att2);
		System.out.println(att3);
		
		response.getWriter().append("maintaindataservlet2");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
