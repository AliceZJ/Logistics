package com.admin.gl_v;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;
import com.util.DB;

import net.sf.json.JSONArray;

public class AppseverServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		int uid = Integer.parseInt(req.getParameter("uid"));
		System.out.println(uid);
		if (uid == -1) {
			try {
				selectAll(req,res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			try {
				selectOne(uid,req,res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	void selectOne(int uid, HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		Connection conn = DB.getConnection();
		res.setContentType("text/json");
		res.setCharacterEncoding("utf-8");
		Map map = new HashMap();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql = "select*from sys_user where su_id='" + uid + "'";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				map.put("uid", rs.getInt("su_id"));
				map.put("uname", rs.getString("su_name"));
				int rid = rs.getInt("su_roleid");
				String urole = "";
				if(rid==1000)
					urole="管理员";
				else if(rid==1001)
					urole="采购员";
				else if(rid==1004)
					urole="仓库管理员";
				else urole="未定义";
				map.put("urole", urole);	
			}//else
				
			DB.close(conn, stmt, rs);
			JSONArray ja = JSONArray.fromObject(map);
			System.out.println(ja.toString());
			PrintWriter out = res.getWriter();
			out.print(ja.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	void selectAll(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setContentType("text/json");
		res.setCharacterEncoding("utf-8");
		List<User_v> l = new ArrayList<User_v>();
		UserDao UD = new UserDao();
		try {
			l = UD.getUsersList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = JSONArray.fromObject(l);
		System.out.println(ja.toString());
		PrintWriter out = res.getWriter();
		out.print(ja.toString());
	}
}
