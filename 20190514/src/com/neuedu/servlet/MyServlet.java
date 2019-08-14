package com.neuedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应的字符集
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		out.println("doGet方法被调用");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应的字符集
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		out.println("doPost方法被调用");
		out.flush();
		out.close();
	}
	
}
