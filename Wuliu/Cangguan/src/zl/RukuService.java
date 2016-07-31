package zl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.cangguan;
import pojo.gointo;
import pojo.wuliao;

public class RukuService {
	public void getgointoList(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<gointo>  l =  new gointoDao().getGointoList();
		request.setAttribute("l", l);
		}
	public void getgointobyid(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<gointo>  l  = new ArrayList<gointo>();
		if(null!=request.getParameter("rukuid")){
			int go_id=Integer.parseInt(request.getParameter("rukuid"));
			gointo go =  new gointoDao().getgointoById(go_id);
			l.add(go);
		}
		else if(null!=request.getParameter("go_id")){
			int go_id=Integer.parseInt(request.getParameter("go_id"));
			gointo go =  new gointoDao().getgointoById(go_id);
			l.add(go);
		}
		request.setAttribute("l", l);
		}
	public void addgointo(HttpServletRequest request, HttpServletResponse response){
		Integer go_id = Integer.parseInt(request.getParameter("go_id"));
		Integer cangguan_id = Integer.parseInt(request.getParameter("cangguan_id"));
		Date date = new Date();
		//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		//String go_date = sd.format(date);
		String go_state=request.getParameter("go_state");
		cangguan c= new cangguan();
		c.setCg_id_zl(cangguan_id);
		gointo go  = new gointo(go_id, c, date,go_state);
		boolean boo = new gointoDao().addgointo(go);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void editgointo(HttpServletRequest request, HttpServletResponse response){
		Integer go_id = Integer.parseInt(request.getParameter("go_id"));
		Integer cangguan_id = Integer.parseInt(request.getParameter("cangguan_id"));
		Date date = new Date();
		//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		//String go_date = sd.format(date);
		String go_state=request.getParameter("go_state");
		cangguan c= new cangguan();
		c.setCg_id_zl(cangguan_id);
		gointo go  = new gointo(go_id, c, date,go_state);
		boolean boo = new gointoDao().editgointo(go);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void deletegointo(HttpServletRequest request, HttpServletResponse response){
		Integer go_id = Integer.parseInt(request.getParameter("go_id"));
		boolean boo = new gointoDao().deletegointo(go_id);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void getgointoList_state(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<gointo>  l =  new gointoDao().getGointoList_state();
		request.setAttribute("l", l);
		}
	public void getgointo_state(HttpServletRequest request, HttpServletResponse response){
		Integer go_id = Integer.parseInt(request.getParameter("go_id"));
		boolean boo = new gointoDao().updategointo_state(go_id);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void getWuliaoList(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		Integer go_id = Integer.parseInt(request.getParameter("go_id"));
		List<wuliao>  l =  new gointoDao().getWuliaoList(go_id);
		request.setAttribute("l", l);
		}
	}

