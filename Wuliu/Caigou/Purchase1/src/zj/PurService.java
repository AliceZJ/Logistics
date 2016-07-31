package zj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.applays;
import pojo.purchase;

public class PurService {
	//采购申请
	public List<applays> getapplaysList(HttpServletRequest request, HttpServletResponse response){
		int currentPageNum = Integer.parseInt(request.getParameter("currentPageNum"));
		PurPage p=new PurPage();
		p.setCurrentPageNum(currentPageNum);
		List<applays> l=new PurDao().getapplaysList();
		p.setTotalNum(l.size());
		int start = (p.getCurrentPageNum()-1)*p.getCount();
		int end = p.getCurrentPageNum() == p.getTotalPage()?l.size():start+p.getCount();
		List<applays> l1=new ArrayList<applays>();
		System.out.println(l.size());
		for(int i=start;i<end;i++){
			applays a=l.get(i);
			l1.add(a);
		}
		request.setAttribute("p", p);
		return l1;
		
	} 
	public void getapplaysbyid(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<applays>  l  = new ArrayList<applays>();
		if(null!=request.getParameter("selid")){
			String as_id=request.getParameter("selid");
			applays a =  new PurDao().getapplaysById(as_id);
			l.add(a);
		}
		else if(null!=request.getParameter("as_id")){
			String as_id=request.getParameter("as_id");
			applays a =  new PurDao().getapplaysById(as_id);
			l.add(a);
		}
		request.setAttribute("l", l);
		}
	public void addapplays(HttpServletRequest request, HttpServletResponse response){
		String as_id = request.getParameter("as_id");
		Date date = new Date();
		String as_man=request.getParameter("as_man");
		applays a = new applays(as_id,date,as_man, null, null, null);
		boolean boo = new PurDao().addapplays(a);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void editapplays(HttpServletRequest request, HttpServletResponse response){
		String as_id = request.getParameter("as_id");
		Date date = new Date();
		String as_man=request.getParameter("as_man");
		applays a = new applays(as_id,date,as_man, null, null, null);
		boolean boo = new PurDao().addapplays(a);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void deleteapplays(HttpServletRequest request, HttpServletResponse response){
		String as_id = request.getParameter("as_id");
		boolean boo = new PurDao().deleteapplays(as_id);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	//采购订单
	public List<purchase> getpurchaseList(HttpServletRequest request, HttpServletResponse response){
		int currentPageNum = Integer.parseInt(request.getParameter("currentPageNum"));
		PurPage pp=new PurPage();
		pp.setCurrentPageNum(currentPageNum);
		List<purchase> l=new PurDao().getpurchaseList();
		pp.setTotalNum(l.size());
		int start = (pp.getCurrentPageNum()-1)*pp.getCount();
		int end = pp.getCurrentPageNum() == pp.getTotalPage()?l.size():start+pp.getCount();
		List<purchase> l1=new ArrayList<purchase>();
		System.out.println(l.size());
		for(int i=start;i<end;i++){
			purchase p=l.get(i);
			l1.add(p);
		}
		request.setAttribute("pp", pp);
		return l1;
		
	} 
	public void getpurchasebyid(HttpServletRequest request, HttpServletResponse response){
		//调用dao里的相应方法
		List<purchase>  l  = new ArrayList<purchase>();
		if(null!=request.getParameter("selid")){
			String pur_id=request.getParameter("selid");
			purchase p =  new PurDao().getpurchaseById(pur_id);
			l.add(p);
		}
		else if(null!=request.getParameter("pur_id")){
			String pur_id=request.getParameter("pur_id");
			purchase p =  new PurDao().getpurchaseById(pur_id);
			l.add(p);
		}
		request.setAttribute("l", l);
		}
	public void addpurchase(HttpServletRequest request, HttpServletResponse response){
		Integer pur_id =Integer.parseInt(request.getParameter("pur_id"));
		String pur_com=request.getParameter("pur_com");
		Date date = new Date();
		String pur_man=request.getParameter("pur_man");
		String pur_status=request.getParameter("pur_status");
		purchase p= new purchase(pur_id,pur_com,date,pur_man,pur_status,date);
		boolean boo = new PurDao().addpurchase(p);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void editpurchase(HttpServletRequest request, HttpServletResponse response){
		Integer pur_id =Integer.parseInt(request.getParameter("pur_id"));
		String pur_com=request.getParameter("pur_com");
		Date date = new Date();
		String pur_man=request.getParameter("pur_man");
		String pur_status=request.getParameter("pur_status");
		purchase p= new purchase(pur_id,pur_com,date,pur_man,pur_status,date);
		boolean boo = new PurDao().addpurchase(p);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public void deletepurchase(HttpServletRequest request, HttpServletResponse response){
		int pur_id = Integer.parseInt(request.getParameter("pur_id"));
		boolean boo = new PurDao().deletepurchase(pur_id);
		if(boo){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	//订单接收
	public List<purchase> getpurchase_receiveList(HttpServletRequest request, HttpServletResponse response){
		int currentPageNum = Integer.parseInt(request.getParameter("currentPageNum"));
		PurPage pp=new PurPage();
		pp.setCurrentPageNum(currentPageNum);
		List<purchase> l=new PurDao().getpurchase_receiveList();
		pp.setTotalNum(l.size());
		int start = (pp.getCurrentPageNum()-1)*pp.getCount();
		int end = pp.getCurrentPageNum() == pp.getTotalPage()?l.size():start+pp.getCount();
		List<purchase> l1=new ArrayList<purchase>();
		System.out.println(l.size());
		for(int i=start;i<end;i++){
			purchase p=l.get(i);
			l1.add(p);
		}
		request.setAttribute("pp", pp);
		return l1;
		
	} 
	
	
	
	
	
	}

