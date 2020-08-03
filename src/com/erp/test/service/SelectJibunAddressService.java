package com.erp.test.service;

import java.util.List;

public interface SelectJibunAddressService {
	List<String> SidoSelectList(String sido);
	List<String> SigunguSelectList(String sido);
	List<String> dongNameSelectList(String sido, String sigungu);
	
}
