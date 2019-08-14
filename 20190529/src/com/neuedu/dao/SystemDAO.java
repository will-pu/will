package com.neuedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.db.DBUtil;
import com.neuedu.po.AskTypePO;

public class SystemDAO {
	
	public List<AskTypePO> getAskTypeList(Connection conn) throws Exception {
		String sql = "select atypeid, atype from asktype";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<AskTypePO> list = new ArrayList<AskTypePO>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				AskTypePO po = new AskTypePO();
				po.setAtypeid(rs.getInt("atypeid"));
				po.setAtype(rs.getString("atype"));
				list.add(po);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtil.close(pst, rs);
		}
		return list;
	}
	
	public int getRestDaysByEmpidAndTypeid(Connection conn, int empid, int typeid) throws Exception {
		String sql = "select rdays from restdays where empid = ? and atypeid = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		int r = -1;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			pst.setInt(2, typeid);
			rs = pst.executeQuery();
			while(rs.next()) {
				r = rs.getInt("rdays");
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtil.close(pst, rs);
		}
		return r;
	}

}
