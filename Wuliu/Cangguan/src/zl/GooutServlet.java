package zl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GooutServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		System.out.println(opt);
		 if("updateChuku".equals(opt)){
			this.updateChuku(request, response);
		}else if("addchuku".equals(opt)){
			this.addchuku(request, response);
		}else if("editChuku".equals(opt)){
				this.editChuku(request, response);
		}else if("getChukubyid".equals(opt)){
			this.getChukubyid(request, response);
		}else if("getChuku".equals(opt)){
			this.getChuku(request, response);
		}else if("deleteChuku".equals(opt)){
			this.deleteChuku(request, response);
		}else if("getChukustate".equals(opt)){
			this.getChukustate(request, response);
		}else if("updateChukustate".equals(opt)){
			this.updateChukustate(request, response);
		}else if("showWuliao".equals(opt)){
			this.showWuliao(request, response);
		}else if("getinfo".equals(opt)){
			this.getinfo(request, response);
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}
	private void getChuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new ChukuService().getgooutList(request, response);
		request.getRequestDispatcher("showGoout.jsp").forward(request, response);
	}
	private void getinfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new ChukuService().getcangguanList(request, response);
		new ChukuService().getorderList(request, response);
		new ChukuService().getcangweiList(request, response);
		request.setAttribute("opt", "addchuku");
		request.getRequestDispatcher("addgoout.jsp").forward(request, response);
	}
	private void getChukubyid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new ChukuService().getgooutbyid(request, response);
		request.getRequestDispatcher("showGoout.jsp").forward(request, response);
	}
	private void addchuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new  ChukuService().addgoout(request,response);
		response.sendRedirect("GooutServlet?opt=getChuku");
	}
	private void editChuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			new ChukuService().editgoout(request,response);
			response.sendRedirect("GooutServlet?opt=getChuku");
	}
	private void updateChuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new ChukuService().getgooutbyid(request, response);
		 new ChukuService().getcangguanList(request, response);
		 new ChukuService().getorderList(request, response);
		 new ChukuService().getcangweiList(request, response);
		 request.setAttribute("opt", "editChuku");
		 request.getRequestDispatcher("edithChuku.jsp").forward(request, response);
	}
	private void deleteChuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new ChukuService().deletegoout(request, response);
		 new ChukuService().getgooutList(request, response);
		 request.getRequestDispatcher("showGoout.jsp").forward(request, response);
	}
	private void getChukustate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new ChukuService().getgooutList_state(request, response);
		 request.getRequestDispatcher("goout_state.jsp").forward(request, response);
	}
	private void updateChukustate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new ChukuService().updategoout_state(request, response);
		this.getChukustate(request, response);
	}
	private void showWuliao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new ChukuService().getWuliaoList(request, response);
		request.getRequestDispatcher("showWuliao.jsp").forward(request, response);
	}
}
