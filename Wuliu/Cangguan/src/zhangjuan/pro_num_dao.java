package zhangjuan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.pro_num_che;
import pojo.seat_wuliao;
import unit.db;

public class pro_num_dao {
     public List<pro_num_che> Getpcs(){
    	  List<pro_num_che> l=new ArrayList<pro_num_che>();
 		 Connection conn=db.getConn();
 		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		String	sql="select * from pro_num_che";

 		 ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		 try {
			while(rs.next()){
				pro_num_che pc=new pro_num_che();
				 pc.setPc_sid(rs.getInt("pc_sid"));
				 pc.setPc_pid(rs.getInt("pc_pid"));
				 pc.setPc_pname(rs.getString("pc_pname"));
				 pc.setPc_sname(rs.getString("pc_sname"));
				 pc.setPc_num(rs.getInt("pc_num"));
				 l.add(pc);
				//System.out.println(sw.getSp_pname());
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
 		  return l;
 		  
    	
     }
}
