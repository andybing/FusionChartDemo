package com.andy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * �������ݿ�����Ĺ�����
 * @author andy 
 * @version V1.0
 * */
public class DBUtil {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	public DBUtil(){
		conn = getConnection();
		if(conn != null){
			
		}
	}
	/*
	 * ��ȡConnection����
	 * @author andy
	 * @return Connection 
	 */
	public static Connection getConnection() {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/andydata";
			String userName = "andy";
			String password = "123456";
			con = DriverManager.getConnection(url,userName,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	/*
	 * ִ�в�ѯ����
	 * @author andy
	 * @param String sql�������ݿ��ѯ�����
	 * @return ResultSet
	 * */
	public static ResultSet getQuery(String sql){
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	/*
	 * �ر����ݿ�����
	 * @author andy
	 * @return boolean
	 */
	public boolean connClose(){
		boolean bol = true;
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bol;
	}
//	public static void main(String[] args) {
//		Connection c = getConnection();
//		System.out.println(c);
//	}
}
