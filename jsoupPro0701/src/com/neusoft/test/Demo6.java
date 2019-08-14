package com.neusoft.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo6 {

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement pst=null;
		
	    String driver = "com.mysql.jdbc.Driver";
	    String url ="jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=UTF-8";
		String userName="root";
		String pwd="root";

		Class.forName(driver);		
		conn = DriverManager.getConnection(url,userName,pwd); 
		String sql="INSERT INTO etf_jin(id,TIME,jingChiCangLiang,meiYuan,zengJian,price,yingXiang,time2)"
				+ "VALUES(NULL,?,?,?,?,?,?,NOW())";
		pst=conn.prepareStatement(sql);
		for( int i=1;i<100;i++){
			pst.setObject(1, "2019-01-01");
			pst.setObject(2, 1000+i);
			pst.setObject(3, 5000+i);
			pst.setObject(4, 3.5);
			pst.setObject(5, 1412.5);
			pst.setObject(6,"利空金银");
			pst.addBatch();	
		}
		pst.executeBatch();

		pst.close();
		conn.close();
	}

}
