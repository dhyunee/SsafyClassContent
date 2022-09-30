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

import Dto.UserDto;
import Service.LoginService;
import Service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/login","/logout"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//logout
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logout
		HttpSession session=request.getSession();
		session.invalidate();
		
		Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", "success");
        
        String jsonStr = gson.toJson(jsonObject);
        response.getWriter().write(jsonStr);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

//login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userEmail=request.getParameter("userEmail");
		String userPassword=request.getParameter("userPassword");
		LoginService service=LoginServiceImpl.getInstance();
		System.out.println(service);
		UserDto userDto=service.login(userEmail, userPassword);
		
		System.out.println(userDto);
		
		//성공, 실패에 대한 처리
		//성공 1. session에 사용자 정보 userdto를 저장 2. 로그인 성공 결과를 client에게 return(json)
		//실패: 로그인 실패 결과를 client에 return
		
		if(userDto!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("userDto",userDto);
			
			Gson gson=new Gson();
			JsonObject jsonobject=new JsonObject();
			jsonobject.addProperty("result","success");
			
			String jsonStr=gson.toJson(jsonobject);
			response.getWriter().write(jsonStr);
			System.out.println(jsonStr);
			System.out.println("LoginServlet-login success");
			
		}else {
			Gson gson=new Gson();
			JsonObject jsonobject=new JsonObject();
			jsonobject.addProperty("result","fail");
			
			String jsonStr=gson.toJson(jsonobject);
			response.getWriter().write(jsonStr);
			System.out.println(jsonStr);
			System.out.println("LoginServlet-login fail");	
		}
	}
}