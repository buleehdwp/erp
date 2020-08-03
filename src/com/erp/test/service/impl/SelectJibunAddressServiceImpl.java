package com.erp.test.service.impl;

import java.util.List;

import com.erp.test.dao.SelectJibunAddressDAO;
import com.erp.test.dao.impl.SelectJibunAddressDAOImpl;
import com.erp.test.service.SelectJibunAddressService;

public class SelectJibunAddressServiceImpl implements SelectJibunAddressService {
	SelectJibunAddressDAO JB = new SelectJibunAddressDAOImpl();

	public List<String> SidoSelectList(String sido) {
		return JB.SidoSelectList(sido);
	}

	public List<String> SigunguSelectList(String sido) {
		return JB.SigunguSelectList(sido);
	}

	public List<String> dongNameSelectList(String sido, String sigungu) {
		return JB.dongNameSelectList(sido, sigungu);
	}

}
