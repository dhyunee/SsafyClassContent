package com.mycom.myadv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.myadv.dao.StudentDao;
import com.mycom.myadv.dto.StudentDto;
@Service
public class StudentSeviceImpl implements StudentService{

	@Autowired
	StudentDao dao;
	@Override
	@Transactional
	public int studentInsert(StudentDto studentDto) {
		dao.studentInsert(studentDto);
		String str=null;
		str.length();
		return dao.studentInsert(studentDto);
	}

}
