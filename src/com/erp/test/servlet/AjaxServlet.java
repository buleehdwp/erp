package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.SelectJibunAddressService;
import com.erp.test.service.impl.SelectJibunAddressServiceImpl;
import com.erp.test.util.JSON;

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SelectJibunAddressService saService = new SelectJibunAddressServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		List<String> sidoList = saService.SidoSelectList(null);
		pw.println(JSON.stringify(sidoList));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
