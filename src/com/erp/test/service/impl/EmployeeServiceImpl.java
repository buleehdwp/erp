package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.EmployeeDAO;
import com.erp.test.dao.impl.EmployeeDAOImpl;
import com.erp.test.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO empDAO = new EmployeeDAOImpl();

	public Map<String, Object> insertEmployee(Map<String, Object> emp) {
		int result = empDAO.insertEmployee(emp);
		Map<String, Object> eMap = new HashMap<>();
		if (result == 1) {
			eMap.put("msg", "데이터 추가 성공");
		} else {
			eMap.put("msg", "데이터 추가 실패");
		}
		eMap.put("cnt", result);
		return eMap;
	}

	public Map<String, Object> deleteEmployee(Map<String, Object> emp) {
		int result = empDAO.deleteEmployee(emp);
		Map<String, Object> eMap = new HashMap<>();
		if (result == 1) {
			eMap.put("msg", "데이터 삭제 성공");
		} else {
			eMap.put("msg", "데이터 삭제 실패");
		}
		eMap.put("cnt", result);
		return eMap;
	}

	public Map<String, Object> updateEmployee(Map<String, Object> emp) {
		int result = empDAO.updateEmployee(emp);
		Map<String, Object> eMap = new HashMap<>();
		if (result == 1) {
			eMap.put("msg", "데이터 수정 성공");
		} else {
			eMap.put("msg", "데이터 수정 실패");
		}
		eMap.put("cnt", result);
		return eMap;
	}

	public Map<String, Object> selectEmployee(Map<String, Object> emp) {
		return empDAO.selectEmployee(emp);
	}

	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> emp) {
		return empDAO.selectEmployeeList(emp);
	}

}
