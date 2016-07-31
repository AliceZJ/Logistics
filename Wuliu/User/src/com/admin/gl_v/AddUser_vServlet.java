package com.admin.gl_v;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser_vServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Boolean bool = false;
		UserDao UD = new UserDao();
		User_v u = new User_v();
		u.setUid(Integer.parseInt((String) req.getParameter("uid")));
		String uname = req.getParameter("uname");
		System.out.println(uname);
		u.setUname(uname);
		int uroleid = Integer.parseInt((String) req.getParameter("uroleid"));
		u.setUroleid(uroleid);
		u.setUrole(uroleid);
		try {
			bool = UD.addUser_v(u);
			if(bool) {
		        res.sendRedirect("addUser_v.jsp");
			}else
				res.sendRedirect("erro.jsp");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
