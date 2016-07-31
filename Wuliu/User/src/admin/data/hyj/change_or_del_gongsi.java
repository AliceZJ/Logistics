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
import pojo.hangye;

import unit.db;

public class change_or_del_gongsi extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		String opt = arg0.getParameter("opt");
		if("del".equals(opt))
			this.del(arg0,arg1);
		else
			this.change(arg0,arg1);
		
	}

	private void change(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		Connection conn=db.getConn();
		String sql = "SELECT c.c_id_hyj id,c.c_name_hyj cname," +
				"h.hangye_name_gjh hname, h.hangye_id_gjh hid,c.c_time_hyj ctime," +
				"c_legal_hyj legal " +
				"FROM company_hyj c,hangye h " +
				"WHERE c.c_hyid_hyj=h.hangye_id_gjh" +
				" and c.c_id_hyj="+id;
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			company c = new company();
			while(rs.next()){
				c.setC_id_hyj(rs.getInt("id"));
				c.setC_name_hyj(rs.getString("cname"));
				hangye h = new hangye();
				h.setHangye_id_gjh(rs.getInt("hid"));
				h.setHangye_name_gjh(rs.getString("hname"));
				c.setHy(h);
				c.setC_time_hyj(rs.getDate("ctime"));
				c.setC_legal_hyj(rs.getString("legal"));
			}
			req.setAttribute("c", c);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql1 = "select * from hangye";
		List<hangye> l = new ArrayList<hangye>();
		try {
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql1);
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
		//服务端跳转
		RequestDispatcher rd = req.getRequestDispatcher("../gongSiZiLiao_change.jsp");
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

	private void del(HttpServletRequest arg0, HttpServletResponse arg1) {
		int id = Integer.parseInt(arg0.getParameter("id"));
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete from company_hyj where c_id_hyj = '"+id+"'";
			System.out.println(sql);
			int num = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("出错啦");
		}
		try {
			arg1.sendRedirect("../gongSiZiLiaoSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
