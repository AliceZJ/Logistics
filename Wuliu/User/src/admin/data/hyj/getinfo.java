package admin.data.hyj;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getinfo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		String opt = arg0.getParameter("opt");
		System.out.println("获取目标数据："+opt);
		if("cangku".equals(opt))
			this.getcangkuinfo(arg0,arg1);
		else if("quyu".equals(opt))
			this.getquyuinfo(arg0,arg1);
	}

	private void getquyuinfo(HttpServletRequest arg0, HttpServletResponse arg1) {
		//获取区域表中的区域编号、区域名称
		
		//实现服务端跳转
		RequestDispatcher rd = arg0.getRequestDispatcher("addcangwei.jsp");
		try {
			rd.forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getcangkuinfo(HttpServletRequest arg0, HttpServletResponse arg1) {
		//获取仓库表中的仓库编号、仓库名称
		
		//实现服务端跳转
		RequestDispatcher rd = arg0.getRequestDispatcher("addquyu.jsp");
		try {
			rd.forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
