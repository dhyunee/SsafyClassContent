package com.mycom.mybatis.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.EmpDto;

public interface MybatisService {
	
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	int empInsert(EmpDto dto);
	int empDelete(int employeeId);
	int empModify(EmpDto dto);
	
	List<EmpDto> empListParameterMap(Map<String, String> map);
}
