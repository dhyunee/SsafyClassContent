package com.mycom.mydb.dao;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBDao {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	int empInsert(EmpDto empDto);
	int empDelete(int employeeId);
	int empUpdate(int employeeId);
}
