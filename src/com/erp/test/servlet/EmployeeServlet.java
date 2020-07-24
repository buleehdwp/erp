package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.EmployeeService;
import com.erp.test.service.impl.EmployeeServiceImpl;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService empService = new EmployeeServiceImpl();

	private static void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(str);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = "";
		String uri = request.getRequestURI();
		if ("/emp/emp_list".equals(uri)) {
			request.setAttribute("eList", empService.selectEmployeeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/emp/emp_list");
			rd.forward(request, response);
		} else if ("/emp/emp_view".equals(uri)) {
			Map<String, Object> emap = new HashMap<>();
			emap.put("emp_no", request.getParameter("emp_no"));
			Map<String, Object> eMap = empService.selectEmployee(emap);
			request.setAttribute("eMap", eMap);
			RequestDispatcher rd = request.getRequestDispatcher("/views/emp/emp_view");
			rd.forward(request, response);
		} else {
			str = "잘못된 경로";
		}
		doProcess(response, str);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if ("/emp/emp_insert".equals(uri)) {
			Map<String, Object> eMap = new HashMap<>();
			eMap.put("emp_name", request.getParameter("emp_name"));
			eMap.put("grd_no", request.getParameter("grd_no"));
			eMap.put("emp_salary", request.getParameter("emp_salary"));
			eMap.put("emp_actvie", request.getParameter("emp_actvie"));
			Map<String, Object> eMsg = empService.insertEmployee(eMap);
			eMsg.put("uri", "/emp/emp_list");
			request.setAttribute("eMsg", eMsg);
		}else if("/emp/emp_update".equals(uri)) {
			Map<String,Object> eMap = new HashMap<>();
			eMap.put("emp_name",request.getParameter("emp_name"));
			eMap.put("emp_salary",request.getParameter("emp_salary"));
			eMap.put("grd_no",request.getParameter("grd_no"));
			eMap.put("emp_actvie",request.getParameter("emp_actvie"));
			eMap.put("emp_no",request.getParameter("emp_no"));
			Map<String, Object> eMsg = empService.updateEmployee(eMap);
			eMsg.put("uri", "/emp/emp_list");
			request.setAttribute("eMsg", eMsg);
		}else if("/emp/emp_delete".equals(uri)) {
			Map<String,Object> eMap = new HashMap<>();
			eMap.put("emp_no",request.getParameter("emp_no"));
			Map<String, Object> eMsg = empService.deleteEmployee(eMap);
			eMsg.put("uri", "/emp/emp_list");
			request.setAttribute("eMsg", eMsg);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
		rd.forward(request, response);
	}

}
