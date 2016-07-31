package zhangjuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class p_r_servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//Integer de_id=Integer.parseInt(request.getParameter("p"));
	//request.setAttribute("de_id", de_id);
	request.getRequestDispatcher("add_pro_rej.jsp").forward(request, response);
	}

}
