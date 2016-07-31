package com.admin.gl_v;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserinfoServlet extends HttpServlet {

	
	List<User_v> l = new ArrayList<User_v>();
	UserDao UD = new UserDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		try {
			l = UD.getUsersList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//·ÖÒ³²Ù×÷
		Page1 p = new Page1();
		p.setTotalNum(l.size());
		p.setCurrentPageNum(Integer.parseInt(req.getParameter("currentPage").trim()));
		int start = (p.getCurrentPageNum() - 1) * p.getCount();
		int end = p.getCurrentPageNum() == p.getTotalPage() ? l.size() : start
				+ p.getCount();
		List<User_v> l1 = new ArrayList<User_v>();
		for (int i = start; i < end; i++) {
			User_v u = l.get(i);			
			l1.add(u);
		}
		req.setAttribute("p", p);
		req.setAttribute("total", p.getTotalPage());
		req.setAttribute("l1", l1);
		req.setAttribute("currentPage", p.getCurrentPageNum());
		req.getSession().setAttribute("sum", l.size());
        req.getRequestDispatcher("userGl.jsp").forward(req, res);
	
	}
	
}
