package com.util;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


public class DB {
	private static Connection conn = null;
	public DB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/juanjuan", "root", "mysql");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public Connection getConnection(){
		if(null == conn){
			new DB();
		} 
	    return conn;
	}
	public static void close(Connection conn,Statement stmt,ResultSet res) throws SQLException{
		if(null!=res)
			res.close();
        if(null!=stmt)
        	stmt.close();
	}
}
