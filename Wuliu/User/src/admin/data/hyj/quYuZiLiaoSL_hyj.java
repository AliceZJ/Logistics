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
import unit.db;

public class quYuZiLiaoSL_hyj extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("quYuZiLiao");
		Connection conn = db.getConn();
		String sql = "SELECT r.r_id_hyj id,r.r_name_hyj rname," +
				"d.d_name_hyj dname,r.r_area_hyj rarea " +
				"FROM regions_hyj r,depot_hyj d " +
				"WHERE r.r_did_hyj=d.d_id_hyj";
		List<regions> l = new ArrayList<regions>();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				regions r = new regions();
				r.setR_id_hyj(rs.getInt("id"));
				r.setR_name_hyj(rs.getString("rname"));
				depot d = new depot();
				d.setD_name_hyj(rs.getString("dname"));
				r.setDepot(d);
				r.setR_area_hyj(rs.getInt("rarea"));
				l.add(r);
			}
			req.setAttribute("l", l);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("quYuZiLiao_hyj.jsp");
		rd.forward(req, resp);
	}
}
