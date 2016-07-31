package zhangjuan;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.depot;

public class Depotservice {
  public List<depot> getdepotList(HttpServletRequest request, HttpServletResponse response){
	  List<depot> l = null;
	try {
		
		
		l = new Depotdao().getDepots(null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Integer d_id=Integer.parseInt(request.getParameter("d_id").trim());
	//System.out.println(d_id);
	  return l;
  }
  public depot getdepot(HttpServletRequest request, HttpServletResponse response){
	  Integer d_id=Integer.parseInt(request.getParameter("d_iid"));
	  System.out.println(d_id);
	  depot d=null;
	try {
		d = new Depotdao().getDepot(d_id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return d;
	
  }
 
}
