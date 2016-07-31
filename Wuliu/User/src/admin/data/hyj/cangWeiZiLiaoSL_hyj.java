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

import pojo.regions;
import pojo.seat;

import unit.db;

public class cangWeiZiLiaoSL_hyj extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("cangWeiZiLiao");
		Connection conn=db.getConn();
		String sql = "SELECT s.s_id_hyj,s.s_name_hyj,r.r_name_hyj,s.s_area FROM seat_hyj s,regions_hyj r WHERE s.s_rid_hyj=r.r_id_hyj";
		List<seat> l = new ArrayList<seat>();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				seat s = new seat();
				s.setS_id_hyj(rs.getInt("s.s_id_hyj"));
				s.setS_name_hyj(rs.getString("s.s_name_hyj"));
				regions r = new regions();
				r.setR_name_hyj(rs.getString("r.r_name_hyj"));
				s.setRegions(r);
				s.setS_area(rs.getInt("s.s_area"));
				l.add(s);	
			}
			req.setAttribute("l", l);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("cangWeiZiLiao_hyj.jsp");
		rd.forward(req, resp);
	}
}
