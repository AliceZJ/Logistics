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


public class depotservlet extends HttpServlet {

@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String opt= request.getParameter("d_iid");
	if(opt!=null){
		this.getdepot(request, response);
	}
	else
	  this.getdepotList(request, response);	
}
protected void getdepotList(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
List<depot> l=new Depotservice().getdepotList(request, response);
request.setAttribute("l", l);
//System.out.println(l.size());
request.getRequestDispatcher("cangkuzhanshi.jsp").forward(request, response);
//System.out.println("vvvvv"+request.getParameter("d_iid"));
}
protected void getdepot(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
depot d =new Depotservice().getdepot(request, response);
List<depot> l=new ArrayList<depot>();
l.add(d);
request.setAttribute("l", l);
//System.out.println(l.size());
request.getRequestDispatcher("cangkuzhanshi.jsp").forward(request, response);
//System.out.println("vvvvv"+request.getParameter("d_iid"));
}
}
