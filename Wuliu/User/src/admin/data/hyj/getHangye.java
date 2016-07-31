package admin.data.hyj;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.hangye;
import unit.db;

public class getHangye extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection conn=db.getConn();
		String sql = "select * from hangye";
		List<hangye> l = new ArrayList<hangye>();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				hangye h = new hangye();
				h.setHangye_id_gjh(rs.getInt(1));
				h.setHangye_name_gjh(rs.getString(2));
				l.add(h);	
			}
			req.setAttribute("l", l);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("../gongSiZiLiao_add_hyj.jsp");
		rd.forward(req, resp);
	}
	
}
