package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Dao.UserDaoImpl;
import Dto.UserDto;
import Service.UserService;
import Service.UserServiceImpl;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String contextPath=null;
	UserService userService = UserServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
	contextPath = request.getContextPath();
		String path = (String)request.getRequestURI().substring(contextPath.length());
		System.out.println(path);
		String action=request.getParameter("action");
		switch(action) {
		case "regist":
			regist(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		}
	}
	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		UserDto userDto = new UserDto();
		userDto.setUserName(userName);
		userDto.setUserEmail(userEmail);
		userDto.setUserPassword(userPassword);
		
		int ret=-1;
		try {
			ret = userService.userRegister(userDto);
			response.sendRedirect(contextPath+"/login.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 
		 UserDto userDto=(UserDto) request.getSession().getAttribute("userDto");
	      try {
	    	  userService.deleteUser(userDto);
	         request.getSession().invalidate();
	         request.getRequestDispatcher("/index.jsp").forward(request,response);
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}

}
