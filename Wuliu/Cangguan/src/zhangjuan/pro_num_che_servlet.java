package zhangjuan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.pro_num_che;
import pojo.wuliao;


public class pro_num_che_servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<pro_num_che> l=new pro_num_service().getpc(request,response);
		request.setAttribute("l", l);
	    //System.out.println(l.size());
		request.getRequestDispatcher("pro_num_show.jsp").forward(request, response);
	}
}
