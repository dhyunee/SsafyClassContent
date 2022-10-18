package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {
	
	@GetMapping("/param1")//seq param
	public void m1(HttpServletRequest request) {
		String seq=request.getParameter("seq");
		System.out.println(seq);
	}
	
	@GetMapping("/param2")//seq param //seq 필수
	public void m2(String seq) {
		System.out.println(seq);
	}
	
	@GetMapping("/param3")//seq param
	public void m3(@RequestParam(name="seq",required=true)String seq) {		
		System.out.println(seq);
	}
	
	@GetMapping("/param4")
	public void m4(String name,Integer price) {//primitive type: price가 null로 처리가 안됨->int를 =>Integer		
		System.out.println(name+" "+price);
		
		CarDto dto=new CarDto();
		dto.setName(name);
		dto.setPrice(price);
		
		//service layer로 전달...
		
	}
	
	@GetMapping("/car1")
	public void m5(CarDto dto) {//parameter에  dto
		System.out.println(dto);

	}
	
	@GetMapping("/car2")
	public void m6(CarDto dto,HttpServletRequest request) {//parameter에  dto
		System.out.println(dto);
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("Name"));
		//Dto로 받아오면 대문자 소문자 구분 없이 spring이 알아서 가져오는데 
		//request로 받아오면 대문자 소문자 구분해서 맞는 것만 가져옴
		
	}
	
	@GetMapping("/map")
	public void m7(@RequestParam Map<String ,String>params) {
		System.out.println(params.get("name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("owner"));
		
	}
	
	@GetMapping("/header")//header(html)
	public void m8(@RequestHeader(value="Accept")String accept
			,@RequestHeader(value="Host")String host) {
		System.out.println(accept);
		System.out.println(host);
		
	}
	
	@GetMapping("/session")
	public void m8(HttpSession session,String msg) {
		System.out.println(msg);
		session.setAttribute("msg", msg);//다양한 용도로 session 객체를 활용

	}
	
}
