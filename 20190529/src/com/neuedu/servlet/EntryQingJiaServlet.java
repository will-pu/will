package com.neuedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.po.AskTypePO;
import com.neuedu.service.SystemService;

@WebServlet("/EntryQingJiaServlet")
public class EntryQingJiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//查询数据库，获得所有的请假类型
		SystemService ss = new SystemService();
		List<AskTypePO> list = ss.getAskTypeList();
		//将查询结果放入Request作用域
		request.setAttribute("alist", list);
		request.getRequestDispatcher("/qingjia.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
