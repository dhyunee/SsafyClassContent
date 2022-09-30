package sevlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.UserDto;


@WebServlet("/SimpleJsonListServlett2")
public class SimplePostTestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		System.out.println("userId: "+userId+" /msg: "+ userPwd);
		
		Gson gson=new Gson();
		JsonObject jsonobject=new JsonObject();
		
		//response:성공 실패
		if("ssafy".equals(userId)&&"1234".equals(userPwd)) {
			jsonobject.addProperty("result", "success");
		}else {
			jsonobject.addProperty("result", "fail");
		}
		String jsonStr=gson.toJson(jsonobject);
		
		response.addHeader("Access-Control-Allow-Origin", "*");//vscode live server CORS
		
		System.out.println(jsonStr);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(jsonStr);//클라이언트에게 문자열 전송
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}