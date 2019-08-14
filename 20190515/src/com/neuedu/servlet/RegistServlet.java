package com.neuedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.db.DBUtil;
import com.neuedu.util.DateUtil;

public class RegistServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. �����ַ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2. ����HTML���ύ������
		String ename = request.getParameter("ename");
		String lname = request.getParameter("lname");
		String lpass1 = request.getParameter("lpass1");
		String lpass2 = request.getParameter("lpass2");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		
		//3. ��ʾ�ڿ���̨��
		System.out.println("����������Ա������"+ename);
		System.out.println("�����������˺ţ�"+lname);
		System.out.println("�������������룺"+lpass1);
		System.out.println("����������ȷ�����룺"+lpass2);
		System.out.println("�������������գ�"+birthday);
		System.out.println("�����������Ա�"+sex);
		System.out.println("���������ղ��ţ�"+dept);
		
		//4. ����׼��
		int s = Integer.parseInt(sex);
		int d = Integer.parseInt(dept);	
		Date b = DateUtil.String2SqlDate(birthday);
		
		//5.�����ݴ������ݿ�
		Connection conn = DBUtil.getConnection();
		String sql = "insert into employees(ename,lname,lpass,sex,birthday,deptno) values (?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ename);
			pst.setString(2, lname);
			pst.setString(3, lpass1);
			pst.setInt(4, s);
			pst.setDate(5, b);
			pst.setInt(6, d);
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pst);
		}
		
		//6.������Ӧ
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>��ϲ��ע��ɹ�</h3>");
		out.println("����ע����Ϣ���£�");
		out.println("�˺ţ�"+lname+"<br>");
		out.println("���룺"+lpass1+"<br>");
		out.println("���μ�����ע����Ϣ");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
}
