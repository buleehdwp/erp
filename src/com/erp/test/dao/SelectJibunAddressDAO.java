package com.erp.test.dao;

import java.util.List;

public interface SelectJibunAddressDAO {
	
	List<String> SidoSelectList(String sido);
	List<String> SigunguSelectList(String sido);
	List<String> dongNameSelectList(String sido, String sigungu);
	

}
