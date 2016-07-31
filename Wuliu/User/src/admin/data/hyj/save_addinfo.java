package admin.data.hyj;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit.db;

public class save_addinfo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		String opt = arg0.getParameter("opt");
		System.out.println("保存增加:"+opt);
		Connection conn = db.getConn();
		String sql="";
		if("1".equals(opt)){
			int id = Integer.parseInt(arg0.getParameter("id"));
			String name = arg0.getParameter("name");
			String norms = arg0.getParameter("norms");
			double weight = Double.parseDouble(arg0.getParameter("weight"));
			String unit = arg0.getParameter("unit");
			double volume = Double.parseDouble(arg0.getParameter("volume"));
			int count = Integer.parseInt(arg0.getParameter("count"));
			sql = "insert into wuliao values('"+id+"','"+name+"','"+norms+"','"
			+weight+"','"+unit+"','"+volume+"','"+count+"') ";
			System.out.println(sql);
			try {
				Statement stmt = conn.createStatement();
				int num = stmt.executeUpdate(sql);
				stmt.close();
			} catch (SQLException e) {
				System.out.println("数据出错啦");
			}
			arg1.sendRedirect("wuLiaoGuanLiSL_hyj");
		}
		else if("2".equals(opt))
			arg1.sendRedirect("cangKuGuanLiSL_hyj");
		else if("3".equals(opt))
			arg1.sendRedirect("quYuZiLiaoSL_hyj");
		else if("4".equals(opt))
			arg1.sendRedirect("quYuZiLiaoSL_hyj");
	}
	

}
