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

import pojo.company;
import pojo.depot;
import pojo.hangye;
import pojo.regions;
import pojo.seat;


import unit.db;

public class gongSiZiLiaoSL_hyj extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Connection conn=db.getConn();
		String sql = "SELECT c.c_id_hyj id,c.c_name_hyj cname," +
				"h.hangye_name_gjh hname,c.c_time_hyj ctime," +
				"c_legal_hyj legal " +
				"FROM company_hyj c,hangye h " +
				"WHERE c.c_hyid_hyj=h.hangye_id_gjh";
		List<company> l = new ArrayList<company>();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				company c = new company();
				c.setC_id_hyj(rs.getInt("id"));
				c.setC_name_hyj(rs.getString("cname"));
				hangye h = new hangye();
				h.setHangye_name_gjh(rs.getString("hname"));
				c.setHy(h);
				c.setC_time_hyj(rs.getDate("ctime"));
				c.setC_legal_hyj(rs.getString("legal"));
				l.add(c);	
			}
			req.setAttribute("l", l);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("gongSiZiLiao_hyj.jsp");
		rd.forward(req, resp);
	}
	
	
	
}
