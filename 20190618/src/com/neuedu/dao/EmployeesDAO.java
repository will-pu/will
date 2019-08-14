package com.neuedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.db.DBUtil;
import com.neuedu.po.Employee;

public class EmployeesDAO {
	
	public List<Employee> getEmpListByDeptno(Connection conn, int deptno) throws Exception{
		String sql = "select * from employees where bedty = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;	
		List<Employee> list = new ArrayList<Employee>();
 		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptno);
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
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtil.close(pst, rs);
		}

 		return list;	
	}
	
	public void deleteEmpByIds(Connection conn, int[] ids) throws Exception {
	
		Statement pst = null;
		try {
			pst = conn.createStatement();
			for(int i = 0; i < ids.length; i++) {
				
				pst.addBatch("delete from employees where empid = "+ids[i]);
			}
			pst.executeBatch();
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtil.close(pst);
		}
		return;
	}

}
