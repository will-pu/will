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
		//����������ַ���Ϊutf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		//���տͻ����ύ���û���������
		String v1 = request.getParameter("lname");
		String v2 = request.getParameter("lpass");
		String v3 = request.getParameter("birthday");
		String v4 = request.getParameter("sex"); //��ѡ��ť�õ�ѡ�����value
		String v6 = request.getParameter("s1"); //�����б�õ�ѡ�����value
		
		String[] v5 = request.getParameterValues("c1");//��ѡ��ť�õ�ѡ�����value(�����ж��ѡ����)
		String[] v7 = request.getParameterValues("movie"); //���ͬ���Ŀؼ�
		
		
		System.out.println("���������յ����û����ǣ�"+v1);
		System.out.println("���������յ��������ǣ�"+v2);
		System.out.println("���������յ��������ǣ�"+v3);
		System.out.println("���������յ����Ա������ǣ�"+v4);
		System.out.println("���������յ��ĵ��������ǣ�"+v6);
		if(v5 != null) {
			System.out.print("���������յ��İ��������ǣ�");
			for(String t : v5) {
				System.out.print(t+"\t");
			}
			System.out.println();
		}
		System.out.print("���������յ��ĵ�Ӱ�ǣ�");
		
		for(String t : v7) {
			System.out.print(t+"\t");
		}
		System.out.println();
		System.out.println("v7�ĳ����ǣ�"+v7.length);
		
	}

}
