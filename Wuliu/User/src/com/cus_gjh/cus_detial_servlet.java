package com.cus_gjh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.customer;

public class cus_detial_servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");		
		cus_deal_dao cd = new cus_deal_dao();
		List<customer> l = cd.getCusDetialList(id);
		request.setAttribute("l", l);
		request.getRequestDispatcher("cus_detial_gjh.jsp").forward(request, response);
	}

}
