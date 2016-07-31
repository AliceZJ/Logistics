package zhangjuan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.seat_wuliao;
import pojo.wuliao;


public class pro_reject_servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<wuliao> l=new pro_service().Getpros(request,response);
		request.setAttribute("l", l);
	    //System.out.println(l.size());
		request.getRequestDispatcher("pro_reject_show.jsp").forward(request, response);
	}
}
