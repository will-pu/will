package com.neuedu.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.dao.SystemDAO;
import com.neuedu.db.DBUtil;
import com.neuedu.po.AskTypePO;

public class SystemService {

	private SystemDAO dao = new SystemDAO();
	
	public List<AskTypePO> getAskTypeList(){
		Connection conn = DBUtil.getConnection();
		List<AskTypePO> list = null;	
		try {
			list = dao.getAskTypeList(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}	
		return list;	
	}
	
	public int getRestDays(int empid, int typeid){
		Connection conn = DBUtil.getConnection();
		int r = -1;
		try {
			r = dao.getRestDaysByEmpidAndTypeid(conn, empid, typeid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}	
		return r;	
	}
}
