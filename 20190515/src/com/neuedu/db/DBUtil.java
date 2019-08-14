package com.neuedu.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	private static String url;
	private static String username;
	private static String password;
	
	private DBUtil() {}
	
	static {
		// 1.加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//读取配置文件,并完成连接字符串
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getResourceAsStream("DBConfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ip = p.getProperty("IPAdress");
		String port = p.getProperty("port");
		String db = p.getProperty("database");
		String tz = p.getProperty("timezone");
		url = "jdbc:mysql://"+ip+":"+port+"/"+db+"?useUnicode=true&characterEncoding=utf-8&serverTimezone="+tz;
		username = p.getProperty("username");
		password = p.getProperty("password");
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static void close(Connection conn, Statement pst, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		if(pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	public static void close(Connection conn, Statement pst) {
		close(conn, pst, null);
	}
	
	public static void close(Connection conn) {
		close(conn, null, null);
	}
	

}
