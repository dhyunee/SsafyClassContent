package com.mycom.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface MybatisDao {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empDelete(int employeeId);
	int empModify(EmpDto dto);
	
	List<EmpDto> empListParameterMap(Map<String, String> map);
}
