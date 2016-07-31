package zhangjuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class get_id_num_servlet extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse  response)
		   throws ServletException ,IOException {
	     HttpSession session=request.getSession();
		 Integer pnum= (Integer)session.getAttribute("pnum");
		 HttpSession session1=request.getSession();
		 Integer pid= (Integer)session.getAttribute("pc_id");
			//System.out.println(pnum+","+pid);
	 new update_pro_num_service().u_p_n(request,response,pid,pnum);
   }
}
