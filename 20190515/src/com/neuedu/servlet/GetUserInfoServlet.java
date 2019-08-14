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
		//1. �����ַ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//2. ��ȡ�ͻ��˵���Ϣ
		String path = request.getContextPath();
		String addr = request.getLocalAddr();
		String lname = request.getLocalName();
		int lport = request.getLocalPort();
		
		System.out.println("��������IP��ַ��"+addr);
		System.out.println("����������������"+lname);
		System.out.println("�������Ķ˿ڣ�"+lport);
		System.out.println("�������Ĺ�������"+path);
		
		String raddr = request.getRemoteAddr();
		String rhost = request.getRemoteHost();
		int rport = request.getRemotePort();
		String user = request.getRemoteUser();
		
		System.out.println("�ͻ��˵�IP��ַ��"+raddr);
		System.out.println("�ͻ��˵���������"+rhost);
		System.out.println("�ͻ��˵Ķ˿ںţ�"+rport);
		System.out.println("�ͻ��˵��û���"+user);	
		
	}
	

}
