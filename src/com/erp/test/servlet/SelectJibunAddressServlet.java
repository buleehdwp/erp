package com.erp.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.SelectJibunAddressService;
import com.erp.test.service.impl.SelectJibunAddressServiceImpl;

public class SelectJibunAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SelectJibunAddressService JB = new SelectJibunAddressServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sido = request.getParameter("sido");
		List<String> SJList = JB.SidoSelectList(null);
		request.setAttribute("SJList", SJList);
		if (sido != null) {
			List<String> GJList = JB.SigunguSelectList(sido);
			request.setAttribute("GJList", GJList);
			String sigungu = request.getParameter("sigungu");		
			if (sigungu != null) {
				List<String> DJList = JB.dongNameSelectList(sido, sigungu);
				request.setAttribute("DJList", DJList);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/test2");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
