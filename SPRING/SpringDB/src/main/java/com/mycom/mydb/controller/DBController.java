package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.DBService;

@Controller
public class DBController {
	@Autowired
	DBService service;

	@GetMapping(value = "/")
	public String DBTest() {
		System.out.println("DBController /");
		return "DBTest";
	}
	
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody//json으로 response
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto dto=service.empDetail(employeeId);
		return dto;
	}
	
	@GetMapping(value="/empList")
	@ResponseBody//json으로 response
	public List<EmpDto> empList() {
		List<EmpDto> list=service.empList();
		return list;
	}
	
	@PostMapping(value="/empInsert")
	@ResponseBody//json으로 response
	public int empInsert(EmpDto empDto) {
		System.out.println(empDto);
		int ret=service.empInsert(empDto);
		return ret;
	}
	
	@GetMapping(value="/empDelete/{employeeId}")
	@ResponseBody//json으로 response
	public int empDelete(@PathVariable int employeeId) {
		System.out.println(employeeId);
		int ret=service.empDelete(employeeId);
	
		return ret;
	}
	
	@GetMapping(value="/empUpdate/{employeeId}")
	@ResponseBody//json으로 response
	public int empUpdate(@PathVariable int employeeId) {
		System.out.println(employeeId);
		int ret=service.empUpdate(employeeId);
	
		return ret;
	}
}
