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


public class delinfo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		String opt = arg0.getParameter("opt");
		System.out.println("É¾³ýÐÅÏ¢£º"+opt);
		if("1".equals(opt))
			this.delwuliao(arg0,arg1);
		else if("2".equals(opt))
			this.delcangku(arg0,arg1);
		else if("3".equals(opt))
			this.delquyu(arg0,arg1);
		else if("4".equals(opt))
			this.delcangwei(arg0,arg1);
		
	}

	private void delcangwei(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("É¾³ý²ÖÎ»");
		try {
			arg1.sendRedirect("cangWeiZiLiaoSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delquyu(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("É¾³ýÇøÓò");
		try {
			arg1.sendRedirect("quYuZiLiaoSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delcangku(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("É¾³ý²Ö¿â");
		try {
			arg1.sendRedirect("cangKuGuanLiSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delwuliao(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		System.out.println("É¾³ýÎïÁÏ");
		String id = arg0.getParameter("id");
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete from wuliao where wuliao_id_gjh = '"+id+"'";
			System.out.println(sql);
			int num = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("³ö´íÀ²");
		}
		
		try {
			arg1.sendRedirect("wuLiaoGuanLiSL_hyj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
