package admin.data.hyj;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.company;
import pojo.hangye;
import pojo.wuliao;

import unit.db;
//获取要改变的行的历史数据
public class getchangeinfo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String opt = req.getParameter("opt");
		Connection conn = db.getConn();
		if("1".equals(opt)){
			int id = Integer.parseInt(req.getParameter("id"));
			String sql = "SELECT wuliao_id_gjh id,wuliao_name_gjh wname," +
					"wuliao_norms_gjh norms, wuliao_weight_gjh weight,wuliao_unit_gjh unit," +
					"wuliao_volume_gjh volume," +
					"wuliao_count_gjh wcount " +
					"FROM wuliao " +
					"WHERE wuliao_id_gjh="+id;
			try {
				Statement stat=conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				wuliao w = new wuliao();
				while(rs.next()){
					w.setWulaio_id_gjh(rs.getInt(1));
					w.setWulaio_name_gjh(rs.getString(2));
					w.setWulaio_norms_gjh(rs.getString(3));
					w.setWulaio_weight_gjh(rs.getDouble(4));
					w.setWulaio_unit_gjh(rs.getString(5));
					w.setWulaio_volume_gjh(rs.getDouble(6));
					w.setWulaio_count_gjh(rs.getInt(7));
					
				}
				req.setAttribute("w", w);
				rs.close();
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//服务端跳转
			RequestDispatcher rd = req.getRequestDispatcher("changewuliao.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("2".equals(opt)){
			resp.sendRedirect("add_cangku.jsp");}
		else if("3".equals(opt)){
			resp.sendRedirect("getinfo?opt=cangku");}
		else if("4".equals(opt)){
			resp.sendRedirect("getinfo?opt=quyu");}
	}
}
