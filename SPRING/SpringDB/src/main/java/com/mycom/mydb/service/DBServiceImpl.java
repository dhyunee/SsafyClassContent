package com.mycom.mydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mydb.dao.DBDao;
import com.mycom.mydb.dto.EmpDto;

@Service
public class DBServiceImpl implements DBService{
	@Autowired
	DBDao dbDao;

	@Override
	public EmpDto empDetail(int employeeId) {
		
		return dbDao.empDetail(employeeId);
	}

	@Override
	public List<EmpDto> empList() {
		
		return dbDao.empList();
	}

	@Override
	public int empInsert(EmpDto empDto) {
		return dbDao.empInsert(empDto);
	}

	@Override
	public int empDelete(int employeeId) {
		
		return dbDao.empDelete(employeeId);
	}

	@Override
	public int empUpdate(int employeeId) {
		
		return dbDao.empUpdate(employeeId);
	}
}
