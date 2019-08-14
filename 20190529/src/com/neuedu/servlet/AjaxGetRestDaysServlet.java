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
		
		//�õ�ajax�ύ������
		String t = request.getParameter("t");
		String a = request.getParameter("a");
		
		System.out.println(t);
		System.out.println(a);
		//�������ݲ�ѯ���ݿ��ý��
		SystemService ss = new SystemService();
		int r = ss.getRestDays(2, Integer.parseInt(t));

		//��Ӧ�ͻ��ˣ�ͨ��out������������
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
