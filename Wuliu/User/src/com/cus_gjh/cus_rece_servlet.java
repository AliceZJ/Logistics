package com.cus_gjh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.order;

public class cus_rece_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if("manage".equals(opt)){
			this.get_OrderofCus(request, response);
		}
	}
	
	protected void get_OrderofCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		order_deal_dao odd = new order_deal_dao();
		List<order> l = odd.getOrder_Handle();
		request.setAttribute("l", l);
		request.getRequestDispatcher("cus_gjh5.jsp").forward(request, response);
	}
}
