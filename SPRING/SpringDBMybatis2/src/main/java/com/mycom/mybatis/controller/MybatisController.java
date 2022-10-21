package com.mycom.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MybatisService;

@Controller
public class MybatisController {
	
	@Autowired
	MybatisService service;
	
	// ViewController
	// 오류나면 HomeController 삭제
	@GetMapping(value="/")
	public String DBTest() {
		System.out.println("DBController / ");
		
		return "DBTest";
	}
	
	// json으로 response
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto dto = service.empDetail(employeeId);
		
		return dto;
	}

	// json으로 response
	@GetMapping(value="/empList")
	@ResponseBody
	public List<EmpDto> empList() {
		List<EmpDto> dtoList = service.empList();
		System.out.println(dtoList);
		return dtoList;
	}
	
	@PostMapping(value="/empInsert")
	@ResponseBody
	public int empInsert(EmpDto empDto) { // FrontEnd에서 json으로 데이터가 넘어오지 않는다.
		System.out.println(empDto);
		int ret = service.empInsert(empDto);
		
		return ret;
	}
	
	@GetMapping(value="/empDelete/{employeeId}")
	@ResponseBody
	public int empDelete(@PathVariable int employeeId) {
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		
		return ret;
	}
	
	@GetMapping(value="/empModify/{employeeId}")
	@ResponseBody
	public int empModify(EmpDto dto) {
		dto.setFirstName("김");
		dto.setLastName("정윤");
		dto.setEmail("indl1670@naver.com");
		
		System.out.println(dto);
		int ret = service.empModify(dto);
		
		return ret;
	}
	
	@GetMapping(value="/empListParameterMap")
	@ResponseBody
	public List<EmpDto> empListParameterMap(String firstName, String lastName) {
		Map<String, String> map = new HashMap<>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		List<EmpDto> list = service.empListParameterMap(map);
		return list;
	}
}
