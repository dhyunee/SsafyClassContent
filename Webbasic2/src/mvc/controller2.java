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

//목록: /mvc2?job=list
//등록: /mvc2?job=insert
//수정: /mvc2?job=update
@WebServlet("/mvc2")
public class controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//encoding처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//jsp로 forward 할 경우에는 필요 없음
		
		//업무 구분 처리
		String job=request.getParameter("job");
		System.out.println(job);
		
		switch(job) {
		case"list":list(request,response);break;
		case"insert":insert(request,response);break;
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//service-dao-db 거쳐서 결과를 받아왔다 가정
		ArrayList<UserDto>list=new ArrayList<>();
		list.add(new UserDto(1111,"홍길동","hong@mail.com"));
		list.add(new UserDto(1211,"이길동","lee@mail.com"));
		list.add(new UserDto(1131,"고길동","go@mail.com"));
		
		//jsp로 model(data)를 전달하고 forward
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
