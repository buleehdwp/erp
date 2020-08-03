package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.test.common.Connector;
import com.erp.test.dao.SelectJibunAddressDAO;

public class SelectJibunAddressDAOImpl implements SelectJibunAddressDAO {
	public List<String> SidoSelectList(String sido) {
		List<String> sidoList = new ArrayList<>();
		Connection conn = Connector.open();
		String sql = "select distinct sido from select_jibun_address order by sido";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sidoList.add(rs.getNString("sido"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sidoList;
	}

	public List<String> SigunguSelectList(String sido) {
		List<String> sigunguList = new ArrayList<>();
		Connection conn = Connector.open();
		String sql = "select distinct sigungu from select_jibun_address where sido = ? order by sigungu";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setNString(1, sido);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sigunguList.add(rs.getNString("sigungu"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sigunguList;
	}

	public List<String> dongNameSelectList(String sido, String sigungu) {
		List<String> dongList = new ArrayList<>();
		Connection conn = Connector.open();
		String sql = "select distinct dong_name from select_jibun_address where sido = ? and sigungu = ? order by sigungu";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setNString(1, sido);
			ps.setNString(2, sigungu);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dongList.add(rs.getNString("dong_name"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dongList;
	}
	

	public static void main(String[] args) {
		SelectJibunAddressDAO JT = new SelectJibunAddressDAOImpl();
		System.out.println(JT.SidoSelectList(null));
		System.out.println(JT.SigunguSelectList("경기도"));
		System.out.println(JT.dongNameSelectList("경기도","남양주시"));
		
		
	}
}
