package zhangjuan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.depot;
import pojo.seat_wuliao;


public class pro_check_servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt= request.getParameter("d_iid");
		if(opt!=null){
			this.getOne(request, response);
		}
		else
		  this.getAll(request, response);	
	}
	
	protected void getAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<seat_wuliao> l= new seat_pro_service().getseat_pros(request, response);
		request.setAttribute("l", l);
		//System.out.println(l.size());
		request.getRequestDispatcher("seat_pro_check.jsp").forward(request, response);
	}
	protected void getOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		seat_wuliao sw= new seat_pro_service().getSeat_pro(request, response);
	List<seat_wuliao> l=new ArrayList<seat_wuliao>();
	l.add(sw);
	request.setAttribute("l", l);
	//System.out.println(l.size());
	request.getRequestDispatcher("seat_pro_check.jsp").forward(request, response);
}
}
