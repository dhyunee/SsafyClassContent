package sevlet;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionmakeservlet")
public class sessionmakeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("userId", "songb");//문자열
		int [] intArray= {1,2,3,4,5};
		session.setAttribute("intArray", intArray);//배열
		String [] strArray= {"a","ab","abc"};
		List<String>strList=Arrays.asList(strArray);
		session.setAttribute("strList", strList);
		
		System.out.println("session에 객체를 저장");
		
		response.getWriter().append("ssesion added!!!");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
