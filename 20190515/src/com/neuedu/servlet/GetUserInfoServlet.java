package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 设置字符集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//2. 获取客户端的信息
		String path = request.getContextPath();
		String addr = request.getLocalAddr();
		String lname = request.getLocalName();
		int lport = request.getLocalPort();
		
		System.out.println("服务器的IP地址："+addr);
		System.out.println("服务器的主机名："+lname);
		System.out.println("服务器的端口："+lport);
		System.out.println("服务器的工程名："+path);
		
		String raddr = request.getRemoteAddr();
		String rhost = request.getRemoteHost();
		int rport = request.getRemotePort();
		String user = request.getRemoteUser();
		
		System.out.println("客户端的IP地址："+raddr);
		System.out.println("客户端的主机名："+rhost);
		System.out.println("客户端的端口号："+rport);
		System.out.println("客户端的用户："+user);	
		
	}
	

}
