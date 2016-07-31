package com.cus_gjh;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.customer;
import pojo.order;
import unit.Page1;

public class order_deal_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if("manage".equals(opt)){
			this.get_Order(request, response);
		}
		if("addOrder".equals(opt)){
			this.add_Order(request, response);
		}
	}
	
	protected void get_Order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		order_deal_dao odd = new order_deal_dao();
		List<order> l = odd.getOrderList();

		int currentPage = Integer.parseInt(request
				.getParameter("currentPage"));
		Page1 p = new Page1();
		p.setCurrentPageNum(currentPage);
		List<order> nl = odd.getOrderList();
		p.setTotalNum(nl.size());
		int start = (p.getCurrentPageNum() - 1) * p.getCount();
		int end = p.getCurrentPageNum() == p.getTotalPage() ? l.size()
				: start + p.getCount();
		List<order> l1 = new ArrayList<order>();

		for (int i = start; i < end; i++) {
			order c = l.get(i);
			l1.add(c);
		}
		request.setAttribute("p", p);
		request.setAttribute("l", l1);
		request.getRequestDispatcher("order_gjh.jsp").forward(request,
				response);		
	}
	
	protected void add_Order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cus_name = request.getParameter("t1");
		String ord_type = request.getParameter("t2");
		String ord_baoguan = request.getParameter("t8");
		String pay_type = request.getParameter("t3");
		String ord_state = request.getParameter("t4");
		String ord_date = request.getParameter("t5");
		String tihuo_date = request.getParameter("t6");
		String linkman = request.getParameter("t7");
		
		order ord = new order();
		Random r = new Random();
		int ordid = r.nextInt(100);
		ord.setOrder_id(ordid);
		customer cus = new customer();
		cus.setCustomer_id(ordid);
		cus.setCustomer_name(cus_name);
		ord.setCustomer(cus);
		ord.setOrder_type(ord_type);
		ord.setOrder_baoguan(ord_baoguan);
		ord.setPay_type(pay_type);
		ord.setOrder_status(ord_state);
		ord.setOrder_date(ord_date);
		ord.setTihuo_date(tihuo_date);
		ord.setLuru_man(linkman);
		order_deal_dao odd = new order_deal_dao();
		boolean bool = odd.add_order(ord);	
		if(bool){
			response.sendRedirect("addorder_success_gjh.jsp");
		}
	}
}
