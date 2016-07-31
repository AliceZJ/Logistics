package zhangjuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class add_pcn_servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	Integer pnum=Integer.parseInt(request.getParameter("pcn"));
	HttpSession session=request.getSession();
	session.setAttribute("pnum", pnum);
	 response.sendRedirect("get_id_num_servlet");
	}
}
