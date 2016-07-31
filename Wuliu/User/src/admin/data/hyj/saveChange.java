package admin.data.hyj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit.db;

public class saveChange extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int hyid = Integer.parseInt(req.getParameter("hangye"));
		String time = req.getParameter("time");
		String legal = req.getParameter("legal");
		Connection conn = db.getConn();
		String sql = "update company_hyj set c_name_hyj='"+name
				+"',c_hyid_hyj="+hyid+
				",c_time_hyj='"+time+
				"',c_legal_hyj='"+legal+
				"' where c_id_hyj="+id;
		try {
			Statement stmt = conn.createStatement();
			int num = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("您的数据存在问题。");
		}
		resp.sendRedirect("../gongSiZiLiaoSL_hyj");
	}

	
}
