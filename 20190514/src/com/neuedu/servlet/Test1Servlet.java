package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求的字符集为utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		//接收客户端提交的用户名和密码
		String v1 = request.getParameter("lname");
		String v2 = request.getParameter("lpass");
		String v3 = request.getParameter("birthday");
		String v4 = request.getParameter("sex"); //单选按钮得到选中项的value
		String v6 = request.getParameter("s1"); //下拉列表得到选中项的value
		
		String[] v5 = request.getParameterValues("c1");//多选按钮得到选中项的value(可能有多个选中项)
		String[] v7 = request.getParameterValues("movie"); //多个同名的控件
		
		
		System.out.println("服务器接收到的用户名是："+v1);
		System.out.println("服务器接收到的密码是："+v2);
		System.out.println("服务器接收到的生日是："+v3);
		System.out.println("服务器接收到的性别数字是："+v4);
		System.out.println("服务器接收到的地区数字是："+v6);
		if(v5 != null) {
			System.out.print("服务器接收到的爱好数字是：");
			for(String t : v5) {
				System.out.print(t+"\t");
			}
			System.out.println();
		}
		System.out.print("服务器接收到的电影是：");
		
		for(String t : v7) {
			System.out.print(t+"\t");
		}
		System.out.println();
		System.out.println("v7的长度是："+v7.length);
		
	}

}
