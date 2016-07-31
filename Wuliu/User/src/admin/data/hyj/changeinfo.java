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

public class changeinfo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		String opt = arg0.getParameter("opt");
		System.out.println("修改信息："+opt);
		if("1".equals(opt))
			this.changewuliao(arg0,arg1);
		else if("2".equals(opt))
			this.changecangku(arg0,arg1);
		else if("3".equals(opt))
			this.changequyu(arg0,arg1);
		else if("4".equals(opt))
			this.changecangwei(arg0,arg1);
	}
	
	private void changecangwei(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("change仓位");
		try {
			arg1.sendRedirect("cangWeiZiLiaoSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void changequyu(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("change区域");
		try {
			arg1.sendRedirect("quYuZiLiaoSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void changecangku(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("change仓库");
		try {
			arg1.sendRedirect("cangKuGuanLiSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void changewuliao(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("change物料");
		try {
			int id = Integer.parseInt(arg0.getParameter("id"));
			String name = arg0.getParameter("name");
			String norms = arg0.getParameter("norms");
			double weight = Double.parseDouble(arg0.getParameter("weight"));
			String unit = arg0.getParameter("unit");
			double volume = Double.parseDouble(arg0.getParameter("volume"));
			int count = Integer.parseInt(arg0.getParameter("count"));
			String sql = "update wuliao set wuliao_id_gjh='"+id
					+"',wuliao_name_gjh='"+name+
					"',wuliao_norms_gjh='"+norms+
					"',wuliao_weight_gjh='"+weight+
					"',wuliao_unit_gjh='"+unit+
					"',wuliao_volume_gjh='"+volume+
					"',wuliao_count_gjh='"+count+"' where wuliao_id_gjh="+id;
			Connection conn = db.getConn();
			try {
				Statement stmt = conn.createStatement();
				int num = stmt.executeUpdate(sql);
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("出错啦");
			}
			arg1.sendRedirect("wuLiaoGuanLiSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
