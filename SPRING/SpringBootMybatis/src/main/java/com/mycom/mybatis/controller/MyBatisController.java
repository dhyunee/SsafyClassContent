package com.mycom.mybatis.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MyBatisService;


@RestController
public class MyBatisController {

	@Autowired
	MyBatisService service;


	@GetMapping(value = "/empDetail/{employeeId}")
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto dto = service.empDetail(employeeId);
		return dto; // @ResponseBody 가 없다면 자바 객체를 내려주게 되는 것.
	}


	@GetMapping(value = "/empList")
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}


	@PostMapping(value = "/empInsert")
	public int empInsert(EmpDto dto) {
		int ret = service.empInsert(dto);
		return ret;
	}


	@PostMapping(value = "/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto dto) {
		int ret = service.empUpdate(dto);
		return ret;
	}


	@GetMapping(value = "/empDelete/{employeeId}")
	@ResponseBody
	public int empUpdate(@PathVariable int employeeId) {
		int ret = service.empDelete(employeeId);
		return ret;
	}


	// parameter 처리
	@GetMapping(value = "/empListParameterMap")
	@ResponseBody
	public List<EmpDto> empListParameterMap(String firstName, String lastName) {
		Map<String, String> map = new HashMap<>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);

		List<EmpDto> list = service.empListParameterMap(map);
		return list;
	}


	// map 안 써도 된다.
	@GetMapping(value = "/empListParameterMap2")
	public List<EmpDto> empListParameterMap2(String firstName, String lastName) {
		List<EmpDto> list = service.empListParameterMap2(firstName, lastName);
		return list;
	}


	@GetMapping(value = "/empListParameterMap3")
	public List<EmpDto> empListParameterMap3(EmpDto dto) {
		List<EmpDto> list = service.empListParameterMap3(dto);
		return list;
	}


	@GetMapping(value = "/empListLike")
	public List<EmpDto> empListLike(String firstName) {
		List<EmpDto> list = service.empListLike(firstName);
		return list;
	}
}
