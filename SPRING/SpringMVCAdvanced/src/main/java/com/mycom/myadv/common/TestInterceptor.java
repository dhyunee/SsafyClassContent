package com.mycom.myadv.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor{
	
	//DispatcherServlet 이후 다른 controller의 method를 실행하기 직전에 호출
	//뭔가 테스트를 진행하고 그 결과에 따라 return true 하면 controller로 진행
	//return false 하면 controller 로 진행하지 못 함=>empty 한 response를 client에게 보냄
	
	
	//테스트 하려는 항목 뭔지 =>이곳 코드 안에서 처리/판단
	//이걸 누구에게 적용할 것인가 => 설정을 통해서 servlet-context.xml에서 지정
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws IOException {
		
		System.out.println("TestInterceptor : preHandle !!!");
		//#1 무조건 통과
		//return true;
		
		//#2 login
		HttpSession session=request.getSession();
		String login=(String)session.getAttribute("login");
		//login상태
		if("success".equals(login))return true; 
		//logout상태
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write("login이 필요합니다");
		return false;
	}
	
}
