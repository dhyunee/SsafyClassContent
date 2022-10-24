package sevlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.UserDto;


@WebServlet("/SimpleJsonListServlet")
public class SimpleJsonListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비동기요청에 대한 처리
		//response: html X
		//response: data only: xml,json....=>json
		
		//request: client 의 요청
		//response: client 에게 응답
		
		//클라이언트가 보낸 데이터를 확인
		String userId=request.getParameter("userId");
		String msg=request.getParameter("msg");
		System.out.println("userId: "+userId+" /msg: "+msg);
		
		//클라이언트에게 보내는 데이터 준비, 전송
		ArrayList<UserDto>userList=new ArrayList<>();
		userList.add(new UserDto(1111,"홍길동","hong@mail.com"));
		userList.add(new UserDto(1211,"이길동","lee@mail.com"));
		userList.add(new UserDto(1131,"고길동","go@mail.com"));
		
		//java object=>json
		//gson libraray jar를 tomcat/lib에 추가
		Gson gson=new Gson();
		String jsonStr=gson.toJson(userList);//jsonStr:userList를 표현한 json 문자열
		
		response.addHeader("Access-Control-Allow-Origin", "*");//vscode live server CORS
		
		System.out.println(jsonStr);
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(jsonStr);//클라이언트에게 문자열 전송
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}