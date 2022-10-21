package com.mycom.myadv.dao;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycom.myadv.dto.StudentDto;
@Mapper
public interface StudentDao {

	
	public int studentInsert(StudentDto studentDto);
}
