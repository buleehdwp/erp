package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.GradeDAO;
import com.erp.test.dao.impl.GradeDAOImpl;
import com.erp.test.service.GradeService;

public class GradeServiceImpl implements GradeService {
	private GradeDAO gradeDAO = new GradeDAOImpl();

	public Map<String, Object> insertGrade(Map<String, Object> grade) {
		int result = gradeDAO.insertGrade(grade);
		Map<String, Object> gMap = new HashMap<>();
		gMap.put("msg","직급테이블 추가 완료");
		if(result != 1) {
			gMap.put("msg","직급테이블 추가 실패");
		}
		gMap.put("cnt",result);
		return gMap;
	}

	public Map<String, Object> deleteGrade(Map<String, Object> grade) {
		int result = gradeDAO.deleteGrade(grade);
		Map<String, Object> gMap = new HashMap<>();
		gMap.put("msg","직급테이블 삭제 완료");
		if(result != 1) {
			gMap.put("msg","직급테이블 삭제 실패");
		}
		gMap.put("cnt",result);
		return gMap;
	}

	public Map<String, Object> updateGrade(Map<String, Object> grade) {
		int result = gradeDAO.updateGrade(grade);
		Map<String, Object> gMap = new HashMap<>();
		gMap.put("msg","직급테이블 수정 완료");
		if(result != 1) {
			gMap.put("msg","직급테이블 수정 실패");
		}
		gMap.put("cnt",result);
		return gMap;
	}

	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		return gradeDAO.selectGrade(grade);
	}

	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		return gradeDAO.selectGradeList(grade);
	}
	public static void main(String[] args) {
		GradeService grade = new GradeServiceImpl();
		Map<String, Object> gMap = new HashMap<>();
//		gMap.put("grd_no",9);
//		gMap.put("grd_name", "테스트");
//		gMap.put("grd_desc", "직급 테스트");
//		System.out.println(grade.insertGrade(gMap));
//		gMap.put("grd_no",9);
//		System.out.println(grade.deleteGrade(gMap));
//		gMap.put("grd_name","서비스");
//		gMap.put("grd_desc","텟스트");
//		gMap.put("grd_no",8);
//		System.out.println(grade.updateGrade(gMap));
		gMap.put("grd_no",6);
		System.out.println(grade.selectGrade(gMap));
	}
}