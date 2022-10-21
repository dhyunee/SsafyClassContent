package com.mycom.myadv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myadv.dto.StudentDto;
import com.mycom.myadv.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping(value="/students")
	public ResponseEntity<Integer> studentInsert(@RequestBody StudentDto dto) {
		int ret = service.studentInsert(dto);
		return new ResponseEntity<Integer>(ret,HttpStatus.OK);
	}
	
}
