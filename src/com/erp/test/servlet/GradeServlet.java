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
			request.setAttribute("gradeView", gradeService.selectGrade(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade_view");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if("/grade/insert".contentEquals(uri)) {
			String gNo = request.getParameter("grd_no");
			String gName= request.getParameter("grd_name");
			String gDese = request.getParameter("grd_desc");
		}

	}

}
