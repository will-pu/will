package com.neusoft.jdbc;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.neusoft.mybatis.SqlSessionUtil;

public class Demo {

	public static void main(String[] args) {
		
		JDBCutil db=new JDBCutil();
		Connection conn1=db.getConnection();
		db.close();
		Connection conn2=db.getConnection();
		Connection conn3=db.getConnection();
		System.out.println("conn1"+conn1);
		System.out.println("conn2"+conn2);
		System.out.println("conn3"+conn3);
		
//		SqlSession session1 = SqlSessionUtil.openSession();
//		
//		SqlSession session2 = SqlSessionUtil.openSession();
//		
//		System.out.println("session1="+session1);
//		System.out.println("session2="+session2);
	}

}
