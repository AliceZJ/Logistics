package zhangjuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class pc_servlet extends HttpServlet {
  @Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	Integer pc_id=Integer.parseInt(request.getParameter("op"));
	//System.out.println("ghhhhh"+pc_id);
	  HttpSession session=request.getSession();
	  session.setAttribute("pc_id",pc_id);
	//System.out.println("ghhhhh"+pnum);
	request.getRequestDispatcher("add_pcn_info.jsp").forward(request, response);
}
}
