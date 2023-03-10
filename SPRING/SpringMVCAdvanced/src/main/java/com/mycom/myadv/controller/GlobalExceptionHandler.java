package com.mycom.myadv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//#2 
//개별 controller에서 처리되지 않은 예외에 대한 처리
@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler
//	public ModelAndView errorHandler(HttpServletRequest req,Exception e) {
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("exception",e);
//		mav.addObject("url",req.getRequestURL());
//		mav.setViewName("globalError");//globalerror.jsp
//		
//		return mav;
//	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String,String>> errorHandler(HttpServletRequest req,Exception e) {
		Map<String,String >map=new HashMap<>();
		map.put("result","ajax exception");
		//e.printStackTrace();
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
