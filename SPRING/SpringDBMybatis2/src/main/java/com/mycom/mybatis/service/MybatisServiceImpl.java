package com.mycom.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mybatis.dao.MybatisDao;
import com.mycom.mybatis.dto.EmpDto;

@Service
public class MybatisServiceImpl implements MybatisService {

	@Autowired
	MybatisDao dao;

	@Override
	public EmpDto empDetail(int employeeId) {
		return dao.empDetail(employeeId);
	}

	@Override
	public List<EmpDto> empList() {
		return dao.empList();
	}

	@Override
	public int empInsert(EmpDto dto) {
		return dao.empInsert(dto);
	}

	@Override
	public int empDelete(int employeeId) {
		return dao.empDelete(employeeId);		
	}

	@Override
	public int empModify(EmpDto dto) {
		return dao.empModify(dto);
	}

	@Override
	public List<EmpDto> empListParameterMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.empListParameterMap(map);
	}
}
