package com.mycom.myadv.service;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myadv.dto.StudentDto;

@Mapper
public interface StudentService {
	public int studentInsert(StudentDto studentDto);
}
