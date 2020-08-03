package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.test.common.Connector;
import com.erp.test.dao.SelectAddressDAO;

public class SelectAddressDAOImpl implements SelectAddressDAO {

	public List<String> selectSidoList(String sido) {
		List<String> sidoList = new ArrayList<>();
		Connection conn = Connector.open();
		String sql = "select distinct sido from select_address";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sidoList.add(rs.getNString("sido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sidoList;
	}

	public List<String> selectGugunList(String sido) {
		List<String> gugunList = new ArrayList<>();
		Connection conn = Connector.open();
		String sql = "select distinct gugun from select_address ";
				sql += " where sido=? order by gugun"; 
 		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setNString(1, sido);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gugunList.add(rs.getNString("gugun"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gugunList;
	}

	public List<String> selectDongList(String sido, String gugun) {
		List<String> DongnList = new ArrayList<>();
		Connection conn = Connector.open();
		String sql = "select distinct dong_name from select_address";
				sql += " where sido=? and gugun =? order by dong_name"; 
 		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setNString(1, sido);
			ps.setString(2,gugun);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DongnList.add(rs.getNString("dong_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DongnList;
	}

	public static void main(String[] args) {
		SelectAddressDAO saDao = new SelectAddressDAOImpl();
		System.out.println(saDao.selectSidoList(null));
		System.out.println(saDao.selectGugunList("경기도"));
		System.out.println(saDao.selectDongList("경기도","남양주시"));
		
	}
}
