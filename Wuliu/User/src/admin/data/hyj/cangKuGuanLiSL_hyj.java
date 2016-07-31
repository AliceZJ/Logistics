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

import pojo.depot;
import unit.db;

public class cangKuGuanLiSL_hyj extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("cangKuGuanLiSL_hyj");
		Connection conn=db.getConn();
		String sql = "select * from depot_hyj";
		List<depot> l = new ArrayList<depot>();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				depot d = new depot();
				d.setD_id_hyj(rs.getInt("d_id_hyj"));
				d.setD_name_hyj(rs.getString("d_name_hyj"));
				d.setD_area_hyj(rs.getInt("d_area_hyj"));
				d.setD_type_hyj(rs.getString("d_type_hyj"));
				d.setD_addr_hyj(rs.getString("d_addr_hyj"));
				l.add(d);	
			}
			req.setAttribute("l", l);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("cangKuGuanLi_hyj.jsp");
		rd.forward(req, resp);
	}
	
}
