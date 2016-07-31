package zhangjuan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.seat_wuliao;
import pojo.wuliao;
import unit.db;

public class pro_reject_dao {
   public List<wuliao> Getpros(){
	   List<wuliao> l=new ArrayList<wuliao>();
		 Connection conn=db.getConn();
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 String sql="select wuliao_id_gjh,wuliao_name_gjh  from  wuliao" ;
		 ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			while(rs.next()){
				 wuliao s=new wuliao();
				 s.setWulaio_id_gjh(rs.getInt("wuliao_id_gjh"));
				 s.setWulaio_name_gjh(rs.getString("wuliao_name_gjh"));
				 l.add(s);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //System.out.println("llllll"+l.size());
		  return l;
	   
   }
}
