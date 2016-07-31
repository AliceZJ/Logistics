package zl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GointoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		System.out.println(opt);
		if("xianshiruku".equals(opt)){
			this.xianshiruku(request, response);
		}else if("updateRuku".equals(opt)){
			this.updateRuku(request, response);
		}else if("addRuku".equals(opt)){
			this.addRuku(request, response);
		}else if("editRuku".equals(opt)){
				this.editRuku(request, response);
		}else if("getRukubyid".equals(opt)){
			this.getRukubyid(request, response);
		}else if("getRuku".equals(opt)){
			this.getRuku(request, response);
		}else if("deleteRuku".equals(opt)){
			this.deleteRuku(request, response);
		}else if("rukustate".equals(opt)){
			this.rukustate(request, response);
		}else if("updateRukustate".equals(opt)){
			this.updateRukustate(request, response);
		}else if("showWuliao".equals(opt)){
			this.showWuliao(request, response);
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}
	private void getRuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new RukuService().getgointoList(request, response);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}
	private void getRukubyid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new RukuService().getgointobyid(request, response);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}
	private void xianshiruku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new RukuService().getgointoList(request, response);
		request.setAttribute("opt", "addRuku");
		request.getRequestDispatcher("addgointo.jsp").forward(request, response);
	}
	private void addRuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new RukuService().addgointo(request,response);
		response.sendRedirect("GointoServlet?opt=getRuku");
	}
	private void editRuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			new RukuService().editgointo(request,response);
			response.sendRedirect("GointoServlet?opt=getRuku");
	}
	private void updateRuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new RukuService().getgointobyid(request, response);
		 request.setAttribute("opt", "editRuku");
		 request.getRequestDispatcher("editRuku.jsp").forward(request, response);
	}
	private void deleteRuku(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new RukuService().deletegointo(request, response);
		 new RukuService().getgointoList(request, response);
		 request.getRequestDispatcher("show.jsp").forward(request, response);
	}
	private void rukustate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new RukuService().getgointoList_state(request, response);
		 request.getRequestDispatcher("gointo_sate.jsp").forward(request, response);
	}
	private void updateRukustate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new RukuService().getgointo_state(request, response);
		this.rukustate(request, response);
	}
	private void showWuliao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new RukuService().getWuliaoList(request, response);
		request.getRequestDispatcher("showWuliao.jsp").forward(request, response);
	}
}
