package com.mycom.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.rest.dto.StudentDto;

@RestController // @Controller + @ResponseBody
public class StudentController {

	// 목록 => GET / students
	@GetMapping(value="/students")
	public List<StudentDto> list() {
		List<StudentDto>list=new ArrayList<StudentDto>();
		System.out.println("GET /students/");
		list.add(new StudentDto(111,"이길동","hong@gildong.com","010-1111-1212"));
		list.add(new StudentDto(131,"홍길동","h0@gildong.com","010-2111-1212"));
		list.add(new StudentDto(121,"박길동","hon@gildong.com","010-1113-1212"));
		list.add(new StudentDto(112,"홍길동","hon111@gildong.com","010-1111-1222"));
		return list;//json
	}

	// 상세 => Get / students / 123
	@GetMapping(value="/students/{studentId}")
	public StudentDto deatil(@PathVariable int studentId) {
		System.out.println("GET /students/"+studentId);
		return new  StudentDto(131,"홍길동","h0@gildong.com","010-2111-1212");
	}

	// 등록 => POST / students
	@PostMapping(value="/students")
	public int insert(StudentDto dto) {//x-www-form-urlencoded<=encoding
		System.out.println("Post /students/");
		System.out.println(dto);
		return 1;
	}

	// 수정 => PUT / students /123
	@PutMapping(value="/students/{studentId}")
	public int update(@PathVariable int studentId,@RequestBody StudentDto dto) {//x-www-form-urlencoded<=encoding
		System.out.println("PUT /students/"+studentId);
		System.out.println(dto);
		return 1;
	}

	// 삭제 => DELETE / students /123
	@DeleteMapping("/students/{studentId}")
	public int delete(@PathVariable int studentId) {
		System.out.println("Delete /students/"+studentId);
		
		return 1;
	}
}
