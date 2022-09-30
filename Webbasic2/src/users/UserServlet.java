package users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//registerform: 회원가입 페이지
		//register: 회원가입 요청
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//codedaoimpl coddao=codedaoimpl.getinstace();
		List<CodeDto>codelist=CodeDao.getCodeList("001");
		//group_code테이블에서 회원 구분에 대한 값 001
		request.setAttribute("codeList", codeList);
				//reqgisterform.jsp forward
	}

}
