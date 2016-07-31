package admin.data.hyj;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import pojo.company;
import pojo.hangye;
import unit.db;

public class save_gongsiziliao extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int hyid = Integer.parseInt(req.getParameter("hangye"));
		String time = req.getParameter("time");
		String legal = req.getParameter("legal");
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into company_hyj values('"+id+"','"+name+"','"+hyid+"','"+time+"','"+legal+"') ";
			int num = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("您插入的数据存在问题。");
		}
		resp.sendRedirect("../gongSiZiLiaoSL_hyj");
	}
	
}
