package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Dto.DongCodeDto;
import Dto.GugunCodeDto;
import Dto.MainDto;
import Dto.SidoCodeDto;
import Dto.UserDto;
import Service.MainService;
import Service.MainServiceImpl;

@WebServlet("/main/*")
public class MainServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String sidocode, guguncode = null, dongname = null;
	MainService service = (MainService) MainServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
	
		String contextPath = request.getContextPath();
		String path = request.getRequestURI().substring(contextPath.length());
		System.out.println(path);
		if (action == null) {
			switch (path) {
			
			case "/main/gugunlist":
				gugunlist(request, response);
				break;

			case "/main/donglist":
				donglist(request, response);
				break;

			case "/main/mainlist":
				mainlist(request, response);
				break;
			}
		} else {
			switch (action) {

			case "gugunlist":
				gugunlist(request, response);
				break;

			case "donglist":
				donglist(request, response);
				break;

			case "mainlist":
				mainlist(request, response);
				break;
			}
		}
	}

	private void gugunlist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<GugunCodeDto> gugunList;
		sidocode = request.getParameter("sidoselect");
		System.out.println(sidocode);
		try {
			gugunList = service.getGugun(sidocode);
			 Gson gson = new Gson();
			 String jsonStr = gson.toJson(gugunList);
	         System.out.println(jsonStr);
	         response.getWriter().write(jsonStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void donglist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<DongCodeDto> dongList;
		guguncode = request.getParameter("gugunselect");
		System.out.println(guguncode);
		try {
			dongList = service.getDong(guguncode);
			 Gson gson = new Gson();
			 String jsonStr = gson.toJson(dongList);
	         System.out.println(jsonStr);
	         response.getWriter().write(jsonStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void mainlist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dongname = request.getParameter("dongselect");
		guguncode = request.getParameter("gugunselect");
		System.out.println(dongname);
		System.out.println(guguncode);

		try {
			List<MainDto> mainList = service.mainList(dongname, guguncode);
			 Gson gson = new Gson();
			 String jsonStr = gson.toJson(mainList);
	         System.out.println(jsonStr);
	         response.getWriter().write(jsonStr);

		} catch (Exception e) {
			e.printStackTrace();
		}

//		try {
//			
//			
//			list = service.list();
//			// 5. 모델 결과받아서 응답위한 설정
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/product/list.jsp").forward(request, response);
//			// 6. 응답이동
//
//		} catch (SQLException e) {
//			response.sendRedirect(root + "/error/error.jsp");		
//		}
	}

}
