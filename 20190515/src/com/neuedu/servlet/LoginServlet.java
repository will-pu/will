package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//接收用户提交的账号和密码
		String lname = request.getParameter("lname");
		String lpass = request.getParameter("lpass");
		
		//验证
		if(lname.equals("admin") && lpass.equals("123")) {
			//成功
			//将lname存入request作用域中，存储方式是以键值对的形式存储
			request.setAttribute("haha", lname);
			request.getRequestDispatcher("/main").forward(request, response);
			//response.sendRedirect("/20190515/main");
		}else {
			//失败
			response.sendRedirect("/20190515/03.login.html");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
