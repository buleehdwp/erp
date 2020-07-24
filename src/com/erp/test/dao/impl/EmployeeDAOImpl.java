package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Connector;
import com.erp.test.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {

	public int insertEmployee(Map<String, Object> emp) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "insert into employee(emp_no, emp_name, emp_credat, emp_salary, grd_no, emp_actvie)\r\n"
					+ "values(seq_emp_no.nextval, ?, sysdate, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.get("emp_name").toString());
			ps.setObject(2, emp.get("emp_salary"));
			ps.setObject(3, emp.get("grd_no"));
			ps.setObject(4, emp.get("emp_actvie"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int deleteEmployee(Map<String, Object> emp) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "delete from employee where emp_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, emp.get("emp_no"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int updateEmployee(Map<String, Object> emp) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "update employee set emp_name = ?, emp_salary = ?, grd_no=?, emp_actvie =? where emp_no =?";
			ps = conn.prepareStatement(sql);
			ps.setNString(1, emp.get("emp_name").toString());
			ps.setObject(2, emp.get("emp_salary"));
			ps.setObject(3, emp.get("grd_no"));
			ps.setObject(4, emp.get("emp_actvie"));
			ps.setObject(5, emp.get("emp_no"));
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Map<String, Object> selectEmployee(Map<String, Object> emp) {
		Map<String, Object> eMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.open();
			String sql = "select * from employee where emp_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1,emp.get("emp_no"));
			rs = ps.executeQuery();
			if (rs.next()) {
				eMap.put("emp_no", rs.getInt("emp_no"));
				eMap.put("emp_name", rs.getString("emp_name"));
				eMap.put("emp_credat", rs.getString("emp_credat"));
				eMap.put("emp_salary", rs.getInt("emp_salary"));
				eMap.put("grd_no", rs.getInt("grd_no"));
				eMap.put("emp_actvie", rs.getInt("emp_actvie"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eMap;
	}

	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> emp) {
		List<Map<String, Object>> empList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.open();
			String sql = "select * from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> eMap = new HashMap<>();
				eMap.put("emp_no", rs.getInt("emp_no"));
				eMap.put("emp_name", rs.getString("emp_name"));
				eMap.put("emp_credat", rs.getString("emp_credat"));
				eMap.put("emp_salary", rs.getInt("emp_salary"));
				eMap.put("grd_no", rs.getInt("grd_no"));
				eMap.put("emp_actvie", rs.getInt("emp_actvie"));
				empList.add(eMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empList;
	}

	public static void main(String[] args) {
		EmployeeDAO emp = new EmployeeDAOImpl();
		Map<String, Object> eMap = new HashMap<>();
//		System.out.println(emp.selectEmployeeList(eMap));
//		eMap.put("emp_name","흰옷얼룩제거");
//		eMap.put("emp_salary",200);
//		eMap.put("grd_no",1);
//		eMap.put("emp_actvie",0);
//		System.out.println(emp.insertEmployee(eMap));
//		eMap.put("emp_no", 203);
//		System.out.println(emp.deleteEmployee(eMap));
//		eMap.put("emp_no",201);
//		System.out.println(emp.updateEmployee(eMap));
		
		eMap.put("emp_no",204);
		System.out.println(emp.selectEmployee(eMap));
		
		
		
		

	}

}
