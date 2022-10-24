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
		//�񵿱��û�� ���� ó��
		//response: html X
		//response: data only: xml,json....=>json
		
		//request: client �� ��û
		//response: client ���� ����
		
		//Ŭ���̾�Ʈ�� ���� �����͸� Ȯ��
		String userId=request.getParameter("userId");
		String msg=request.getParameter("msg");
		System.out.println("userId: "+userId+" /msg: "+msg);
		
		//Ŭ���̾�Ʈ���� ������ ������ �غ�, ����
		ArrayList<UserDto>userList=new ArrayList<>();
		userList.add(new UserDto(1111,"ȫ�浿","hong@mail.com"));
		userList.add(new UserDto(1211,"�̱浿","lee@mail.com"));
		userList.add(new UserDto(1131,"��浿","go@mail.com"));
		
		//java object=>json
		//gson libraray jar�� tomcat/lib�� �߰�
		Gson gson=new Gson();
		String jsonStr=gson.toJson(userList);//jsonStr:userList�� ǥ���� json ���ڿ�
		
		response.addHeader("Access-Control-Allow-Origin", "*");//vscode live server CORS
		
		System.out.println(jsonStr);
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(jsonStr);//Ŭ���̾�Ʈ���� ���ڿ� ����
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}