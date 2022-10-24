package board.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dto.UserDto;

@WebFilter("/*")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//http를 위한 type casting
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		
		//login 이 필요한 서버 요청과 필요없는 서버 요청 구분 처리
		//#1 login이 필요한 서버 요청에 대해 session에서 userDto를 포함하는지 처리
		// 만약 , 없다-> login 페이지로 분기
		// 있으면 정상적인 요청을 계속 이어가도록 처리
		//#2 모든 페이지가 다 login해야 접근 가능한 것은 아니다.
		//	로그인이 필요 없는 페이지는 제외하는 처리
		
		String contextPath=httpServletRequest.getContextPath();
		String path=httpServletRequest.getRequestURI().substring(contextPath.length());
		System.out.println(path);
		HttpSession session=httpServletRequest.getSession();
		//#2 exclude
		//<img src=../img/ssafy.jpg
		//회원가입 /register.jsp 로그인 /login.jsp ->/register.jsp로 사용도 가능
		 if(!path.contains("/img/")&&!path.contains("/css/")&&!path.contains("/js/")
				 &&!path.contains("/register")&&!path.contains("/login")) {
			 //로그인이 필요한 서버 요청
			 UserDto userDto=(UserDto)session.getAttribute("userDto");
			 if(userDto==null) {
				 httpServletResponse.sendRedirect(contextPath+"/jsp/login.jsp");
				 return;
			 }
		 }
		 chain.doFilter(request, response);//조건에 맞으면 계속해서 하던 거 하게 함
	}
}
