package com.mycom.myadv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myadv.dto.StudentDto;

@RestController //@RestController =@Controller +모든 메소드 위에 @ResponseBody
public class ResopnseEntityController {
	
//	@GetMapping("/students")
//	@ResponseBody
//	public List<StudentDto>list(){
//		List<StudentDto>list=new ArrayList<StudentDto>();
//		list.add(new StudentDto(111,"홍길동","hong@gildong.com","010-1111-1111"));
//		list.add(new StudentDto(112,"이길동","lee@gildong.com","010-1211-1111"));
//		list.add(new StudentDto(113,"김길동","kim@gildong.com","010-1131-1111"));
//		
//		return list;
//	}
	
	@GetMapping(value="/students")
	//@ResponseBody
	public ResponseEntity<List<StudentDto>>list(){
		List<StudentDto>list=new ArrayList<>();
		list.add(new StudentDto(111,"홍길동","hong@gildong.com","010-1111-1111"));
		list.add(new StudentDto(112,"이길동","lee@gildong.com","010-1211-1111"));
		list.add(new StudentDto(113,"김길동","kim@gildong.com","010-1131-1111"));
		
		//return ResponseEntity.ok().body(list);
		//목로을 처리하려고 했는데 결과가 없다.
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/students/{studentId}")
	//@ResponseBody
	public ResponseEntity<StudentDto>detail(@PathVariable int studentId){
		StudentDto dto=new StudentDto(111,"홍길동","hong@gildong.com","010-1111-1111");

		//return new ResponseEntity<StudentDto>(dto,HttpStatus.OK);
		//return new ResponseEntity<StudentDto>(dto,HttpStatus.NOT_FOUND);
		return new ResponseEntity<StudentDto>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//학생 =? students
	//url mapping 을                insertStudent이런 url 사용하지 않음
	//등록 /students+POST
	//수정  /students/{studentID}+PUT
	//삭제  /students/{studentId}+DELETE
	//목록조회 /students +GET
	//상세조회 /students/{studentId}+GET
	
	
}
