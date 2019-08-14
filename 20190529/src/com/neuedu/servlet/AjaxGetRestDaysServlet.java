package com.neuedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.SystemService;

@WebServlet("/AjaxGetRestDaysServlet")
public class AjaxGetRestDaysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//得到ajax提交的数据
		String t = request.getParameter("t");
		String a = request.getParameter("a");
		
		System.out.println(t);
		System.out.println(a);
		//根据数据查询数据库获得结果
		SystemService ss = new SystemService();
		int r = ss.getRestDays(2, Integer.parseInt(t));

		//响应客户端（通过out对象输出结果）
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println(r);
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
