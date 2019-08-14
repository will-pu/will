package com.neuedu.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.dao.EmployeesDAO;
import com.neuedu.db.DBUtil;
import com.neuedu.po.Employee;

public class EmployeeService {
	
	private EmployeesDAO dao = new EmployeesDAO();
	
	public List<Employee> getEmpListByDeptno(int deptno){
		Connection conn = DBUtil.getConnection();
		List<Employee> list = null;
		
		try {
			list = dao.getEmpListByDeptno(conn, deptno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}
	
	public void deleteEmpById(String[] cs) {
		Connection conn = DBUtil.getConnection();
		int[] ids = new int[cs.length];
		for(int i = 0; i < ids.length; i++) {
			ids[i] = Integer.parseInt(cs[i]);
		}
		try {
			dao.deleteEmpByIds(conn, ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return;
	}

}
