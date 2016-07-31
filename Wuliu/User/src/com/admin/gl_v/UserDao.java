package com.admin.gl_v;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.util.DB;

public class UserDao {

	public List<User_v> getUsersList() throws SQLException {
		Connection conn = DB.getConnection();
		List<User_v> l = new ArrayList<User_v>();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "select*from sys_user";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				User_v user = new User_v();
				user.setUid(rs.getInt("su_id"));
				user.setUname(rs.getString("su_name"));
				user.setUrole(rs.getInt("su_roleid"));
				user.setUroleid(rs.getInt("su_roleid"));
				user.setUstate(rs.getInt("state"));
				l.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(conn, stmt, rs);
		return l;
	}
	
	public boolean addUser_v(User_v u) throws Exception {
		Connection conn = DB.getConnection();
		Statement stmt = conn.createStatement();
		System.out.println(u.getUname()+u.getUrole()+u.getUid()+u.getUstate());
		String sql = "insert into sys_user" + "(su_id,su_name,su_roleid)"
				+ " values('" + u.getUid() + "','" + u.getUname()
				+ "','" + u.getUroleid() + "'" + ")";
		int num = stmt.executeUpdate(sql);
		if (num > 0) {
			System.out.println("success");
			return true;
		}
		DB.close(conn, stmt, null);
		return false;
	}
	public boolean updateUser_v(User_v u, int old_id) throws Exception {
		Connection conn = DB.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "update  sys_user set su_id='" + u.getUid()+"', su_name='"+u.getUname()+"',su_roleid='"+u.getUroleid()+"' where su_id ='"+old_id+"'";
		int num = stmt.executeUpdate(sql);
		if (num > 0) {
			System.out.println("success");
			return true;
		}
		DB.close(conn, stmt, null);
		return false;
	}
	
	public boolean delUser_v(int uid) throws Exception {
		Connection conn = DB.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "delete from sys_user where su_id = '"+ uid+"'" ;
		int num = stmt.executeUpdate(sql);
		if (num > 0) {
			System.out.println("success");
			return true;
		}
		DB.close(conn, stmt, null);
		return false;
	}

}
