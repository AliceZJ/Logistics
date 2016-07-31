package com.cus_gjh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.customer;
import unit.Page1;

public class order_rece_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if ("manage".equals(opt)) {
			this.get_List(request, response);
		}
	}

	private void get_List(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		order_rece_dao ord = new order_rece_dao();
		List<Object[]> l = ord.getList();
        //System.out.println(l.size());
		int currentPage = Integer.parseInt(request
				.getParameter("currentPage"));
		Page1 p = new Page1();
		p.setCurrentPageNum(currentPage);
		//List<Object[]> nl = ord.getList();
		p.setTotalNum(l.size());
		int start = (p.getCurrentPageNum() - 1) * p.getCount();
		int end = p.getCurrentPageNum() == p.getTotalPage() ? l.size()
				: start + p.getCount();
		List<Object[]> l2 = new ArrayList<Object[]>();

		for (int i = start; i < end; i++) {
			Object[] c = l.get(i);
			l2.add(c);
		}
		request.setAttribute("p", p);
		request.setAttribute("l", l2);
		request.getRequestDispatcher("cus_gjh3.jsp").forward(request,
				response);

	}
}
