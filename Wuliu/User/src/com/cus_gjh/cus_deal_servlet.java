package com.cus_gjh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.customer;
import pojo.hangye;
import unit.Page1;

public class cus_deal_servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		
		if("realedit".equals(opt)){
			this.edit_Cus2(request, response);
		}
		if("edit".equals(opt)){
			this.edit_Cus1(request, response);
		}
		if("delete".equals(opt)){
			this.delete_Cus(request, response);
		}
		if ("cus_add".equals(opt)) {
			this.cus_add(request, response);
		}
		if ("getHangye".equals(opt)) {
			this.getHangye(request, response);
		}
		if ("manage".equals(opt)) {
			cus_deal_dao cd = new cus_deal_dao();
			List<customer> l = cd.getCusList();

			int currentPage = Integer.parseInt(request
					.getParameter("currentPage"));
			Page1 p = new Page1();
			p.setCurrentPageNum(currentPage);
			List<customer> nl = cd.getCusList();
			p.setTotalNum(nl.size());
			int start = (p.getCurrentPageNum() - 1) * p.getCount();
			int end = p.getCurrentPageNum() == p.getTotalPage() ? l.size()
					: start + p.getCount();
			List<customer> l1 = new ArrayList<customer>();

			for (int i = start; i < end; i++) {
				customer c = l.get(i);
				l1.add(c);
			}
			request.setAttribute("p", p);
			request.setAttribute("l", l1);
			request.getRequestDispatcher("cus_gjh.jsp").forward(request,
					response);
		}
	}

	protected void cus_add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("t1");
		String shortname = request.getParameter("t2");
		String hyid = request.getParameter("hangye");
		String tel = request.getParameter("t3");
		String cus = request.getParameter("t4");
		String email = request.getParameter("t5");
		String credit = request.getParameter("t6");
		String addr = request.getParameter("t7");
		
		cus_deal_dao cd = new cus_deal_dao();
		//int hyid = cd.get_hangyename(hyname);
		
		customer cst = new customer();
		Random r = new Random();
		int cusid = r.nextInt(100);
		cst.setCustomer_id(cusid);
		cst.setCustomer_name(name);
		cst.setCustomer_short(shortname);
		hangye hye = new hangye();
		hye.setHangye_id_gjh(Integer.parseInt(hyid));
		//hye.setHangye_name_gjh(hyname);
		cst.setHangye(hye);
		cst.setCustomer_phone(tel);
		cst.setCustomer(cus);
		cst.setCustomer_email(email);
		cst.setCustomer_credit(credit);
		cst.setCustomer_address(addr);
		
		boolean bool = cd.add_Cus(cst);
		if(bool){
			response.sendRedirect("add_success.jsp");
		}
	}

	protected void getHangye(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		cus_deal_dao cd = new cus_deal_dao();
		List<hangye> l = cd.getHangye();
		request.setAttribute("l", l);
		request.getRequestDispatcher("cus_add.jsp").forward(request, response);

	}
	protected void delete_Cus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获得点击行元素在数据库的主键值
		String num = request.getParameter("num");
		cus_deal_dao cd = new cus_deal_dao();
		boolean bool = cd.delete_Cus(Integer.parseInt(num));
		if(bool){
			response.sendRedirect("delete_success.jsp");
		}		
	}
	protected void edit_Cus1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num");
		int num = Integer.parseInt(num1);		
		cus_deal_dao cd = new cus_deal_dao();
		List<hangye> l = cd.getHangye();
		request.setAttribute("l", l);
		customer cst = cd.get_CusById(num);
		HttpSession session = request.getSession();
		session.setAttribute("num", num);
		request.setAttribute("cst", cst);
		request.getRequestDispatcher("cus_edit.jsp").forward(request, response);
	}
	protected void edit_Cus2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		cus_deal_dao cd = new cus_deal_dao();
		String name = request.getParameter("t1");
		String shortname = request.getParameter("t2");
		String hyid = request.getParameter("hangye");
		String tel = request.getParameter("t3");
		String cus = request.getParameter("t4");
		String email = request.getParameter("t5");
		String credit = request.getParameter("t6");
		String addr = request.getParameter("t7");
		
		customer cst = new customer();
		cst.setCustomer_name(name);
		cst.setCustomer_short(shortname);
		hangye hye = new hangye();
		hye.setHangye_id_gjh(Integer.parseInt(hyid));
		cst.setHangye(hye);
		cst.setCustomer_phone(tel);
		cst.setCustomer(cus);
		cst.setCustomer_email(email);
		cst.setCustomer_credit(credit);
		cst.setCustomer_address(addr);
		
		HttpSession session = request.getSession();
		int num = (Integer) session.getAttribute("num");
		System.out.println(num);
		boolean bool = cd.edit_Cus(num,cst);
		if(bool){
			response.sendRedirect("edit_success.jsp");
		}
	}
	
}
