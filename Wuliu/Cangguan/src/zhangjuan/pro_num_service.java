package zhangjuan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.pro_num_che;


public class pro_num_service {
	 public List<pro_num_che> getpc(HttpServletRequest request, HttpServletResponse response){
   	  List<pro_num_che> l = null;
   		l = new pro_num_dao().Getpcs();
   		//Integer d_id=Integer.parseInt(request.getParameter("d_id").trim());
   		//System.out.println(d_id);
   		  return l; 
}
}
