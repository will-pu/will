package com.neusoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource.PSpecified;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCutil {

	private static Connection conn=null;
	private PreparedStatement pst=null;
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
//	private String userName="scott";
//	private String pwd="tiger";
	
    String driver = "com.mysql.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
	private String userName="root";
	private String pwd="root";
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			System.out.println("���������ɹ�");
			if(conn==null){
				conn = DriverManager.getConnection(url,userName,pwd);  
			}
			System.out.println("����Connection���ӳɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("����Connection����ʧ��");
			e.printStackTrace();
		} 
		return conn;
	}
	
	public Connection getPollConnection() {
		try {
			Context context = new InitialContext();
			DataSource ds =
	 		(DataSource) context.lookup("java:/comp/env/jdbc/oracleds");
			conn = ds.getConnection();
			System.out.println("���ӳ�--- �������ݿ�ɹ���");
		} catch (NamingException e) {
			System.out.println("���ӳ�---�������ݿ�ʧ�ܣ�");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ӳ�--�������ݿ�ʧ��2��");
			e.printStackTrace();
		} 
		return conn;
	}

	
	public void beginTranaction(){
		try {
			conn.setAutoCommit(false);
			System.out.println("��ʼ����");
		} catch (SQLException e) {
			System.out.println("��ʼ��������쳣");
			e.printStackTrace();
		}
	}
	public void commit(){
		try {
			conn.commit();
			System.out.println("�����ύ�ɹ�");
		} catch (SQLException e) {
			System.out.println("�����ύ�쳣");
			e.printStackTrace();
		}
	}
	public void rollback(){
		try {
			conn.rollback();;
			System.out.println("����ع��ɹ�");
		} catch (SQLException e) {
			System.out.println("����ع��쳣");
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql) throws SQLException {
		int count=0;
		try {
			pst=conn.prepareStatement(sql);
			count=pst.executeUpdate();
			System.out.println("ִ�и��²����ɹ�,��"+count+"����¼����");
		} catch (SQLException e) {
			System.out.println("ִ�и��²���ʧ��");
			e.printStackTrace();
			throw new SQLException();
		}
		return count;
	}
	public int executeUpdate(String sql,Object[] obj)throws SQLException{
		int count=0;
		try {
			pst=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				pst.setObject(i+1, obj[i]);
			}
			count=pst.executeUpdate();
			System.out.println("ִ�и��²����ɹ�,��"+count+"����¼����");
		} catch (SQLException e) {
			System.out.println("ִ�и��²���ʧ��");
			e.printStackTrace();
			throw new SQLException();
		}
		return count;
	}
	public ResultSet executeQuery(String sql)throws SQLException{
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			System.out.println("ִ�в�ѯ�����ɹ�");
		} catch (SQLException e) {
			System.out.println("ִ�в�ѯ����ʧ��");
			e.printStackTrace();
			throw new SQLException();
		}
		return rs;
	}
	public ResultSet executeQuery(String sql,Object[] obj)throws SQLException{
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				pst.setObject(i+1, obj[i]);
			}
			rs=pst.executeQuery();
			System.out.println("ִ�в�ѯ�����ɹ�");
		} catch (SQLException e) {
			System.out.println("ִ�в�ѯ����ʧ��");
			e.printStackTrace();
			throw new SQLException();
		}
		return rs;
	}
	public void close(){
		try {
			if(pst!=null){
				pst.close();
				pst=null;
				System.out.println("�ر�PreparedStatement����");
			}
			if(conn!=null){
				conn.close();
				conn=null;
				System.out.println("�ر�Connection����");
			}
		} catch (SQLException e) {
			System.out.println("�ر�PreparedStatement,Connection�����쳣");
			e.printStackTrace();
		}
		
	}
	//Object[] obj
	public  void executeBatch(String sql,List<Object[]> list ) throws SQLException{
		try {
			pst=conn.prepareStatement(sql);
			
			for(Object[] obj:list){
				for(int i=0;i<obj.length;i++){
					pst.setObject(i+1, obj[i]);
				}
				pst.addBatch();
			}
			pst.executeBatch();
			System.out.println("ִ��������ɹ�");
		} catch (SQLException e) {
			System.out.println("ִ�и��²���ʧ��");
			e.printStackTrace();
			throw new SQLException();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="INSERT INTO test3.etf(id,TIME,jingChiChangLiang1, jingChiChangLiang2, zhongJia,addd,yingXiang)"
				+ "VALUES (NULL,?,?,?,?,?,?)";
		System.out.println(sql);
		List list=new ArrayList<>();
		Object obj1[]={"2018-11-18",2000,10,120000,5,"����ƽ�"};
		Object obj2[]={"2018-11-17",3000,20,220000,-5,"���ջƽ�"};
		Object obj3[]={"2018-11-16",4000,30,320000,-2,"���ջƽ�"};
		
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		db.executeBatch(sql, list);
		db.close();
		System.out.println("over");
	}
}