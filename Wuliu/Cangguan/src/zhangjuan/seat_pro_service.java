package zhangjuan;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.depot;
import pojo.seat_wuliao;


public class seat_pro_service {
	 public List<seat_wuliao> getseat_pros(HttpServletRequest request, HttpServletResponse response){
		  List<seat_wuliao> l = null;
		try {
			
			
			l = new Seat_pro_dao().getseat_pro(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Integer d_id=Integer.parseInt(request.getParameter("d_id").trim());
		//System.out.println(d_id);
		  return l;
	  }
	 public seat_wuliao getSeat_pro(HttpServletRequest request, HttpServletResponse response){
		  Integer d_id=Integer.parseInt(request.getParameter("d_iid"));
		  //System.out.println(d_id);
		  seat_wuliao  sw=null;
		try {
			sw = new Seat_pro_dao().getseat_pro1(d_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return sw;
		
	  }
}
