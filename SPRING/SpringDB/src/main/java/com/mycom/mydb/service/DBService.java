package com.mycom.mydb.service;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBService {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	int empInsert(EmpDto empDto);
	int empDelete(int employeeId);
	int empUpdate(int employeeId);
}
