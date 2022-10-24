package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;

//: /mvc/list
//: /mvc/insert
//: /mvc/update
@WebServlet("/mvc/*")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//encoding 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//jsp�� forward �� ��쿡�� �ʿ� ����
		

		String contextPath=request.getContextPath();
		System.out.println(contextPath);
		String path=request.getRequestURI().substring(contextPath.length());
		System.out.println(path);
		
		switch(path) {
		case"/mvc/list":list(request,response);break;
		case"/mvc/insert":System.out.println("insert job");break;
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

		ArrayList<UserDto>list=new ArrayList<>();
		list.add(new UserDto(1111,"홍길동","hong@mail.com"));
		list.add(new UserDto(1211,"이길동","lee@mail.com"));
		list.add(new UserDto(1131,"고길","go@mail.com"));
		

		request.setAttribute("list", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/mvc/userList.jsp");
		dispatcher.forward(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String username=request.getParameter("username");
		System.out.println(username);
		String password=request.getParameter("password");
		String[] hobby=request.getParameterValues("hobby");
		
		StringBuilder sb=new StringBuilder();
		sb.append("username : "+username).append(" password : "+password);
		for(String str: hobby) {
			System.out.println(str);
			sb.append(" hobby : "+str);
		}
		UserDto userdto=new UserDto(111,username,"hong@gon.com");
		request.setAttribute("username", username);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/mvc/userinsertResult.jsp");
		dispatcher.forward(request, response);
	}
}
