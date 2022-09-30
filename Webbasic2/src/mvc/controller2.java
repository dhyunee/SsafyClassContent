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

//���: /mvc2?job=list
//���: /mvc2?job=insert
//����: /mvc2?job=update
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
		//encodingó��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//jsp�� forward �� ��쿡�� �ʿ� ����
		
		//���� ���� ó��
		String job=request.getParameter("job");
		System.out.println(job);
		
		switch(job) {
		case"list":list(request,response);break;
		case"insert":insert(request,response);break;
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//service-dao-db ���ļ� ����� �޾ƿԴ� ����
		ArrayList<UserDto>list=new ArrayList<>();
		list.add(new UserDto(1111,"ȫ�浿","hong@mail.com"));
		list.add(new UserDto(1211,"�̱浿","lee@mail.com"));
		list.add(new UserDto(1131,"��浿","go@mail.com"));
		
		//jsp�� model(data)�� �����ϰ� forward
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
