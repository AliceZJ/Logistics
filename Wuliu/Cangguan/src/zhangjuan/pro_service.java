package zhangjuan;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pojo.depot;
import pojo.wuliao;

public class pro_service {
      public List<wuliao> Getpros(HttpServletRequest request, HttpServletResponse response){
    	  List<wuliao> l = null;
    		l = new pro_reject_dao().Getpros();
    		//Integer d_id=Integer.parseInt(request.getParameter("d_id").trim());
    		//System.out.println(d_id);
    		  return l; 
      }
      }
