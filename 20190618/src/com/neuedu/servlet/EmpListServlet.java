package com.neuedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.db.DBUtil;
import com.neuedu.po.Employee;
import com.neuedu.util.PageUtil;

@WebServlet("/emplist")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		// 获取用户提交的查询条件
		String ename = request.getParameter("ename");
		String b1 = request.getParameter("b1");
		String b2 = request.getParameter("b2");
		
		//接收请求页码
		String p = request.getParameter("pagenum");
		if(p == null || p.isEmpty()) {
			p = "1";
		}
		int pagenum = Integer.parseInt(p);
		
		// 查询数据
		Connection conn = DBUtil.getConnection();
		String sql = "select * from employees where 1=1";
		
		if(ename != null && !ename.isEmpty()) {
			sql += " and ename like '%"+ename+"%'";
		}
		
		if(b1 != null && !b1.isEmpty()) {
			sql += " and etime >= '"+b1+"'";
		}
		
		if(b2 != null && !b2.isEmpty()) {
			sql += " and etime <= '"+b2+"'";
		}
		sql += " limit "+PageUtil.getStartIndex(pagenum)+","+PageUtil.ITEMS_NUM;
		System.out.println(sql);
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Employee po = new Employee();
				po.setEmpid(rs.getInt("empid"));
				po.setEmpnum(rs.getInt("empnum"));				
				po.setEname(rs.getString("ename"));
				po.setSex(rs.getInt("sex"));
				po.setEtime(rs.getDate("etime"));
				po.setBedid(rs.getInt("bedid"));
				po.setBedty(rs.getString("bedty"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pst, rs);
		}
		
		//查询总数
		conn = DBUtil.getConnection();
		sql = "select count(*) from employees where 1=1";
		
		if(ename != null && !ename.isEmpty()) {
			sql += " and ename like '%"+ename+"%'";
		}
		
		if(b1 != null && !b1.isEmpty()) {
			sql += " and etime >= '"+b1+"'";
		}
		
		if(b2 != null && !b2.isEmpty()) {
			sql += " and etime <= '"+b2+"'";
		}
		System.out.println(sql);
		pst = null;
		rs = null;
		int total = 0;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pst, rs);
		}
		//根据总数total，计算最大页码
		int maxpage = PageUtil.getMaxPagenum(total);
		
		
		
		// 放入作用域
		request.setAttribute("elist", list);
		request.setAttribute("ename", ename);
		request.setAttribute("b1", b1);
		request.setAttribute("b2", b2);
		request.setAttribute("pagenum", pagenum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("total", total);
		// 跳转
		request.getRequestDispatcher("/elist.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
