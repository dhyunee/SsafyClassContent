package com.mycom.more.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.more.dao.StudentDao;
import com.mycom.more.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao dao;

	@Override
	public List<StudentDto> list() {

		return dao.list();
	}

	@Override
	public StudentDto detail(int studentId) {

		return dao.detail(studentId);
	}

	@Override
//	@Transactional//비싼 어노테이션=>반드시 필요한 경우에만 사용 :db성능과 서버 속도를 낮춤
	public int insert(StudentDto dto) {
//		dao.insert(dto);
//		String str=null;
//		str.length();
	
		return dao.insert(dto);
	}

	@Override
//	@Transactional
	public int update(StudentDto dto) {
//		String str=null;
//		str.length();
//		
//		dto.setEmail("test2");
		return dao.update(dto);
	}

	@Override
	public int delete(int studentId) {
		return dao.delete(studentId);
	}
}
