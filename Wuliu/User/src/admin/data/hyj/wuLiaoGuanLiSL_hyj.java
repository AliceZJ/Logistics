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
import pojo.regions;
import pojo.wuliao;
import unit.db;

public class wuLiaoGuanLiSL_hyj extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("wuLiaoGuanLi");
		Connection conn = db.getConn();
		String sql = "select * from wuliao";
		List<wuliao> l = new ArrayList<wuliao>();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				wuliao w = new wuliao();
				w.setWulaio_id_gjh(rs.getInt(1));
				w.setWulaio_name_gjh(rs.getString(2));
				w.setWulaio_norms_gjh(rs.getString(3));
				w.setWulaio_weight_gjh(rs.getDouble(4));
				w.setWulaio_unit_gjh(rs.getString(5));
				w.setWulaio_volume_gjh(rs.getDouble(6));
				w.setWulaio_count_gjh(rs.getInt(7));
				l.add(w);
			}
			req.setAttribute("l", l);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("wuLiaoGuanLi_hyj.jsp");
		rd.forward(req, resp);
	}
}
