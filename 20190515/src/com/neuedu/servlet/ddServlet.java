package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dd")
public class ddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String peo = request.getParameter("peo");
		String add = request.getParameter("add");
		String tel = request.getParameter("tel");
		request.setAttribute("hrhr", peo);
		request.setAttribute("hrhr", add);
		request.setAttribute("hrhr", tel);
		request.getRequestDispatcher("/ee").forward(request, response);
		
	}

}
