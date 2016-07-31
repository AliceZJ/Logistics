package com.admin.gl_v;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Btn_optServlet extends HttpServlet {

	UserDao UD = new UserDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String opt = req.getParameter("opt");
		List<User_v> l = new ArrayList<User_v>();
		UserDao UD = new UserDao();
		List<User_v> l1 = new ArrayList<User_v>();
		try {
			l = UD.getUsersList();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//更新操作
		if (opt.equals("update_btn")) {
			User_v u = new User_v();
			int old_id = Integer.parseInt(req.getParameter("uid"));
			u.setUid(Integer.parseInt((String) req.getParameter("uid")));
			String uname = req.getParameter("uname");
			u.setUname(uname);
			int uroleid = Integer
					.parseInt((String) req.getParameter("uroleid"));
			u.setUroleid(uroleid);
			u.setUrole(uroleid);
			try {
				Boolean bool =UD.updateUser_v(u,old_id);
				if(bool) {
					res.sendRedirect("updateUser.jsp");
				}else
					res.sendRedirect("erro.jsp");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//查询操作
		else if (opt.equals("look_btn")) {
			String cname = req.getParameter("c_name");
			int cstate = Integer.parseInt((String) req.getParameter("c_state"));
			if(null!=cname){
				for(User_v u : l){
					if(u.getUname().equals(cname)){
						l1.add(u);
						//System.out.println(u.getUname());
						req.setAttribute("l1", l1);
						req.setAttribute("currentPage", 1);
						req.getRequestDispatcher("userGl.jsp").forward(req, res);
						return;
					}
				}
			}
			 if ( cstate == 10) {
				req.setAttribute("l1", l);
				req.setAttribute("currentPage", 1);
				req.getRequestDispatcher("userGl.jsp").forward(req, res);
				return;
			}
			 if (cstate == 1) {
				 System.out.println(cstate);
				for (User_v u : l) {
					if (u.getUstate() == 1) {
						l1.add(u);
					}
				}
			}
			 if ( cstate == 0) {
				 System.out.println(cstate);
				for (User_v u : l) {
					System.out.println(u.getUstate());
					if (u.getUstate() == 0) {
						l1.add(u);
					}
				}
			}
			req.setAttribute("currentPage", 1);
			req.setAttribute("l1", l1);
			req.getRequestDispatcher("userGl.jsp").forward(req, res);
			return;
		}
		//删除操作
		else if (opt.equals("del_btn")) {
			int uid = Integer.parseInt(req.getParameter("uid"));
			try {
				UD.delUser_v(uid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			res.sendRedirect("success.jsp");
			return;
		}
	}
}
