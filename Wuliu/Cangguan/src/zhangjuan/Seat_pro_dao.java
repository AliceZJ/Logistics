package zhangjuan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.depot;
import pojo.regions;
import pojo.seat_wuliao;
import unit.db;

public class Seat_pro_dao {
	 public List<seat_wuliao> getseat_pro(Integer d_id) throws SQLException{
		  List<seat_wuliao> l=new ArrayList<seat_wuliao>();
		 Connection conn=db.getConn();
		 Statement st=conn.createStatement();
		 String sql="";
		 if(d_id==null){
			 sql="select * from seat_pro";
		 }
		 else {
			sql="select * from seat_pro where sp_seatid ="+d_id+"";
		}
		 ResultSet rs=st.executeQuery(sql);
		 while(rs.next()){
			 seat_wuliao sw=new seat_wuliao();
			 sw.setSp_pname(rs.getString("sp_pname"));
			 sw.setSp_proid(rs.getInt("sp_proid"));
			 sw.setSp_seatid(rs.getInt("sp_seatid"));
			 sw.setSp_sname(rs.getString("sp_sname"));
			 l.add(sw);
			System.out.println(sw.getSp_pname());
		 }
		 rs.close();
		 st.close();
		  return l;
		  
	 }
	 public seat_wuliao getseat_pro1(Integer d_id) throws SQLException{
		  seat_wuliao sw=new seat_wuliao();
		 Connection conn=db.getConn();
		 Statement st=conn.createStatement();
		 String sql="";
		 if(d_id==null){
			 sql="select * from seat_pro";
		 }
		 else {
			sql="select * from seat_pro where sp_seatid ="+d_id+"";
		}
		 ResultSet rs=st.executeQuery(sql);
		 if(rs.next()){
			 sw.setSp_pname(rs.getString("sp_pname"));
			 sw.setSp_proid(rs.getInt("sp_proid"));
			 sw.setSp_seatid(rs.getInt("sp_seatid"));
			 sw.setSp_sname(rs.getString("sp_sname"));
		 }
		 rs.close();
		 st.close();
		  return sw;
		  
	 }
	 
}
