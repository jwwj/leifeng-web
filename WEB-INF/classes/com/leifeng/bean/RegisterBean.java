package com.leifeng.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterBean {
	private Connection con;

	public RegisterBean() throws ClassNotFoundException, SQLException {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String userName = "sa";
		String userPasswd = "1234";
		String conurl = "jdbc:sqlserver://localhost:1433;DatabaseName=leifeng";
		Class.forName(JDriver);
		con = DriverManager.getConnection(conurl, userName, userPasswd);
		// 连接数据库
	}

	public PreparedStatement insert(String sql) throws SQLException {
		PreparedStatement s = con.prepareStatement(sql);
		return s;
	}
	
	public void addUser(int user_id, String user_name, String user_number,
			String user_school, String user_password) throws SQLException {
		String sql = "insert into userTable (user_id,user_name,user_number,user_school,user_password)values(?,?,?,?,?)";
	
		PreparedStatement s = insert(sql);
		
		s.setInt(1, user_id);
		s.setString(2, user_name);
		s.setString(3, user_number);
		s.setString(4, user_school);
		s.setString(5, user_password);
		s.execute();
		
	}

}
