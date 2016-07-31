package zl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.cangguan;
import pojo.gointo;
import pojo.goout;
import pojo.order;
import pojo.seat;
import pojo.wuliao;

public class ChukuService {
	public void getgooutList(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<goout>  l =  new gooutDao().getGooutList();
		request.setAttribute("l", l);
		}
	public void getcangguanList(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<cangguan>  l =  new gooutDao().getcangguanList();
		request.setAttribute("cg_l", l);
		}
	public void getorderList(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<order>  l =  new gooutDao().getorderList();
		request.setAttribute("dd_l", l);
		}
	public void getcangweiList(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<seat>  l =  new gooutDao().getcangweiList();
		request.setAttribute("cw_l", l);
		}
	public void getgooutbyid(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<goout>  l  = new ArrayList<goout>();
		if(null!=request.getParameter("chukuid")){
			Integer gt_id=Integer.parseInt(request.getParameter("chukuid"));
			goout gt =  new gooutDao().getgooutById(gt_id);
			l.add(gt);
		}
		else if(null!=request.getParameter("goout_id")){
			int gt_id=Integer.parseInt(request.getParameter("goout_id"));
			goout gt =  new gooutDao().getgooutById(gt_id);
			l.add(gt);
			System.out.println(l.size());
		}
		request.setAttribute("l", l);
		}
	public void addgoout(HttpServletRequest request, HttpServletResponse response){
		Integer gt_id = Integer.parseInt(request.getParameter("gt_id"));
		Date date = new Date();
		Integer cg_id = Integer.parseInt(request.getParameter("cg_id"));
		Integer dd_id = Integer.parseInt(request.getParameter("dd_id"));
		Integer cw_id = Integer.parseInt(request.getParameter("cw_id"));
		String gt_state=request.getParameter("gt_state");
		cangguan c= new cangguan();
		c.setCg_id_zl(cg_id);
		order od = new order();
		od.setOrder_id(dd_id);
		seat s = new seat();
		s.setS_id_hyj(cw_id);
		goout gt  = new goout(gt_id, c,od,s,date,gt_state);
		boolean boo = new gooutDao().addgoout(gt);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void editgoout(HttpServletRequest request, HttpServletResponse response){
		Integer gt_id = Integer.parseInt(request.getParameter("gt_id"));
		Date date = new Date();
		Integer cg_id = Integer.parseInt(request.getParameter("cg_id"));
		Integer dd_id = Integer.parseInt(request.getParameter("dd_id"));
		Integer cw_id = Integer.parseInt(request.getParameter("cw_id"));
		String gt_state=request.getParameter("gt_state");
		cangguan c= new cangguan();
		c.setCg_id_zl(cg_id);
		order od = new order();
		od.setOrder_id(dd_id);
		seat s = new seat();
		s.setS_id_hyj(cw_id);
		goout gt  = new goout(gt_id, c,od,s,date,gt_state);
		boolean boo = new gooutDao().editgoout(gt);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void deletegoout(HttpServletRequest request, HttpServletResponse response){
		Integer gt_id = Integer.parseInt(request.getParameter("goout_id"));
		boolean boo = new gooutDao().deletegoout(gt_id);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void getgooutList_state(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<goout>  l =  new gooutDao().getGooutList_state();
		request.setAttribute("l", l);
		}
	public void updategoout_state(HttpServletRequest request, HttpServletResponse response){
		Integer gt_id = Integer.parseInt(request.getParameter("goout_id"));
		boolean boo = new gooutDao().updategoout_state(gt_id);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
		}
	public void getWuliaoList(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		Integer gt_id = Integer.parseInt(request.getParameter("goout_id"));
		List<wuliao>  l =  new gooutDao().getWuliaoList(gt_id);
		request.setAttribute("l", l);
		}
}
