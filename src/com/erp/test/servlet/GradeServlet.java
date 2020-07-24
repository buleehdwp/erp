package com.erp.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.GradeService;
import com.erp.test.service.impl.GradeServiceImpl;

public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService gradeService = new GradeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if ("/grade/grade_list".equals(uri)) {
			request.setAttribute("gradeList", gradeService.selectGradeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade_list");
			rd.forward(request, response);
		} else if ("/grade/grade_view".equals(uri)) {
			Map<String, Object> gMap = new HashMap<>();
			gMap.put("grd_no", request.getParameter("grd_no"));
			request.setAttribute("gradeView", gradeService.selectGrade(gMap));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade_view");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if ("/grade/grade_update".equals(uri)) {
			Map<String,Object> gMap = new HashMap<>();
			gMap.put("grd_no",request.getParameter("grd_no"));
			gMap.put("grd_name",request.getParameter("grd_name"));
			gMap.put("grd_desc",request.getParameter("grd_desc"));
			Map<String,Object> gMsg = gradeService.updateGrade(gMap);
			gMsg.put("url","/grade/grade_list");
			request.setAttribute("gMsg",gMsg);
		}else if("/grade/grade_delete".equals(uri)){
			Map<String,Object> gMap = new HashMap<>();
			gMap.put("grd_no",request.getParameter("grd_no"));
			Map<String,Object> gMsg = gradeService.deleteGrade(gMap);
			gMsg.put("url","/grade/grade_list");
			request.setAttribute("gMsg",gMsg);
		}else if("/grade/grade_insert".equals(uri)){
			Map<String,Object> gMap = new HashMap<>();
			gMap.put("grd_no",request.getParameter("grd_no"));
			gMap.put("grd_name", request.getParameter("grd_name"));
			gMap.put("grd_desc",request.getParameter("grd_desc"));
			Map<String,Object> gMsg = gradeService.insertGrade(gMap);
			gMsg.put("url","/grade/grade_list");
			request.setAttribute("gMsg",gMsg);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
		rd.forward(request, response);
	}

}
