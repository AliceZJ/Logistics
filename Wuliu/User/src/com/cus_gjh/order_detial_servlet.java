package com.cus_gjh;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.customer;
import pojo.order;
import pojo.wuliao;

public class order_detial_servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");			
		order_deal_dao odd = new order_deal_dao();
		List<order> l = odd.getOrderDetialList(id);		
		request.setAttribute("l", l);
		List<wuliao> l1 = odd.get_Wuliao();
		request.setAttribute("l1", l1);
		request.getRequestDispatcher("order_detial_gjh.jsp").forward(request, response);
	}
}
