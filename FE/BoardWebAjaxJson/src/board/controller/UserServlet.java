package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.dto.UserDto;
import board.service.UserService;
import board.service.UserServiceImpl;


@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService=UserServiceImpl.getInstance();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String userEmail=request.getParameter("userEmail");
		String userPassword=request.getParameter("userPassword");
		
		System.out.println(userName+ " " + userEmail+" "+ userPassword);
		
		UserDto userDto =new UserDto();
		userDto.setUserName(userName);
		userDto.setUserEmail(userEmail);
		userDto.setUserPassword(userPassword);
		
		int ret=userService.userRegister(userDto);
		
		Gson gson=new Gson();
		JsonObject jsonobject=new JsonObject();

		if(ret==1) {
			jsonobject.addProperty("result","success");
		}else {
			jsonobject.addProperty("result","fail");
		}

		String jsonStr=gson.toJson(jsonobject);
		response.getWriter().write(jsonStr);
	}

}
