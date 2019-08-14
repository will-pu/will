package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.neusoft.bean.Etfjin;
import com.neusoft.bean.Etfyin;
import com.neusoft.dao.EtfDao;
import com.neusoft.jdbc.JDBCutil;

@Repository
public class EtfDaoBean implements EtfDao {

	@Override
	public void addBatch(List<Etfjin> list) throws SQLException {
		System.out.println("...EtfDaoBean....addBatch()......");
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="INSERT INTO etf_jin(id,TIME,jingChiCangLiang,meiYuan,zengJian,price,yingXiang,time2)"
				+ "VALUES(NULL,?,?,?,?,?,?,NOW())";
		System.out.println(sql);
		List<Object[]> list2=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			Etfjin e=list.get(i);
			Object obj[]=new Object[6];
			obj[0]=e.getTime();
			obj[1]=e.getJingChiCangLiang();
			obj[2]=e.getMeiYuan();
			obj[3]=e.getZengJian();
			obj[4]=e.getPrice();
			obj[5]=e.getYingXiang();
			list2.add(obj);
		}
		db.executeBatch(sql, list2);
	}
	
	@Override
	public void addBatch2(List<Etfyin> list) throws SQLException {
		System.out.println("...EtfDaoBean....addBatch()......");
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="INSERT INTO etf_jin(id,TIME,jingChiCangLiang,meiYuan,zengJian,price,yingXiang,time2)"
				+ "VALUES(NULL,?,?,?,?,?,?,NOW())";
		System.out.println(sql);
		List<Object[]> list2=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			Etfyin e=list.get(i);
			Object obj[]=new Object[6];
			obj[0]=e.getTime();
			obj[1]=e.getJingChiCangLiang();
			obj[2]=e.getMeiYuan();
			obj[3]=e.getZengJian();
			obj[4]=e.getPrice();
			obj[5]=e.getYingXiang();
			list2.add(obj);
		}
		db.executeBatch(sql, list2);
	}
}
