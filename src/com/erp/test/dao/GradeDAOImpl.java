package com.erp.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Connector;

public class GradeDAOImpl implements GradeDAO {

	public int insertGrade(Map<String, Object> grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "insert into grade(grd_no, grd_name, grd_desc)\r\n" + "values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (int) grade.get("grd_no"));
			ps.setString(2, grade.get("grd_name").toString());
			ps.setString(3, grade.get("grd_desc").toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				Connector.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public int deleteGrade(Map<String, Object> grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "delete grade where grd_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (int) grade.get("grd_no"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				Connector.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public int updateGrade(Map<String, Object> grade) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "update grade set grd_name = ?,grd_desc = ? where grd_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, grade.get("grd_name").toString());
			ps.setNString(2, grade.get("grd_desc").toString());
			ps.setInt(3, (int) grade.get("grd_no"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				Connector.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		Map<String, Object> gMap = new HashMap<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.open();
			String sql = "select grd_no, grd_name, grd_desc from grade where grd_no = ?";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, (int) grade.get("grd_no"));
			rs = ps.executeQuery();
			while (rs.next()) {
				gMap.put("grd_no", rs.getInt("grd_no"));
				gMap.put("grd_name", rs.getString("grd_name"));
				gMap.put("grd_desc", rs.getString("grd_desc"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				Connector.close(ps, conn, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return gMap;
	}

	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		List<Map<String, Object>> gradeList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.open();
			String sql = "select * from grade";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> gradeMap = new HashMap<>();
				gradeMap.put("grd_no", rs.getInt("grd_no"));
				gradeMap.put("grd_name", rs.getString("grd_name"));
				gradeMap.put("grd_desc", rs.getString("grd_desc"));
				gradeList.add(gradeMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				Connector.close(ps, conn, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gradeList;
	}

	public static void main(String[] args) {
		GradeDAO grade = new GradeDAOImpl();
		Map<String, Object> gMap = new HashMap<>();
//		gMap.put("grd_no", 8);
//		gMap.put("grd_name", "뚱이");
//		gMap.put("grd_desc", "뚱이 승진");
//		System.out.println(grade.insertGrade(gMap));
//		gMap.put("grd_no",9);
//		System.out.println(grade.deleteGrade(gMap));
//		gMap.put("grd_name","업뎃");
//		gMap.put("grd_desc","테스트");
//		gMap.put("grd_no",8);
//		System.out.println(grade.updateGrade(gMap));
		gMap.put("grd_no", 8);
		System.out.println(grade.selectGrade(gMap));

	}
}
