package com.admin.gl_v;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DB;

public class LoginServlet extends HttpServlet {

	String uname;
	String upsw;
	User_v user;
	Connection conn = DB.getConnection();
	boolean bool = false;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		//String opt ="";
		String opt = req.getParameter("opt");
		if(null!=opt){
			if(opt.equals("exit")){
				res.sendRedirect("index.jsp");
			}
		}
		
		uname = req.getParameter("uname");
		upsw = req.getParameter("upsw");
		String sql = "select su_id,su_roleid,su_name,su_pass  from sys_user where su_name='"
				+ uname + "'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getString("su_pass").equals(upsw)) {
					switch (rs.getInt("su_roleid")) {

					case 1000:
						res.sendRedirect("admin.jsp");
						break;
					case 1001:
						res.sendRedirect("caigou.jsp");
						break;
					case 1004:
						res.sendRedirect("cangguan.jsp");
						break;
					}
				} else
					res.sendRedirect("erro.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
