package zj;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.applays;
import pojo.purchase;

public class PurServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		System.out.println(opt);
		//applays
		if("xianshiapplays".equals(opt)){
			this.xianshiapplays(request, response);
		}else if("updateapplays".equals(opt)){
			this.updateapplays(request, response);
		}else if("addapplays".equals(opt)){
			this.addapplays(request, response);
		}else if("editapplays".equals(opt)){
				this.editapplays(request, response);
		}else if("getapplaysbyid".equals(opt)){
			this.getapplaysbyid(request, response);
		}else if("getapplays".equals(opt)){
			this.getapplays(request, response);
		}else if("deleteapplays".equals(opt)){
			this.deleteapplays(request, response);
		}else if("xianshipurchase".equals(opt)){
			this.xianshipurchase(request, response);
		}//purchase
		else if("updatepurchase".equals(opt)){
			this.updatepurchase(request, response);
		}
		else if("addpurchase".equals(opt)){
			this.addpurchase(request, response);
		}else if("editpurchase".equals(opt)){
				this.editpurchase(request, response);
		}else if("getpurchasebyid".equals(opt)){
			this.getpurchasebyid(request, response);
		}else if("getpurchase".equals(opt)){
			this.getpurchase(request, response);
		}else if("deletepurchase".equals(opt)){
			this.deletepurchase(request, response);
		}
		//订单发送
		else if("getpurchase_send".equals(opt)){
			this.getpurchase_send(request, response);
		}else if("updatepurchase_status".equals(opt)){
			this.updatepurchase_status(request, response);
		}
		//订单接收
		else if("getpurchase_receive".equals(opt)){
			this.getpurchase_receive(request, response);
		}else if("updatepurchase_status_receive".equals(opt)){
			this.updatepurchase_status_receive(request, response);
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}
	//采购申请
	private void getapplays(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<applays> l=new PurService().getapplaysList(request, response);
		request.setAttribute("l", l);
		request.getRequestDispatcher("show-zj1.jsp").forward(request, response);
	}
	private void getapplaysbyid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new PurService().getapplaysbyid(request, response);
		request.getRequestDispatcher("show-zj1.jsp").forward(request, response);
	}
	private void xianshiapplays(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new PurService().getapplaysList(request, response);
		request.setAttribute("opt", "addapplays");
		request.getRequestDispatcher("addapplays.jsp").forward(request, response);
	}
	private void addapplays(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new PurService().addapplays(request,response);
		response.sendRedirect("PurServlet?opt=getapplays");
	}
	private void editapplays(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			new PurService().editapplays(request,response);
			response.sendRedirect("PurServlet?opt=getapplays");
	}
	private void updateapplays(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new PurService().getapplaysbyid(request, response);
		 request.setAttribute("opt", "editapplays");
		 request.getRequestDispatcher("editapplays.jsp").forward(request, response);
	}
	private void deleteapplays(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new PurService().deleteapplays(request, response);
		 new PurService().getapplaysList(request, response);
		 request.getRequestDispatcher("show-zj1.jsp").forward(request, response);
	}
	//采购订单
	private void getpurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<purchase> l=new PurService().getpurchaseList(request, response);
		request.setAttribute("l", l);
		request.getRequestDispatcher("show-zj2.jsp").forward(request, response);
	}
	private void getpurchasebyid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new PurService().getpurchasebyid(request, response);
		request.getRequestDispatcher("show-zj2.jsp").forward(request, response);
	}
	private void xianshipurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new PurService().getpurchaseList(request, response);
		request.setAttribute("opt", "addpurchase");
		request.getRequestDispatcher("addpurchase.jsp").forward(request, response);
	}
	private void addpurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new PurService().addpurchase(request,response);
		response.sendRedirect("PurServlet?opt=getpurchase");
	}
	private void editpurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			new PurService().editpurchase(request,response);
			response.sendRedirect("PurServlet?opt=getpurchase");
	}
	private void updatepurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new PurService().getpurchasebyid(request, response);
		 request.setAttribute("opt", "editpurchase");
		 request.getRequestDispatcher("editpurchase.jsp").forward(request, response);
	}
	private void deletepurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new PurService().deletepurchase(request, response);
		 new PurService().getpurchaseList(request, response);
		 request.getRequestDispatcher("show-zj2.jsp").forward(request, response);
	}
	//订单发送
	private void getpurchase_send(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<purchase> l=new PurService().getpurchaseList(request, response);
		request.setAttribute("l", l);
		request.getRequestDispatcher("show-zj3.jsp").forward(request, response);
	}
	private void updatepurchase_status(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new PurService().getpurchasebyid(request, response);
		 request.setAttribute("opt", "editpurchase");
		 request.getRequestDispatcher("editpurchase.jsp").forward(request, response);
	}
	//订单接收
	private void getpurchase_receive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<purchase> l=new PurService().getpurchase_receiveList(request, response);
		request.setAttribute("l", l);
		request.getRequestDispatcher("show-zj4.jsp").forward(request, response);
	}
	private void updatepurchase_status_receive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		 new PurService().getpurchasebyid(request, response);
		 request.setAttribute("opt", "editpurchase");
		 request.getRequestDispatcher("editpurchase.jsp").forward(request, response);
	}
}
